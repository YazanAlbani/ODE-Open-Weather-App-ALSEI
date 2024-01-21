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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.scene.image.Image;

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
        try {
            setButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setButton(event);
                }
            });
        }catch (Exception e){        }

        try {
            changeView.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    changeView(event);
                }
            });
        }catch (Exception e){

        }
        try {
            initCityDropDown();
        }catch (Exception e){

        }

        try {
            initCityDropDownForecast();
        }catch (Exception e){

        }
        try {
            setButtonForecast.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setButtonForecast(event);
                }
            });
        }catch (Exception e){

        }
        try {
            changeViewForecast.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    changeViewForecast(event);
                }
            });
        }
        catch (Exception e){

        }
        FileIO.initToCSV();
        GUIApiCalls.runAPICall(api, apiURL);

    }


    // FXML elements



    @FXML
    public Button setButtonForecast;
    @FXML
    public Button changeViewForecast;
    @FXML
    public Button changeView;
    @FXML
    public ChoiceBox choiceBoxSetCityForecast;
    @FXML
    public AnchorPane defaultPane;
    @FXML
    public TextArea forecastTextField;
    @FXML
    public AnchorPane forecastPane;



    WeatherForecastDto apiForecast = new WeatherForecastDto();



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

    public void initCityDropDownForecast() {

        choiceBoxSetCityForecast.getItems().addAll(
                "Vienna", "St Poelten", "Eisenstadt", "Linz",
                "Graz", "Salzburg", "Innsbruck", "Bregenz"
        );
        // Add an EventHandler for the city selection
        choiceBoxSetCityForecast.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleCitySelectionForecast(); // Call a method to handle city selection
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


    /**
     * setButton gets the weather data from the api and sets them in the GUI as a string
     * @param event event The ActionEvent triggered by the button click.
     */

    private void handleCitySelectionForecast() {
        String selectedCity = (String) choiceBoxSetCityForecast.getValue();

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
        try {
            threadPool.execute(new Runnable() {

                public void run() {
                    api = GUIApiCalls.runAPICall(api, apiURL);

                    updateBaseGUI(api);

                    String icon = ImageHandler.getImage(api);
                    img.setImage(new Image(icon));

                }
            });



        }catch(Exception e){
            System.out.println("Error multithread");
            e.printStackTrace();
        }

    }
    private void setButtonForecast(ActionEvent event) {
        try {
            threadPool.execute(new Runnable() {

                public void run() {
                    apiForecast = GUIApiCalls.runAPICallForecast(apiForecast, apiURL);
                    forecastTextField.setText(apiForecast.toString());

                }
            });

        }catch(Exception e){
            System.out.println("Error multithread");
            e.printStackTrace();
        }
    }
    private void changeViewForecast(ActionEvent event) {
        switchPanetodefault ();
    }
    private void changeView(ActionEvent event) {
        switchPanetoForecast();
    }



    public void updateBaseGUI(WeatherDataDto api){
        tempText.setText(String.valueOf(api.getMain().getTemp()) + "°");
        windSpeedText.setText(String.valueOf(api.getWind().getSpeed())+ " kmh");
        humidityText.setText(String.valueOf(api.getMain().getHumidity()) + " RH");
        feelsLikeText.setText(String.valueOf(api.getMain().getFeels_like()) + "°");
    }
    public void switchPanetoForecast (){

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("AnchorPaneForecast.fxml"));

        try {
            forecastPane = (AnchorPane) loader.load();
            defaultPane.getChildren().clear();
            defaultPane.getChildren().add(forecastPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void switchPanetodefault (){
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("sample.fxml"));

        try {
            Pane pane = (Pane) loader.load();

            forecastPane.getChildren().clear();
            forecastPane.getChildren().add(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}




