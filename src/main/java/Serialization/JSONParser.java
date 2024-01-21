package Serialization;

import Serialization.DataTranferObjects.WeatherDataDto;
import Serialization.DataTranferObjects.WeatherForecastDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JSONParser {
    private String jsonData;
    private JsonMapper jsonMapper = JsonMapper.builder().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).build();

    public JSONParser(String jsonData) {
        this.jsonData = jsonData;
    }

    public WeatherDataDto parse(){
        try{
            return jsonMapper.readValue(jsonData, WeatherDataDto.class);
        } catch (JsonProcessingException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public WeatherForecastDto parseForecast(){
        try{
            return jsonMapper.readValue(jsonData,WeatherForecastDto.class);
        } catch (JsonProcessingException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
