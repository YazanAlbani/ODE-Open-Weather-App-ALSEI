package Networking;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import WeatherData.City;

public class JsonMapping {
    ObjectMapper mapper = new ObjectMapper();
    City city = new City();
    public void mapJsonStringToCityData(String inputData){

        try {
            city = mapper.readValue(inputData, City.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
