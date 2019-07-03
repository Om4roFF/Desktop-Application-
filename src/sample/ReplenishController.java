package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ReplenishController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ReplenishLoginButton;

    @FXML
    private TextField ReplenishMoneyButton;

    @FXML
    private Button BackButton;


    @FXML
    private Button OkButton;
    private OutStreamHandler handler = new OutStreamHandler();

    @FXML
    void initialize() {

    }

    public void BackButton(javafx.event.ActionEvent actionEvent) {
        BackButton.setOnAction(event ->
        {
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
            stage.showAndWait();
        });
    }

    public void OkButton(ActionEvent actionEvent) {
        DBManager dbManager = new DBManager();
        dbManager.connect();
        System.out.println("HELLLLO!!!");
        OkButton.setOnAction(event->{
            //signUpNewUser();
            String login= ReplenishLoginButton.getText().trim();
            String money = ReplenishMoneyButton.getText().trim();
            int money1=Integer.parseInt(money);
            try {
                handler.writeRequest("Replenish",new Computers(1,login,money1));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ReplenishLoginButton.clear();
            ReplenishMoneyButton.clear();

        });


    }
}
