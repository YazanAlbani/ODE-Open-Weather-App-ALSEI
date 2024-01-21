package Serialization.DataTranferObjects;


//Wird von der Weather API für den Forecast verwendet
public class CityDto {
    private int id;
    private String name;
    private CoordDto coord;
    private String Country;
    private int population;
    private int timezone;
    private int sunrise;
    private int sunset;

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

    public CoordDto getCoord() {
        return coord;
    }

    public void setCoord(CoordDto coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "" + id +
                ",'" + name + '\'' +
                "," + coord +
                ",'" + Country + '\'' +
                "," + population +
                "," + timezone +
                "," + sunrise +
                "," + sunset +
                '}';
    }
}
