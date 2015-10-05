package home.practick.task.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Werq on 05.10.2015.
 */
public class SocketOutputThread implements Runnable
{
    Socket s ;

    SocketOutputThread(Socket s){
        this.s = s;
    }

    BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));


    @Override
    public void run()
    {
        try
        {
            OutputStream sot = s.getOutputStream();
            DataOutputStream out = new DataOutputStream(sot);
            String outline;

            while (true)
            {
                outline = buff.readLine();
                out.writeUTF(outline);
                if (outline.equals("q"))
                {
                    s.close();
                    break;
                }
                out.flush();
            }


        }catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
