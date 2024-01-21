package File.IO;

import Serialization.DataTranferObjects.WeatherDataDto;
import Serialization.DataTranferObjects.WeatherDto;
import Serialization.JSONParser;
import Networking.APICall;
import Networking.APIgenerateURL;
import Networking.*;
import Serialization.DataTranferObjects.MainDto;
import java.time.*;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.reflect.Array.get;


public class FileIO {

        /**
         * Initializes the CSV file with column headers if the file does not exist.
         */
        public static void initToCSV(){
                String packagePath = "ODE-Open-Weather-App-ALSEI/src/main/java/WeatherData";
                String csvFileName = "WeatherData.csv";


                try (FileWriter csvWriter = new FileWriter(csvFileName,true)){
                        csvWriter.append("Temperature,Feels Like,Min Temperature,Max Temperature,Pressure,Humidity,TimeofCall\n");
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }


        /**
         * Writes weather data to the CSV file.
         *
         * @param weatherData The WeatherDataDto object containing weather information to be written.
         */
        public static void writeToCsv(WeatherDataDto weatherData){
                String packagePath = "ODE-Open-Weather-App-ALSEI/src/main/java/WeatherData";
                String csvFileName = "WeatherData.csv";


                try (FileWriter csvWriter = new FileWriter(csvFileName,true)){
                        //csvWriter.append("Temperature,Feels Like,Min Temperature,Max Temperature,Pressure,Humidity,TimeofCall\n");
                        csvWriter.append(String.format("%s\n", weatherData.getMain().toString() + "," + java.time.LocalTime.now().toString()));
                } catch (IOException e) {
                        e.printStackTrace();
                }

        }

}
