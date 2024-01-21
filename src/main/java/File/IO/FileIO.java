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
         * @brief static meth
         */
        public static void initToCSV(){
                String packagePath = "ODE-Open-Weather-App-ALSEI/src/main/java/WeatherData";
                String csvFileName = "WeatherData.csv";


                try (FileWriter csvWriter = new FileWriter(csvFileName,true)){
                        csvWriter.append("Temperature,Feels Like,Min Temperature,Max Temperature,Pressure,Humidity,TimeofCall\n");
                } catch (IOException e) {
                        e.printStackTrace();
                }

                /*try (CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFileName))){
                        csvWriter.add("Temperature,Feels Like,Min Temperature,Max Temperature,Pressure,Humidity,TimeofCall\n");
                        csvWriter.add(String.format("%s\n", weatherData.getMain().toString() + "," + java.time.LocalTime.now().toString()));
                        csvWriter.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }*/
        }


        public static void writeToCsv(WeatherDataDto weatherData){
                String packagePath = "ODE-Open-Weather-App-ALSEI/src/main/java/WeatherData";
                String csvFileName = "WeatherData.csv";


                try (FileWriter csvWriter = new FileWriter(csvFileName,true)){
                        //csvWriter.append("Temperature,Feels Like,Min Temperature,Max Temperature,Pressure,Humidity,TimeofCall\n");
                        csvWriter.append(String.format("%s\n", weatherData.getMain().toString() + "," + java.time.LocalTime.now().toString()));
                } catch (IOException e) {
                        e.printStackTrace();
                }

                /*try (CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFileName))){
                        csvWriter.add("Temperature,Feels Like,Min Temperature,Max Temperature,Pressure,Humidity,TimeofCall\n");
                        csvWriter.add(String.format("%s\n", weatherData.getMain().toString() + "," + java.time.LocalTime.now().toString()));
                        csvWriter.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }*/
        }

}
