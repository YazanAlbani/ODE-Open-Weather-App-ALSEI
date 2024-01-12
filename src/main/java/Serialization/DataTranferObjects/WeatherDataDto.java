package Serialization.DataTranferObjects;

import java.util.ArrayList;
import java.util.List;


/**
 * Klasse ist da um die Daten aus dem JSON abzubilden
 * Hat nur zwei Construktoren und einen Haufen Getter und Setter, keine "Logik" hier drinnen
 * Es wurde ein toSting eingefügt, zwecks debugging und Logging
 */
public class WeatherDataDto {
    private CloudsDto clouds;
    private List<WeatherDto> weather = new ArrayList<>();
    private String base;
    private MainDto main;
    private int visibility;
    private WindDto wind;

    private int dt;
    private SysDto sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    public WeatherDataDto(CloudsDto clouds, List<WeatherDto> weather, String base, MainDto main, int visibility, WindDto windDto, int dt, SysDto sys, int timezone, int id, String name, int cod) {
        this.clouds = clouds;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = windDto;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    /**
     *
     * Getter and Setter
     */
    public WeatherDataDto() {
    }

    public CloudsDto getClouds() {
        return clouds;
    }

    public void setClouds(CloudsDto clouds) {
        this.clouds = clouds;
    }

    public List<WeatherDto> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDto> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public MainDto getMain() {
        return main;
    }

    public void setMain(MainDto main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public WindDto getWind() {
        return wind;
    }

    public void setWind(WindDto wind) {
        this.wind = wind;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public SysDto getSys() {
        return sys;
    }

    public void setSys(SysDto sys) {
        this.sys = sys;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    /**
     * To String for debuggung
     */
    public String toString() {
        return "WeatherDataDto{" +
                "cloudsDto=" + clouds +
                ", weatherDtoList=" + weather +
                ", base='" + base + '\'' +
                ", mainDto=" + main +
                ", visibility=" + visibility +
                ", windDto=" + wind +
                ", dt=" + dt +
                ", sysDto=" + sys +
                ", timezone=" + timezone +
                ", id=" + id +
                ", city='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }
}
