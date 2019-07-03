package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Animation.Shake;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;

public class Controller {

    @FXML
    private ResourceBundle resources;
    ObservableList<String> list = FXCollections.observableArrayList();
    private int a;
    @FXML
    private URL location;
    private OutStreamHandler handler = new OutStreamHandler();

    @FXML
    private TextField firstText_Field;

    @FXML
    private Button ButtonEnter;

    @FXML
    private PasswordField firstPassword_Field;

    @FXML
    private ChoiceBox<String> ChoiceBox;

    @FXML
    void initialize() {
        loadData();
        ButtonEnter.setOnAction(event -> {
            // ButtonEnter.getScene().getWindow().hide();

            authentication();

        });

    }

    private String getChoice(javafx.scene.control.ChoiceBox<String> choiceBox) {
        return choiceBox.getValue();
    }

    private void authentication() {
        String loginText = firstText_Field.getText().trim();
        String loginPassword = firstPassword_Field.getText().trim();
        String adminLogin = "Admin";
        String adminPassword = "12345";

        if (loginText.equals(adminLogin) && loginPassword.equals(adminPassword)) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Admin.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Client");
            stage.showAndWait();
        } else {
            if (!loginText.equals("") && !loginPassword.equals("")) {
                loginUser(loginText, loginPassword);
            } else
                System.err.println("Login or Password is empty!");
        }

    }

    private void loadData() {
        list.clear();
        String t1 = "3-hour package - 600tg.";
        String t2 = "5-hour package - 1000tg.";
        String t3 = "package night(22:00 - 8:00) - 1500tg.";
        String t4 = "package morning (8: 00-13: 00) - 1200tg.";

        list.addAll(t1, t2, t3, t4);
        ChoiceBox.getItems().addAll(list);

    }

    private void loginUser(String loginText, String loginPassword) // checks if there is such a user in the database
    {
        DBManager dbManager = new DBManager();
        Computers comp = new Computers();
        dbManager.connect();
        comp.setLogin(loginText);
        comp.setPassword(loginPassword);
        ResultSet result = dbManager.getUser(comp);
        FXMLLoader loader = new FXMLLoader();
        System.out.println("GIGIGIGIGIIGIG");
        loader.setLocation(getClass().getResource("/sample/Client.fxml"));

        int count = 0;
        try {
            while (result.next())
                count++;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (count >= 1) {
            ButtonEnter.setOnAction(event -> {
                ButtonEnter.getScene().getWindow().hide();

                if (getChoice(ChoiceBox).equals("3-hour package - 600tg.")) {
                    int money1 = 600;
                    setA(3);
                    try {

                        handler.writeRequest("WRITE-OFF", new Computers(1, loginText, money1));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (getChoice(ChoiceBox).equals("5-hour package - 1000tg.")) {
                    int money1 = 1000;
                    setA(5);
                    try {
                        handler.writeRequest("WRITE-OFF", new Computers(1, loginText, money1));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (getChoice(ChoiceBox).equals("package night(22:00 - 8:00) - 1500tg.")) {
                    int money1 = 1500;

                    try {
                        handler.writeRequest("WRITE-OFF", new Computers(1, loginText, money1));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (getChoice(ChoiceBox).equals("package morning (8: 00-13: 00) - 1200tg.")) {
                    int money1 = 1200;

                    try {
                        handler.writeRequest("WRITE-OFF", new Computers(1, loginText, money1));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                ClientController client = loader.getController();
                client.setTimer(sendTo());
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();

            });

        } else {
            Shake userLoginAnim = new Shake(firstText_Field);
            Shake userPasswordAnim = new Shake(firstPassword_Field);
            userLoginAnim.playAnim();
            userPasswordAnim.playAnim();

            System.out.println("Wrong login or password!!!");
        }

    }

    public void setA(int a) {
        this.a = a;
    }

    public int sendTo() {
        return a;
    }

}
