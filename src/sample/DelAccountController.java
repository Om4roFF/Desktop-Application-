package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DelAccountController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField DelAccTextField;

    @FXML
    private Button OkButton;
    private OutStreamHandler handler = new OutStreamHandler();

    @FXML
    void initialize() {

    }

    public void OkButton(ActionEvent actionEvent) {
        OkButton.setOnAction(event ->{
            String login = DelAccTextField.getText().trim();
            System.out.println("HI");
            try {
                handler.writeRequestWithLogin("DELETE",login);
            } catch (IOException e) {
                e.printStackTrace();
            }
            DelAccTextField.clear();

        });
    }
}
