package GUI;

import Networking.APICall;
import Networking.APIgenerateURL;
import Serialization.DataTranferObjects.MainDto;
import Serialization.DataTranferObjects.WeatherDataDto;
import Serialization.JSONParser;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.xml.namespace.QName;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
public class GuiWeatherController {

    WeatherDataDto api;
    @FXML
    public void initialize() {
        System.out.println("second");
        APIgenerateURL generateURL = new APIgenerateURL();
        APICall firstCall = new APICall(generateURL.getURL());
        String textFromApi;
        firstCall.startCall();

        textFromApi =firstCall.getTextReadfromCall();
        System.out.println("URL is: " +firstCall.getCurrentURL());
        System.out.println(textFromApi);
        JSONParser jsonParser = new JSONParser(textFromApi);
        api = jsonParser.parse();

    }

    @FXML
    public Button setButton;
    @FXML
    public Label labelTempText;
    public Text tempText;

    @FXML
    public void setButton(ActionEvent event) {
        tempText.setText(String.valueOf(api.getMain().getTemp()));
        //labelTempText.setText("Byeeee");
    }

}
