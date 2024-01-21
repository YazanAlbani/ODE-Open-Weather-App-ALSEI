package org.example;
import GUI.GUIApiCalls;
import Networking.*;
import Serialization.*;
import Serialization.DataTranferObjects.WeatherDataDto;
import Serialization.DataTranferObjects.WeatherDto;
import Serialization.DataTranferObjects.WeatherForecastDto;
import GUI.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    /**
     * entry point for the JavaFX
     * Init the main stages and load the FXML file
     * displays the GUI
     *
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws IOException If an error occurs
     */
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Weather Report");
        Image image = new Image("images/background.jpg");
        ImageView mv = new ImageView(image);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}