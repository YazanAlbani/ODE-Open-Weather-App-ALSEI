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
    private double latitude = 48.20;
    private double longitude = 16.37;
    private String unitFormat = "metric";
    private String apikey = "7088a0d768cf5ec98b6cd82e32d7b1b2";
    //URL weatherApiUrl = new URL();


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

    /**
     * default Constructor has a hardcoded request for Vienna
     */
    public APIgenerateURL() {
        weatherURL = "https://api.openweathermap.org/data/2.5/weather?lat=48.20&lon=16.37&appid=7088a0d768cf5ec98b6cd82e32d7b1b2&units=metric";
    }
    public String getURL(){
        return weatherURL;
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

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}
