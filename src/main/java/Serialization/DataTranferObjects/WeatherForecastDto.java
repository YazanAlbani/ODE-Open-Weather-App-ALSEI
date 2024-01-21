package Serialization.DataTranferObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class WeatherForecastDto {
    private int cod;
    private String message;
    private int cnt;

    private List<WeatherForecastListItemDto> list = new ArrayList<>();
    private CityDto city;


    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<WeatherForecastListItemDto> getList() {
        return list;
    }

    public void setList(List<WeatherForecastListItemDto> list) {
        this.list = list;
    }

    public CityDto getCity() {
        return city;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }


    @Override
    public String toString() {
        String listString = "";

        ListIterator<WeatherForecastListItemDto> listIterator = list.listIterator();

        while(listIterator.hasNext()) {
            listString = listString + listIterator.toString();
            listIterator.next();
        }

        return "WeatherForecastDto{" +
                "cod=" + cod +
                ", message='" + message + '\'' +
                ", cnt=" + cnt +
                ", list=" + listString +
                ", city=" + city +
                '}';
    }
}
