package ru.gdAleko.architecture.lesson_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServerStart {

    private Handler handler;


    public void  start(){
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(() -> handler.handleRequest(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
