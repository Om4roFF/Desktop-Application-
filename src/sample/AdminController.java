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
import javafx.stage.Stage;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ShowAllTarButton;

    @FXML
    private Button ShowAllAccButton;

    @FXML
    private Button DeleteAccButton;

    @FXML
    private Button Replenish;

    @FXML
    private Button AddNewAccButton;

    @FXML
    void AddNewAccount(ActionEvent event) {

        AddNewAccButton.setOnAction(actionEvent ->
        {
           // AddNewAccButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/AddNewAcc.fxml"));

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

    @FXML
    void ShowAllAcc(ActionEvent event) {
        ShowAllAccButton.setOnAction(actionEvent ->
        {
            //ShowAllAccButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/ShowAllAcc.fxml"));

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

    @FXML
    void DeleteAccount(ActionEvent event) {
        DeleteAccButton.setOnAction(actionEvent ->
        {
            //DeleteAccButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/DeleteAccount.fxml"));

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

    @FXML
    void ShowAllTariffs(ActionEvent event) {
        ShowAllTarButton.setOnAction(actionEvent ->
        {
            //ShowAllTarButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/AddNewAcc.fxml"));

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

    @FXML
    void ReplenishAccount(ActionEvent event) {
        Replenish.setOnAction(actionEvent ->
        {
           // Replenish.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Replenish.fxml"));

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
    @FXML
        void initialize() {

        }


}
