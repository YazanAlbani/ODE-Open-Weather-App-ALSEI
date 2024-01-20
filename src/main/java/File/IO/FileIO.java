package File.IO;

import Serialization.DataTranferObjects.WeatherDataDto;
import Serialization.DataTranferObjects.WeatherDto;
import Serialization.JSONParser;
import Networking.APICall;
import Networking.APIgenerateURL;
import Networking.*;
import Serialization.DataTranferObjects.MainDto;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.reflect.Array.get;

public class FileIO {


        public static void main(String[] args) throws IOException{
                String packagePath = "ODE-Open-Weather-App-ALSEI/src/main/java/WeatherData";
                String csvFileName = "WeatherData.csv";
                String apiURL = "https://api.openweathermap.org/data/2.5/weather?lat=48.20&lon=16.37&appid=7088a0d768cf5ec98b6cd82e32d7b1b2&units=metric";
                MainDto mainDto = new MainDto();

                APICall apiCall = new APICall(apiURL);

                apiCall.startCall();

                String jsonData = apiCall.getTextReadfromCall();
                JSONParser jsonParser = new JSONParser(jsonData);
                WeatherDataDto weatherData = jsonParser.parse();
                System.out.println(jsonData);
                System.out.println(weatherData.getMain().toString());

                try (FileWriter csvWriter = new FileWriter(csvFileName)){

                        csvWriter.append("Temperature,Feels Like,Min Temperature,Max Temperature,Pressure,Humidity\n");

                        csvWriter.append(String.format("%s\n", weatherData.getMain().toString()));
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }



}
