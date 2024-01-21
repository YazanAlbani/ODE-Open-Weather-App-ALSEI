package Serialization.DataTranferObjects;

import java.util.ArrayList;
import java.util.List;

public class WeatherForecastListItemDto {
    private int dt;
    private MainDto main;
    private List<WeatherDto> weather = new ArrayList<>();
    private CloudsDto clouds;
    private WindDto wind;
    private SysDto sys;

    private int visibility;
    private int pop;
    private String dt_text;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public MainDto getMain() {
        return main;
    }

    public void setMain(MainDto main) {
        this.main = main;
    }

    public List<WeatherDto> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDto> weather) {
        this.weather = weather;
    }

    public CloudsDto getClouds() {
        return clouds;
    }

    public void setClouds(CloudsDto clouds) {
        this.clouds = clouds;
    }

    public WindDto getWind() {
        return wind;
    }

    public void setWind(WindDto wind) {
        this.wind = wind;
    }

    public SysDto getSys() {
        return sys;
    }

    public void setSys(SysDto sys) {
        this.sys = sys;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public String getDt_text() {
        return dt_text;
    }

    public void setDt_text(String dt_text) {
        this.dt_text = dt_text;
    }

    @Override
    public String toString() {
        return "WeatherForecastListItemDto{" +
                "dt=" + dt +
                ", main=" + main.toStringAll() +
                ", weather=" + weather.toString() +
                ", clouds=" + clouds.toString() +
                ", wind=" + wind.toString() +
                ", sys=" + sys.toString() +
                ", visibility=" + visibility +
                ", pop=" + pop +
                ", dt_text='" + dt_text + '\'' +
                '}';
    }
}
