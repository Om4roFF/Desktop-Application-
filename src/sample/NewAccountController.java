package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewAccountController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NewPasswordField;

    @FXML
    private Button OkButton;

    @FXML
    private TextField MoneyTextField;

    @FXML
    private TextField NewLoginTextField;
    private OutStreamHandler handler = new OutStreamHandler();

    @FXML
    void initialize() {

       OkButton.setOnAction(actionEvent ->{
           //signUpNewUser();
           String login = NewLoginTextField.getText();
           System.out.println(login);
           String password = NewPasswordField.getText();
           String money = MoneyTextField.getText();
           int money1 = Integer.parseInt(money);
           try {
               handler.writeRequest("ADD_USERS",new Computers(1,login,password,money1));
           } catch (IOException e) {
               e.printStackTrace();
           }
           MoneyTextField.clear();
           NewPasswordField.clear();
           NewLoginTextField.clear();
       });
    }
}
