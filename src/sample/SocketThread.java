package sample;

import java.io.*;
import java.net.Socket;


public class SocketThread  extends Thread{
    private Socket socket;
    public SocketThread(Socket socket){
        this.socket = socket;
    }
    public void run() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());












        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
