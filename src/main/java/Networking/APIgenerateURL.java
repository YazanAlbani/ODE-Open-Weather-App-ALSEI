package Networking;

/**
 * Take initial parameters like latitude and longitude and is used to return a string with the URL to call
 * API Key is hardcoded
 */
public class APIgenerateURL {
    /**
     *  Initial varaibles:
     *  Hardcoded start of Link to the open weather IP
     *  Coordinates and additional Data has to be appended to the URL
     *  String will then be given to create URL Object
     *
     *  Lat and long are coordinates
     *  Apikey is a specific key to accesss the open weather API
     *
     *
     *  Example Call: https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid={API key}
     *
     *  There are default values to reduce issues with URL building in case of incomplete datainput
     */

    private String weatherURL = "https://api.openweathermap.org/data/2.5/weather?";
    private String weatherURLBase = "https://api.openweathermap.org/data/2.5/weather?";
    private double latitude = 48.20;
    private double longitude = 16.37;
    private String unitFormat = "metric";
    private String apikey = "7088a0d768cf5ec98b6cd82e32d7b1b2";
    //URL weatherApiUrl = new URL();
    private String forecastWeatherURL = "https://api.openweathermap.org/data/2.5/forecast/daily?";
    private int amountForecastDays = 7;
    private boolean lastCallForecast = false;
    /**
     * This contstructor is used to take the parameters mentioned in the @param fields and creates String that can be returned by getURL
     * @param latitude
     * @param longitude
     * @param unitFormat    can be standard metric or imperial
     */
    public APIgenerateURL(int latitude, int longitude, String unitFormat) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.unitFormat = unitFormat;
        this.weatherURL = this.weatherURL  + "lat=" + this.latitude + "&lon=" + this.longitude +  "&appid=" + apikey + "&units=" + unitFormat;
    }

    public String getForecastURL() {
        lastCallForecast = true;
        return forecastWeatherURL  + "lat=" + latitude + "&lon=" + longitude + "&appid=" + apikey + "&units=" + unitFormat;
    }

    /**
     * default Constructor has a hardcoded request for Vienna
     */
    public APIgenerateURL() {
        weatherURL = "https://api.openweathermap.org/data/2.5/weather?lat=48.20&lon=16.37&appid=7088a0d768cf5ec98b6cd82e32d7b1b2&units=metric";
    }
    public void genereateURL(){
        weatherURL = weatherURLBase  + "lat=" + latitude + "&lon=" + longitude +  "&appid=" + apikey + "&units=" + unitFormat;
    }

    public String getURL(){
        lastCallForecast = true;
        return weatherURL;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setWeatherURL(String weatherURL) {
        this.weatherURL = weatherURL;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setUnitFormat(String unitFormat) {
        this.unitFormat = unitFormat;
    }

    public void setAmountForecastDays(int amountForecastDays) {
        this.amountForecastDays = amountForecastDays;
    }

    public String APIgenerateForecastURL() {
        return forecastWeatherURL  + "lat=" + latitude + "&lon=" + longitude + "&cnt=" + amountForecastDays + "&appid=" + apikey + "&units=" + unitFormat;
    }
    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public boolean isLastCallForecast() {
        return lastCallForecast;
    }


    public void setCoordinatesVienna(){
        this.setLatitude(48.20);
        this.setLongitude(16.37);
    }
    public void setCoordinatesLinz(){
        this.setLatitude(48.31);
        this.setLongitude(14.28);
    }
    public void setCoordinatesSalzburg(){
        this.setLatitude(47.81);
        this.setLongitude(13.03);
    }
    public void setCoordinatesGraz(){
        this.setLatitude(47.07);
        this.setLongitude(15.42);
    }
    public void setCoordinatesKlagenfurth(){
        this.setLatitude(46.62);
        this.setLongitude(14.31);
    }
    public void setCoordinatesBregenz(){
        this.setLatitude(47.50);
        this.setLongitude(9.74);
    }
    public void setCoordinatesStPoelten(){
        this.setLatitude(48.22);
        this.setLongitude(15.61);
    }
    public void setCoordinatesEisenstadt(){
        this.setLatitude(47.84);
        this.setLongitude(16.52);
    }
    public void setCoordinatesInnsbruck(){
        this.setLatitude(47.26);
        this.setLongitude(11.39);
    }
}
