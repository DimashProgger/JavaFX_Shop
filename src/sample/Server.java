package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1993);
            System.out.println("Waiting for a client..");
//            int counter = 1;
            while (true) {
//                Socket clientSocket = serverSocket.accept();
//                System.out.println("Client accepted" + " " + (counter++));
//                OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
//                BufferedReader reader = new BufferedReader(
//                        new InputStreamReader(
//                                clientSocket.getInputStream()));
//
//                String request = reader.readLine();
//                String response = "#" + counter + ", Your message length is " + request.length() + "\n";
//                writer.write(response);
//                writer.flush();
//
//                reader.close();
//                writer.close();
//                clientSocket.close();
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                SocketThread st = new SocketThread(socket);
                st.start();
            }
            //serverSocket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
