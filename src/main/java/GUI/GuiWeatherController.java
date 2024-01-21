package GUI;

import File.IO.FileIO;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.xml.namespace.QName;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static javafx.application.Application.launch;
public class GuiWeatherController {

    /**
     *  Executorservice used to manage and handle the threadpool
     */
    ExecutorService threadPool = Executors.newWorkStealingPool();

    /**
     * The data transfer object for storing weather forecast information.
     */
    WeatherForecastDto apiWeatherForecastData = new WeatherForecastDto();

    /**
     * The data transfer object for storing current weather information.
     */
    WeatherDataDto api = new WeatherDataDto();

    /**
     * The utility class for generating API URLs based on user inputs.
     */
    APIgenerateURL apiURL = new APIgenerateURL();

    @FXML
    public void initialize() {
        setButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setButton(event);
            }
        });

        FileIO.initToCSV();
        initCityDropDown();
        GUIApiCalls.runAPICall(api, apiURL);

    }

    // FXML elements
    @FXML
    public Button setButton;
    @FXML
    public Text tempText;
    @FXML
    public Label labelCurrentWeather;
    @FXML
    public Label labelAdditionalInformation;
    @FXML
    public Label labelWindSpeed;
    @FXML
    public  Text windSpeedText;
    @FXML
    public Label labelHumidity;
    @FXML
    public  Text humidityText;
    @FXML
    public Label labelFeelsLike;
    @FXML
    public  Text feelsLikeText;
    @FXML
    public ImageView img;


    @FXML
    public ChoiceBox choiceBoxSetCity;

    /**
     * Initializing the Citydropdown menu with a list of cities and setting
     * an eventhandler for the city selection
     */
    public void initCityDropDown() {

        choiceBoxSetCity.getItems().addAll(
                "Vienna", "St Poelten", "Eisenstadt", "Linz",
                "Graz", "Salzburg", "Innsbruck", "Bregenz"
        );
        choiceBoxSetCity.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleCitySelection(); // Call a method to handle city selection
            }
        });

    }

    /**
     * handles the city selection through the switch statement
     * sets the city based on the coordinates
     */
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

    /**
     * setButton gets the weather data from the api and sets them in the GUI as a string
     * @param event event The ActionEvent triggered by the button click.
     */
    @FXML
    public void setButton(ActionEvent event) {
        System.out.println("Button Event started");
        try {
            threadPool.execute(new Runnable() {

                public void run() {
                    api = GUIApiCalls.runAPICall(api, apiURL);
                    System.out.println(apiURL.getURL());
                    System.out.println(api.getMain().toString());
                    tempText.setText(api.getMain().getTemp() + "°");
                    windSpeedText.setText(api.getWind().getSpeed() + " kmh");
                    humidityText.setText(api.getMain().getHumidity() + " RH");
                    feelsLikeText.setText(api.getMain().getFeels_like() + "°");

                    String icon = ImageHandler.getImage(api);
                    img.setImage(new Image(icon));

                }
            });



        }catch(Exception e){
            System.out.println("Error multithread");
            e.printStackTrace();
        }

    }

}




