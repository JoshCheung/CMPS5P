import java.util.Scanner;
import java.io.*;
public class TTT
{
    public static Scanner kbScanner = new Scanner(System.in);
    public static void main(String [] args)
    {
        final int size = 4;
        char [][][] board = new char [size][size][size];
        showBoard(board);
        int remainCount = size*size*size; // empty cell count
        userPlay(board);
        compPlay(board);
        showBoard(board);
    }
    
    public static void showBoard(char[][][] board)
    {
        int num_levels = board.length;
        int num_rows = board[1].length;
        int num_cols = board[2].length;
        
        System.out.print("  ");
        for(int x = 0; x < num_cols; x++) //this prints out the actual board
        {
            System.out.print(" " + x );
        }
        System.out.println();
        
        for(int l = 0; l < num_levels; l++)
        {
            for(int i = 0; i < num_rows; i++)
            {
                System.out.print(" " + i + " ");
                for(int j = 0; j < num_cols; j++)
                {   
                    board[l][i][j] = '_';
                    System.out.print(board[l][i][j]); 
                    System.out.print(" ");
                }
                System.out.println();
            }   
            System.out.println();
        }
    }
    
    public static void userPlay(char[][][] board)
    {
        System.out.print("\nEnter the level, row, and column indices: ");
        int levelIndex = kbScanner.nextInt();
        int rowIndex = kbScanner.nextInt();
        int colIndex = kbScanner.nextInt();
        while(board[levelIndex][rowIndex][colIndex]!= '_')
        {
            System.out.print("The cell is already taken.\nEnter the row and column indices: ");
            levelIndex = kbScanner.nextInt();
            rowIndex = kbScanner.nextInt();
            colIndex = kbScanner.nextInt();
        }
        board[levelIndex][rowIndex][colIndex] = 'P';
    }
    
    public static void compPlay(char[][][] board)
    {
        // Find the first empty cell and put a tic there.
        for (int i = 0; i < board.length; i++) 
        {
            for (int j = 0; j < board[0].length; j++) 
            {
                for(int k = 0; k < board[1].length; k++)
                {
                    if (board[i][j][k] == ('_')) // empty cell
                    { 
                        board[i][j][k] = 'C';
                        return;
                    }
                }
            }
        }
    }
}
    