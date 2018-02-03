import java.util.*;
import java.io.*;
public class TTT2
{
    static int board [][][] = new int [4][4][4];
    public static void main(String[] args)
    {
        drawBoard();
        System.out.println("\n");
        System.out.println(player());
    }
    
    public static List<Integer> player()
    {
        Scanner kbScanner = new Scanner(System.in);
        System.out.println("Type your move as one three digit number(Level, row, column)");
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
    
    static int [][][] drawBoard()
    {
        int board [][][] = new int [4][4][4]; // level, row, column
        int level, row, column; // i = level, j = row, k = column
        for(level = 1; level < board.length+1; level++)
        {
            System.out.println("\n");            
            System.out.print("level: " + level);
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
        }
        System.out.println("\n"); // numbers on the bottom of the board
        System.out.print("   ");
        for(int i = 1; i < board.length+1; i++)
        {   
            System.out.print(i + " ");
        }
        return board;
    }
    
    
    
    /*
    public static int trackingBoard() 
    {
        List<Integer> mark = player();
        int pLvl, pRow, pCol;
        for(int j = 0; j < mark.size(); j++)
        {
            
        }
        return;
    } 
    */
   
    /*
    public static int[][][] winningSets()
    {
        int [][][] winningSets = new int [76][4][3];
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                for(int k = 0; k < board.length; k++)
                {   
                    int [][][] sets = new int [i][j][k];
                    
                }
            }
        }
        return winningSet;
    }
    */
   
    
       
}