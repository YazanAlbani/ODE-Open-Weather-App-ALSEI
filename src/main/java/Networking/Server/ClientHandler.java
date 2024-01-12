package Networking.Server;

import Networking.APICall;
import Networking.APIgenerateURL;
import Serialization.DataTranferObjects.WeatherDataDto;
import Serialization.JSONParser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.fasterxml.jackson.databind.*;

public class ClientHandler extends Thread{
    final DataInputStream inputStream;
    final DataOutputStream outputStream;
    final Socket socke;

    private APIgenerateURL apiURL = new APIgenerateURL();
    private ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

    private String json;

    public ClientHandler(Socket socke, DataInputStream inputStream, DataOutputStream outputStream){
        this.socke = socke;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    /**
     * Eigentliche Ausführung vom Client -> get set Befehle sind aus Sicht des Clients
     * Also get ist der Client holt sich die Daten vom Server
     *
     * Muss ich nach dem schreiben jeweils Flushen? Ich habs jetzt nicht drinnen, kann sein, dass nach jeden write über den outputStream ein .flush() notwendig ist.
     */
    @Override
    public void run(){
        String in;
        String out;
        WeatherDataDto apiWeatherObjectData = new WeatherDataDto();

        while(true){
            try{
                in = inputStream.readUTF();
                switch (in){
                    //Schließt die Verbindung
                    case "setClose":
                        socke.close();
                        outputStream.close();
                        inputStream.close();
                        return;

                    //Schreibt für die API Call URL den Breitengrad für die Koordinaten
                    case "urlSetLon":
                        in = inputStream.readUTF();
                        apiURL.setLongitude(Double.parseDouble(in));
                        break;
                    //Schreibt für die API Call URL den Längengrad für die Koordinaten
                    case "urlSetLat":
                        in = inputStream.readUTF();
                        apiURL.setLatitude(Double.parseDouble((in)));
                        break;

                    //Schreibt für die API Call URL das Format (Imerpail Metric oder Standard)
                    case "urlSetFormat":
                        in = inputStream.readUTF();
                        apiURL.setUnitFormat(in);
                        break;

                    //Sagt dem Server, dass der API Call durchgeführt werden soll
                    case "startCall":
                        APICall apiCall = new APICall(apiURL.getURL());
                        apiCall.startCall();
                        String textFromApi;
                        textFromApi = apiCall.getTextReadfromCall();
                        JSONParser jsonParser = new JSONParser(textFromApi);
                        apiWeatherObjectData = jsonParser.parse();
                        break;

                    //Holt alles Daten aus dem API Call in einem JSON formatierten String
                    case "getCallDataJson":
                        json = objectWriter.writeValueAsString(apiWeatherObjectData);
                        outputStream.writeUTF(json);
                        break;

                    case "getTemperature":
                        outputStream.writeUTF(Float.toString(apiWeatherObjectData.getMain().getTemp()));
                        break;

                    case "getHumidity":
                        outputStream.writeUTF(Integer.toString(apiWeatherObjectData.getMain().getHumidity()));
                        break;

                    case "getWindJson":
                        json = objectWriter.writeValueAsString(apiWeatherObjectData.getWind());
                        outputStream.writeUTF(json);
                        break;

                    case "getWindSpeed":
                        outputStream.writeUTF(Float.toString(apiWeatherObjectData.getWind().getSpeed()));
                        break;

                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }



    }
}
