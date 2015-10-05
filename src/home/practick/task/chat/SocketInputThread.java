package home.practick.task.chat;


import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class SocketInputThread implements Runnable
{
    Socket s ;
    DataInputStream in;
    InputStream sin;
    public  SocketInputThread(Socket s)
    {
        this.s = s;
    }

    @Override
    public void run()
    {
        String inLine;
        try
        {
            sin = s.getInputStream();
            while (true)
            {
                in = new DataInputStream(sin);
                inLine = in.readUTF();
                System.out.println(inLine);
            }


        }catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
