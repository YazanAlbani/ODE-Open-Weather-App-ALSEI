package GUI;

import Networking.APICall;
import Networking.APIgenerateURL;
import Serialization.DataTranferObjects.MainDto;
import Serialization.DataTranferObjects.WeatherDataDto;
import Serialization.DataTranferObjects.WeatherForecastDto;
import Serialization.JSONParser;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.xml.namespace.QName;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static javafx.application.Application.launch;
public class GuiWeatherController {

    ExecutorService threadPool = Executors.newWorkStealingPool();
    WeatherDataDto api = new WeatherDataDto();
    WeatherForecastDto apiWeatherForecastData = new WeatherForecastDto();
    APIgenerateURL apiURL = new APIgenerateURL();

    @FXML
    public void initialize() {
        setButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setButton(event);
            }
        });


        initCityDropDown();
        GUIApiCalls.runAPICall(api, apiURL);
    }

    @FXML
    public Button setButton;
    @FXML
    public Label labelTempText;
    public Text tempText;

    @FXML
    public ChoiceBox choiceBoxSetCity;

    public void initCityDropDown() {

        choiceBoxSetCity.getItems().addAll(
                "Vienna", "St Poelten", "Eisenstadt", "Linz",
                "Graz", "Salzburg", "Innsbruck", "Bregenz"
        );
        // Add an EventHandler for the city selection
        choiceBoxSetCity.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleCitySelection(); // Call a method to handle city selection
            }
        });

    }
    private void handleCitySelection() {
        String selectedCity = (String) choiceBoxSetCity.getValue();

        APIgenerateURL apIgenerateURL = new APIgenerateURL();

        double latitude = 0.0;
        double longitude = 0.0;

        // Set coordinates based on the selected city
        switch (selectedCity) {
            case "Vienna":
                apiURL.setCoordinatesVienna();
                break;
            case "Linz":
                apiURL.setCoordinatesLinz();
                break;
            case "Salzburg":
                apiURL.setCoordinatesSalzburg();
                System.out.println(apiURL.getLatitude());
                break;
            case "Graz":
                apiURL.setCoordinatesGraz();
                break;
            case "Klagenfurt":
                apiURL.setCoordinatesKlagenfurth();
                break;
            case "Bregenz":
                apiURL.setCoordinatesBregenz();
                break;
            case "St Poelten":
                apiURL.setCoordinatesStPoelten();
                break;
            case "Eisenstadt":
                apiURL.setCoordinatesEisenstadt();
                break;
            case "Innsbruck":
                apiURL.setCoordinatesInnsbruck();
                break;
            default:
                break;
        }
        apiURL.genereateURL();
    }
    @FXML
    public void setButton(ActionEvent event) {
        System.out.println("Button Event started");
        setButton.setText("Hallo");
        try {
            threadPool.execute(new Runnable() {

                public void run() {
                    api = GUIApiCalls.runAPICall(api, apiURL);
                    System.out.println(apiURL.getURL());
                    System.out.println(api.getMain().toString());
                    tempText.setText(String.valueOf(api.getMain().getTemp()));
                    System.out.println(api.getMain().getTemp());
                }
            });

            //labelTempText.setText("Byeeee");
        }catch(Exception e){
            System.out.println("Error multithread");
            e.printStackTrace();
        }

    }

}




