package main;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    ServerSocket socket;

    public Server() throws IOException {
        socket = new ServerSocket();
    }

    public static void main(String[] args) throws IOException {
        new Server();
    }
}
