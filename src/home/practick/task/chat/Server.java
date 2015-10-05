package home.practick.task.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Werq on 05.10.2015.
 */
public class Server
{
    public static void main(String[] args) throws IOException
    {
        int port = 1234;
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server start");

        while (true)
        {
            Socket socket = ss.accept();
            SocketThread socketThread = new SocketThread(socket);
            Thread t = new Thread(socketThread);
            t.start();
        }

    }
}

