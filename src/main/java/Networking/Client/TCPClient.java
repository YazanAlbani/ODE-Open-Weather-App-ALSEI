package Networking.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPClient {
    private Socket clientSocket;
    private int port;
    private  DataInputStream streamIn;
    private DataOutputStream streamOut;


    public void startConnection (){
        try {
            clientSocket = new Socket("localhost", port);
            streamIn = new DataInputStream(clientSocket.getInputStream());
            streamOut = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public TCPClient(int port) {
        this.port = port;
    }

    //Default Wert für den Port bei default construktor
    public TCPClient() {
        this.port = 48333;
    }
}
