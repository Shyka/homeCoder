package home.practick.task.chat;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class SocketThread implements Runnable
{
    Socket s = null;
    ArrayList<Socket> clientList = new ArrayList<Socket>();
    InputStream sin;
    OutputStream soute;
    DataOutputStream out;

    public SocketThread(Socket s)
    {
        this.s = s;
    }


    @Override
    public void run()
    {
        try
        {
            ListSocket.addSocketToList(s);
            sin = s.getInputStream();
            System.out.println("client connected");
            DataInputStream in = new DataInputStream(sin);
            soute = s.getOutputStream();
            out = new DataOutputStream(soute);
            String line;
            String nickname ;
            nickname = in.readUTF();
            out.writeUTF("Твой nickname :"+nickname);
            out.flush();
                while (true)
                {

                    line = in.readUTF();
                    System.out.println(nickname + " send " + line);
                    if (line.equals("q"))
                    {
                        break;
                    }
                    clientList = ListSocket.getListSocket();
                    for (Socket sc : clientList)
                    {
                        soute = sc.getOutputStream();
                        out = new DataOutputStream(soute);
                        out.writeUTF(nickname + " : " + line);
                        out.flush();
                    }

                }

            System.out.println(nickname + " --- disconnected");
            ListSocket.removeSocketWithList(s);
        }catch (Exception e)
        {
            try
            {
                s.close();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
            System.out.println(e);
        }


    }
}

