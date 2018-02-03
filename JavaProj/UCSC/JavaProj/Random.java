import java.util.*;
import java.io.*;

public class Random
{
    public static void main(String[] args)
    {
        System.out.println(digits("523"));
    }
    
    public static List<Integer> digits(String move) 
    {
        String lrc = move;
        String [] hello = move.split("");
        List<Integer> myList = new ArrayList<Integer>();
        //int moves = Integer.parseInt(move);
        for(int i = 0; i < hello.length; i++)
        {
            //System.out.println(hello[i]);
            myList.add(Integer.parseInt(hello[i]));
            //System.out.print(myList[]);
        }
        return myList; 
    }     
}


/*
 *
int[] ints = {1, 2, 3};
List<Integer> intList = new ArrayList<Integer>();
for (int index = 0; index < ints.length; index++)
{
    intList.add(ints[index]);
}
 */