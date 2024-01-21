package GUI;

import Networking.APICall;
import Networking.APIgenerateURL;
import Serialization.DataTranferObjects.WeatherDataDto;
import Serialization.DataTranferObjects.WeatherForecastDto;
import Serialization.JSONParser;

public class GUIApiCalls {

    /**
     *
     * @param apiWeatherObjectData Object the json data will be written to
     * @param generateURL          API object with which we start the call -> param because for example lon and lat can be changed from GUI
     */
    static public void runAPICall(WeatherDataDto apiWeatherObjectData, APIgenerateURL generateURL){

        APICall firstCall = new APICall(generateURL.getURL());
        String textFromApi;
        firstCall.startCall();

        textFromApi = firstCall.getTextReadfromCall();

        JSONParser jsonParser = new JSONParser(textFromApi);

        apiWeatherObjectData = jsonParser.parse();
    }


    /**
     *
     * @param apiWeatherForecastDto Object the json data will be written to
     * @param generateURL           API object with which we start the call -> param because for example lon and lat can be changed from GUI
     */

    static public void runAPICallForecast(WeatherForecastDto apiWeatherForecastDto, APIgenerateURL generateURL){

        APICall firstCall = new APICall(generateURL.getForecastURL());
        String textFromApi;
        firstCall.startCall();

        textFromApi = firstCall.getTextReadfromCall();

        JSONParser jsonParser = new JSONParser(textFromApi);
        apiWeatherForecastDto = jsonParser.parseForecast();


    }
}
