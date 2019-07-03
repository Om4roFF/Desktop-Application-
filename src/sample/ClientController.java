package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ClientController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    private int a;

    @FXML
    public Text TimeText;



    @FXML
    void initialize() {

        TimeText.setText("Remaining time: "+this.a +" hours");
    }

    public void setTimer(int a)
    {
        this.a=a;
    }


}
