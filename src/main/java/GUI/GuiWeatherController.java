package GUI;

import Networking.APICall;
import Networking.APIgenerateURL;
import Serialization.DataTranferObjects.MainDto;
import Serialization.DataTranferObjects.WeatherDataDto;
import Serialization.DataTranferObjects.WeatherForecastDto;
import Serialization.JSONParser;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.xml.namespace.QName;
import java.beans.ExceptionListener;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static javafx.application.Application.launch;
public class GuiWeatherController {


    ExecutorService threadPool = Executors.newWorkStealingPool();
    WeatherDataDto api = new WeatherDataDto();
    WeatherForecastDto apiWeatherForecastData = new WeatherForecastDto();
    APIgenerateURL apiURL = new APIgenerateURL();;
    @FXML
    public void initialize() {
        initCityDropDown();
        System.out.println("second");

    }

    @FXML
    public Button setButton;
    @FXML
    public Label labelTempText;
    public Text tempText;

    @FXML
    public ChoiceBox choiceBoxSetCity;

    public void initCityDropDown() {
        choiceBoxSetCity.getItems().add("Vienna");
        choiceBoxSetCity.getItems().add("St Poelten");
        choiceBoxSetCity.getItems().add("Eisenstadt");
        choiceBoxSetCity.getItems().add("Linz");
        choiceBoxSetCity.getItems().add("Graz");
        choiceBoxSetCity.getItems().add("Salzburg");
        choiceBoxSetCity.getItems().add("Innsbruck");
        choiceBoxSetCity.getItems().add("Bregenz");
    }


    @FXML
    public void setButton(ActionEvent event) {
        try {
            threadPool.execute(new Runnable() {

                public void run() {
                    GUIApiCalls.runAPICall(api, apiURL);
                    tempText.setText(String.valueOf(api.getMain().getTemp()));
                }
            });

            //labelTempText.setText("Byeeee");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
