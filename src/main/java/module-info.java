module ODE.Open.Weather.App.ALSEI.main {


    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.fasterxml.jackson.databind;
    requires com.opencsv;

    opens org.example;
    /**
     *
     * Troubleshooting:
     *
     * Caused by: java.lang.IllegalArgumentException: Failed to call `setAccess()` on Constructor 'Serialization.DataTranferObjects.WeatherDataDto'
     * (of class `Serialization.DataTranferObjects.WeatherDataDto`) due to `java.lang.reflect.InaccessibleObjectException`,
     * problem: Unable to make public Serialization.DataTranferObjects.WeatherDataDto() accessible:
     * module ODE.Open.Weather.App.ALSEI.main does not "exports Serialization.DataTranferObjects" to module com.fasterxml.jackson.databind
     *
     * Try fixing it by following https://stackoverflow.com/questions/76552717/com-fasterxml-jackson-databind-exc-invaliddefinitionexception-invalid-type-defin
     */
    opens Serialization to com.fasterxml.jackson.databind;
    opens Serialization.DataTranferObjects to com.fasterxml.jackson.databind;
    opens GUI;

}