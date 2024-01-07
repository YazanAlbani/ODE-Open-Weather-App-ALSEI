package Networking;

import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;
import java.nio.Buffer;

public class APICall {
    private String URLtoCall;
    private String textReadfromCall;
    URL url;

    public APICall(String URLtoCall) {
        this.URLtoCall = URLtoCall;
        URL tmpURLtoCast = null;
        try {
            tmpURLtoCast = new URL(this.URLtoCall);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        url = tmpURLtoCast;
    }



    /**
     * returns the current URL that will be called in this class, used for debugging
     * @return returns the current URL for debugging
     */
    public String getCurrentURL(){
        return url.toString();
    }

    /**
     * Generates a new url objekt from the current URL String
     */
    public void generateNewURL(){

        try{
            url = new URL(URLtoCall);
        } catch (java.net.MalformedURLException e){
            e.printStackTrace();
        }

    }

    /**
     * Used to set or change the URL to Call
     * Sets the String in this classe, the url Objet needs to be generated with "generatenNewURL"
     * @param URLtoCall a String with the URL to call in case the object was not initialized with it or the URL needs to be changed
     */
    public void setURLtoCall(String URLtoCall) {
        this.URLtoCall = URLtoCall;
    }

    /**
     *   Function used to read Data from a Reader and return it in a single String
     *   Will be called in startCall to increase readablitiy in this method
     */
    private String readFromReader(BufferedReader read){
        StringBuilder inRead = new StringBuilder();

        int currentReadPoint;
        try {
            while ((currentReadPoint = read.read()) != -1) {
                inRead.append((char) currentReadPoint);
                System.out.println((char) currentReadPoint);
            }
        }catch( java.io.IOException e){
            e.printStackTrace();
        }
        return inRead.toString();
    }


    /**
     * Method opens a connection to the current url and reads the data to the local textReadfromCall String
     * Bad try catch cause both NUllpointer and IO Exception needs to be handeled, ToDO
     */
    public void startCall(){

        /*
        HTTPS Url Connection is not auto closable -> cant use try with parameters here -> extra try catch
         */
        HttpsURLConnection connection = null;
        try {
            System.out.println("Start opening Connection");
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            System.out.println("Connection Opened");
            System.out.println(connection.getResponseCode());


            try (
                    InputStream streamIn = connection.getInputStream();


            ){
                System.out.println(connection.getResponseCode());
                BufferedReader in = new BufferedReader(new InputStreamReader(streamIn));
                textReadfromCall = readFromReader(in);
                in.close();
                connection.disconnect();

            }catch(Exception e){
                e.printStackTrace();
                connection.disconnect();
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
            textReadfromCall = "";
            connection.disconnect();
        }



    }



    public String getTextReadfromCall() {
        return textReadfromCall;
    }
}
