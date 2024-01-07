package WeatherData;

public class coord {
    private int lon;
    private int lat;

    public void setLon(int lon) {
        this.lon = lon;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLon() {
        return lon;
    }

    public int getLat() {
        return lat;
    }

    public coord(int lon, int lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public coord() {
    }

}
