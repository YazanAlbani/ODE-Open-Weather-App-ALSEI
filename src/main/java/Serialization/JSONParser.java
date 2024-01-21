package Serialization;

import Serialization.DataTranferObjects.WeatherDataDto;
import Serialization.DataTranferObjects.WeatherForecastDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JSONParser {
    private String jsonData;

    /**
     * The Jackson ObjectMapper configured for parsing JSON data.
     */
    private JsonMapper jsonMapper = JsonMapper.builder().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).build();

    /**
     * Constructs a JSONParser with the specified JSON data.
     *
     * @param jsonData The JSON data to be parsed.
     */
    public JSONParser(String jsonData) {
        this.jsonData = jsonData;
    }

    /**
     * Parses the JSON data into a WeatherDataDto object.
     *
     * @return The WeatherDataDto object parsed from the JSON data.
     * @throws RuntimeException If an error occurs during JSON parsing.
     */
    public WeatherDataDto parse(){
        try{
            return jsonMapper.readValue(jsonData, WeatherDataDto.class);
        } catch (JsonProcessingException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * Parses the JSON data into a WeatherForecastDto object.
     *
     * @return The WeatherForecastDto object parsed from the JSON data.
     * @throws RuntimeException If an error occurs during JSON parsing.
     */
    public WeatherForecastDto parseForecast(){
        try{
            return jsonMapper.readValue(jsonData,WeatherForecastDto.class);
        } catch (JsonProcessingException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
