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
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class TableViewController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> loginColumn;

    @FXML
    private TableColumn<?, ?> moneyColumn;

    @FXML
    private Button BackButton;

    @FXML
    private TableColumn<?, ?> passwordColumn;


    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    void initialize() {

//        try {
//            handler.GetAllRequest("LIST_USERS");
//            ArrayList<computers> comp ;
//
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void TableView(SortEvent<javafx.scene.control.TableView<?>> tableViewSortEvent) {

    }

    public void BackButton(ActionEvent actionEvent) {
        BackButton.setOnAction(event ->
        {
            BackButton.getScene().getWindow().hide();
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

}
