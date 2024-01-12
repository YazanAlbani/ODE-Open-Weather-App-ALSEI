package Networking.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class TCPServer {

    private ServerSocket serverSocket;
    private Socket socke;
    private int port;

    private String dataToSend;
    private String dataToRead;
    public TCPServer(int port) {
        this.port = port;
    }

    public TCPServer() {
        port = 48333;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void startConnection (){
        try {
            socke = serverSocket.accept();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void closeConnection(){
        try{
            socke.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void runClientHandler(){

        try(DataInputStream inputStream = new DataInputStream(socke.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socke.getOutputStream()); ){
            Thread clientThread = new ClientHandler(socke, inputStream, outputStream);
            clientThread.start();

        }catch(IOException e){
            try {
                socke.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }


}
