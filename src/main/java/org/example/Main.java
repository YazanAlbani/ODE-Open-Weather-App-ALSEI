package org.example;
import GUI.GUIApiCalls;
import Networking.*;
import Serialization.*;
import Serialization.DataTranferObjects.WeatherDataDto;
import Serialization.DataTranferObjects.WeatherDto;
import Serialization.DataTranferObjects.WeatherForecastDto;

public class Main {
    public static void main(String[] args) {

        /**
         * Erster Sample Call der API
         * Hier wird die URL generiert und der Call ausgeführt
         * in den Prints wird die URL ausgegeben und der Rückgabewert der API als String
         */
        APIgenerateURL generateURL = new APIgenerateURL();

        /*APICall firstCall = new APICall(generateURL.getURL());
        String textFromApi;
        firstCall.startCall();

        textFromApi = firstCall.getTextReadfromCall();
        System.out.println("URL is: " + firstCall.getCurrentURL());
        System.out.println(textFromApi);*/


        APICall firstCall = new APICall(generateURL.getForecastURL());
        String textFromApi;
        firstCall.startCall();

        textFromApi = firstCall.getTextReadfromCall();
        System.out.println("URL is: " + firstCall.getCurrentURL());
        System.out.println(textFromApi);


        /**
         * Hier wird das Parsen der Daten in die Objekte (Dtos -> Data Transfer Objekts) durchgeführt
         * Problem: com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Failed to call `setAccess()` on Constructor 'Serialization.DataTranferObjects.WeatherDataDto'
         *
         * Ich probiers mal mit https://stackoverflow.com/questions/76552717/com-fasterxml-jackson-databind-exc-invaliddefinitionexception-invalid-type-defin zu fixen
         *
         */
        /*
        if(generateURL.isLastCallForecast()){
            JSONParser jsonParser = new JSONParser(textFromApi);
            WeatherForecastDto apiWeatherForecastDto = jsonParser.parseForecast();
            System.out.println();
            System.out.println(apiWeatherForecastDto.toString());


        }
         else{
            JSONParser jsonParser = new JSONParser(textFromApi);

            WeatherDataDto apiWeatherObjectData = jsonParser.parse();
            System.out.println();
            System.out.println(apiWeatherObjectData.toString());
        }*/
        generateURL = new APIgenerateURL();
        WeatherDataDto weatherDataDto = new WeatherDataDto();
        weatherDataDto = GUIApiCalls.runAPICall(weatherDataDto, generateURL);
        System.out.println(weatherDataDto.getMain().toString());

    }
}