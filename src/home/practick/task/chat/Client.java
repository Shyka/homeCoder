package home.practick.task.chat;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Werq on 05.10.2015.
 */
public class Client
{
    public static void main(String[] args) throws IOException
    {
        int serverPort = 1234;
        String address = "127.0.0.1";

        InetAddress ipAddress =  InetAddress.getByName(address);
        Socket socket = new Socket(ipAddress,serverPort);
        System.out.print("Введите nickname:");

        Thread threadIn = new Thread (new SocketInputThread(socket));
        Thread threadOut = new Thread (new SocketOutputThread(socket));

        threadIn.start();
        threadOut.start();


    }
}
