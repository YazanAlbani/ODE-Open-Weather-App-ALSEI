package GUI;

import Serialization.DataTranferObjects.WeatherDataDto;

public class ImageHandler {

    /**
     *
     * @param weatherData Weather data that contain the weather conditions
     * @return an image URL corresponding to a weather condition, or a default in case nothing is found
     */
    public static String getImage(WeatherDataDto weatherData) {
        if (weatherData != null && weatherData.getWeather() != null && !weatherData.getWeather().isEmpty()) {
            // Get the icon from the first weather condition
            String icon = weatherData.getWeather().get(0).getIcon();
            return getImageByIconCode(icon);
        }
        return "images/01d.png";
    }

    /**
     *
     * @param icon Icon code that relates to specific weather conditions
     * @return an image URL corresponding to a weather condition, or a default in case nothing is found
     */
    public static String getImageByIconCode (String icon) {
        switch (icon){
            case "01d":
                return "images/01d.png";
            case "01n":
                return "images/01n.png";
            case "02d":
                return "images/02d.png";
            case "02n":
                return "images/02n.png";
            case "03d": case "03n":
                return "images/03.png";
            case "04d": case "04n":
                return "images/04.png";
            case "09d": case "09n":
                return "images/09.png";
            case "10d":
                return "images/10d.png";
            case "10n":
                return "images/10n.png";
            case "11n": case "11d":
                return "images/11.png";
            case "13d": case "13n":
                return "images/13.png";
            case "50d": case "50n":
                return "images/50.png";
        }
        return "images/01d.png";
    }

}
