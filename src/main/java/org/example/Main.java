package org.example;
import Networking.APICall;
import Networking.APIgenerateURL;

public class Main {
    public static void main(String[] args) {
        APIgenerateURL generateURL = new APIgenerateURL();
        APICall firstCall = new APICall(generateURL.getURL());
        String readText;
        readText = firstCall.getTextReadfromCall();
        System.out.printf("bis hier");
        System.out.printf(readText);
    }
}