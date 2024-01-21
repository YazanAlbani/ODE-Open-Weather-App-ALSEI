package Networking.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.*;
public class ClientCalls {
    public static void setClose(DataOutputStream outputStream){
        try {
            outputStream.writeUTF("setClose");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Würds gerne static machen, kanns aber gerade nicht, TODO
    // Damit man es ohne ein Objet zu erstellen vom Client aus callen kann.
    // Ich habe sicherheitshalber das Timeout gebaut, damit beim lessen nichts passiert / mehrere "Befehle" auf einmal gelesen werden, 50 ms sollten vollkommen ausreichen und dem Benutzer nicht auffallen
    // 50 ms Magic Number TODO: ersetzen
    public void urlSetLon(DataOutputStream outputStream, double lon){
        try {
            outputStream.writeUTF("urlSetLon");
            outputStream.flush();
            this.wait(50);
            outputStream.writeUTF(Double.toString(lon));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void urlSetLat(DataOutputStream outputStream, double lat){
        try {
            outputStream.writeUTF("urlSetLat");
            outputStream.flush();
            this.wait(50);
            outputStream.writeUTF(Double.toString(lat));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void urlSetLon(DataOutputStream outputStream, String format){
        try {
            outputStream.writeUTF("urlSetFormat");
            outputStream.flush();
            this.wait(50);
            outputStream.writeUTF(format);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void startCall (DataOutputStream outputStream){
        try {
            outputStream.writeUTF("startCall");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getCallDataJson(DataOutputStream outputStream, DataInputStream inputStream){
        try {
            String readIn;
            outputStream.writeUTF("getCallDataJson");
            readIn = inputStream.readUTF();
            return readIn;
        } catch (IOException  e) {
            e.printStackTrace();
            return "Error Reading Stream";
        }
    }
    public static String getTemperature(DataOutputStream outputStream, DataInputStream inputStream){
        try {
            String readIn;
            outputStream.writeUTF("getTemperature");
            readIn = inputStream.readUTF();
            return readIn;
        } catch (IOException  e) {
            e.printStackTrace();
            return "Error Reading Stream";
        }
    }
    public static String getHumidity(DataOutputStream outputStream, DataInputStream inputStream){
        try {
            String readIn;
            outputStream.writeUTF("getHumidity");
            readIn = inputStream.readUTF();
            return readIn;
        } catch (IOException  e) {
            e.printStackTrace();
            return "Error Reading Stream";
        }
    }
    public static String getWindJson(DataOutputStream outputStream, DataInputStream inputStream){
        try {
            String readIn;
            outputStream.writeUTF("getWindJson");
            readIn = inputStream.readUTF();
            return readIn;
        } catch (IOException  e) {
            e.printStackTrace();
            return "Error Reading Stream";
        }
    }
    public static String getWindSpeed(DataOutputStream outputStream, DataInputStream inputStream){
        try {
            String readIn;
            outputStream.writeUTF("getWindSpeed");
            readIn = inputStream.readUTF();
            return readIn;
        } catch (IOException  e) {
            e.printStackTrace();
            return "Error Reading Stream";
        }
    }
}

