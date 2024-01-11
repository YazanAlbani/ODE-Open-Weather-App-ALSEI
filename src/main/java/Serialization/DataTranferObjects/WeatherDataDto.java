package Serialization.DataTranferObjects;
import Serialization.DataTranferObjects.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Klasse ist da um die Daten aus dem JSON abzubilden
 * Hat nur zwei Construktoren und einen Haufen Getter und Setter, keine "Logik" hier drinnen
 * Es wurde ein toSting eingefügt, zwecks debugging und Logging
 */
public class WeatherDataDto {
    private CloudsDto cloudsDto;
    private List<WeatherDto> weatherDtoList = new ArrayList<>();
    private String base;
    private MainDto mainDto;
    private int visibility;
    private WindDto windDto;
    private CloudsDto couldsDto;

    private int dt;
    private SysDto sysDto;
    private int timezone;
    private int id;
    private String city;
    private int cod;

    public WeatherDataDto(CloudsDto cloudsDto, List<WeatherDto> weatherDtoList, String base, MainDto mainDto, int visibility, WindDto windDto, CloudsDto couldsDto, int dt, SysDto sysDto, int timezone, int id, String city, int cod) {
        this.cloudsDto = cloudsDto;
        this.weatherDtoList = weatherDtoList;
        this.base = base;
        this.mainDto = mainDto;
        this.visibility = visibility;
        this.windDto = windDto;
        this.couldsDto = couldsDto;
        this.dt = dt;
        this.sysDto = sysDto;
        this.timezone = timezone;
        this.id = id;
        this.city = city;
        this.cod = cod;
    }

    /**
     *
     * Getter and Setter
     */
    public WeatherDataDto() {
    }

    public CloudsDto getCloudsDto() {
        return cloudsDto;
    }

    public void setCloudsDto(CloudsDto cloudsDto) {
        this.cloudsDto = cloudsDto;
    }

    public List<WeatherDto> getWeatherDtoList() {
        return weatherDtoList;
    }

    public void setWeatherDtoList(List<WeatherDto> weatherDtoList) {
        this.weatherDtoList = weatherDtoList;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public MainDto getMainDto() {
        return mainDto;
    }

    public void setMainDto(MainDto mainDto) {
        this.mainDto = mainDto;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public WindDto getWindDto() {
        return windDto;
    }

    public void setWindDto(WindDto windDto) {
        this.windDto = windDto;
    }

    public CloudsDto getCouldsDto() {
        return couldsDto;
    }

    public void setCouldsDto(CloudsDto couldsDto) {
        this.couldsDto = couldsDto;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public SysDto getSysDto() {
        return sysDto;
    }

    public void setSysDto(SysDto sysDto) {
        this.sysDto = sysDto;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
                "cloudsDto=" + cloudsDto +
                ", weatherDtoList=" + weatherDtoList +
                ", base='" + base + '\'' +
                ", mainDto=" + mainDto +
                ", visibility=" + visibility +
                ", windDto=" + windDto +
                ", couldsDto=" + couldsDto +
                ", dt=" + dt +
                ", sysDto=" + sysDto +
                ", timezone=" + timezone +
                ", id=" + id +
                ", city='" + city + '\'' +
                ", cod=" + cod +
                '}';
    }
}
