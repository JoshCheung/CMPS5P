import java.util.*;
import java.io.*;

public class TicTac
{
    
    public static void main(String[] args)
    {
        drawBoard();
        System.out.println("\n");
        player();
    }
    
     public static List<Integer> player()
    {
        Scanner kbScanner = new Scanner(System.in);
        System.out.println("Type your move as one two digit number(row, column)");
        //int position = kbScanner.nextInt();
        String pos = kbScanner.next();
        List<Integer> position = lrc(pos);
        return position;
    }
    
    
    public static List<Integer> lrc(String move)
    {
        String lrc = move;
        String [] hello = move.split("");
        List<Integer> myList = new ArrayList<Integer>();
        for(int i = 0; i < hello.length; i++)
        {
            myList.add(Integer.parseInt(hello[i]));
        }
        return myList; 
    }
    
    public static int [][]drawBoard()
    {
        int [][] board = new int [2][2];
        int row, column;
        for(row = 1; row < board.length + 1; row++)
        {
            System.out.println();
            System.out.print(row + " ");//prints number of rows for each level
            for(column = 1; column < board.length + 1; column++)
            {
                //System.out.print();
                System.out.print(" _");
            }
        }
        
        System.out.println("\n"); // numbers on the bottom of the board
        System.out.print("   ");
        for(int i = 1; i < board.length+1; i++)
        {   
            System.out.print(i + " ");
        }
        return board;
    }
    
    
}


