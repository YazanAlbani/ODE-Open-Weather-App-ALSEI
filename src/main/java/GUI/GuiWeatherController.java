package GUI;

import Networking.APICall;
import Networking.APIgenerateURL;
import Serialization.DataTranferObjects.CoordDto;
import Serialization.DataTranferObjects.MainDto;
import Serialization.DataTranferObjects.WeatherDataDto;
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
import static javafx.application.Application.launch;
public class GuiWeatherController {

    WeatherDataDto api;
    private APIgenerateURL apiGenerateURL = new APIgenerateURL();

    @FXML
    public void initialize() {

        initCityDropDown();

        System.out.println("second");
        APIgenerateURL generateURL = new APIgenerateURL();
        APICall firstCall = new APICall(generateURL.getURL());
        String textFromApi;
        firstCall.startCall();

        textFromApi = firstCall.getTextReadfromCall();
        System.out.println("URL is: " + firstCall.getCurrentURL());
        System.out.println(textFromApi);
        JSONParser jsonParser = new JSONParser(textFromApi);
        api = jsonParser.parse();

    }

    @FXML
    public Button setButton;
    @FXML
    public Label labelCurrentWeather;
    @FXML
    public Label labelToday;
    @FXML
    public Text tempText;
    @FXML
    public Label labelAdditionalInformation;
    @FXML
    public Label labelWindSpeed;
    @FXML
    public Text windSpeedText;
    @FXML
    public Label labelHumidity;
    @FXML
    public Text humidityText;
    @FXML
    public Label labelFeelsLike;
    @FXML
    public Text feelsLikeText;

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
                apiGenerateURL.setCoordinatesVienna();
                break;
            case "Linz":
                apiGenerateURL.setCoordinatesLinz();
                break;
            case "Salzburg":
                apiGenerateURL.setCoordinatesSalzburg();
                break;
            case "Graz":
                apiGenerateURL.setCoordinatesGraz();
                break;
            case "Klagenfurt":
                apiGenerateURL.setCoordinatesKlagenfurth();
                break;
            case "Bregenz":
                apiGenerateURL.setCoordinatesBregenz();
                break;
            case "St Poelten":
                apiGenerateURL.setCoordinatesStPoelten();
                break;
            case "Eisenstadt":
                apiGenerateURL.setCoordinatesEisenstadt();
                break;
            case "Innsbruck":
                apiGenerateURL.setCoordinatesInnsbruck();
                break;
            default:
                break;
        }

        try {
            apiGenerateURL.genereateURL();
            APICall firstCall = new APICall(apiGenerateURL.getURL());
            String textFromApi;
            firstCall.startCall();

            textFromApi = firstCall.getTextReadfromCall();
            System.out.println("URL is: " + firstCall.getCurrentURL());
            System.out.println(textFromApi);
            JSONParser jsonParser = new JSONParser(textFromApi);
            api = jsonParser.parse();

            tempText.setText(String.valueOf(api.getMain().getTemp()));
            windSpeedText.setText(String.valueOf(api.getWind().getSpeed()));
            humidityText.setText(String.valueOf(api.getMain().getHumidity()));
            feelsLikeText.setText(String.valueOf(api.getMain().getFeels_like()));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
