package home.practick.task.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class task1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите слово Фильтр");
        String filterWord = buff.readLine();
        System.out.println("Вводите строчки, нажмите Enter для окончания ввода");
        LinkedList<String> strings = new LinkedList<String>();
        while (true)
        {
            String wrd = buff.readLine();
            if (wrd.isEmpty()) break;
            strings.add(wrd);

        }
        for (String st : strings)
            if (isContFilter(st,filterWord))
                System.out.println(st);

    }

    public static boolean isContFilter(String s , String filter)
    {
        String[] strings = s.split(" ");
        Boolean result = false;
        for (String st : strings)
        {
            if (st.toLowerCase().equals(filter.toLowerCase()))
            {
                result = true;
                break;
            }
            else
                result = false;
        }
        return result;
    }
}
