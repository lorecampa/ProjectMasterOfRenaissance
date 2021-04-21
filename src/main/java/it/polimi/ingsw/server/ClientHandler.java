package it.polimi.ingsw.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private Socket socket;
    private Server server;
    private Scanner in;
    private PrintWriter out;


    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream());
    }

    public void writeToStream(String message){
        out.println(message);
        out.flush();
    }

    public void registerClient(){
        writeToStream("Insert username: ");
        String username = in.nextLine();
        server.addClient(username, this);
    }

    @Override
    public void run() {
        registerClient();
        while (true) {
            String line = in.nextLine();
            if (line.equals("quit")) {
                break;
            } else {
                out.println("Received: " + line);
                out.flush();
            }
        }
        // Chiudo gli stream e il socket
        in.close();
        out.close();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}