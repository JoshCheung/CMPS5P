//Joshua Cheung
//CMPS-12A
//Main TicTacToe 3d (4x4x4)

import java.util.*;
import java.io.*;
public class Main
{
    //I've had prior knowledge of classes from my Java course in High School
    public static void main(String[] args)
    {
        Scanner kbScanner = new Scanner(System.in);
        Board board = new Board(4,4,4);
        board.print();
        //System.out.println(input[0] + ", " + input[1] + ", " + input[2]);
        boolean gameover = false;
        
        while(!gameover)
        {
            int [] input = readPlayerInput(board);
            if(board.isOccupied(input[0], input[1], input[2]))
            {
                System.out.println("That cell is already taken");
                input = readPlayerInput(board);
            }
            board.setLocs(input[0], input[1], input[2], "P");
            board.computeScore();
            System.out.println(board.pScore);
            // List<List<Integer>> emptyList = board.emptyLocs();
            Location comp = board.findBestMove();
            //List<Integer> comp = board.smartMove();
            //System.out.println("com: " + comp);
            board.setLocs(comp.levels, comp.row, comp.col, "C");
           
            board.print();
            System.out.println("Winner: ");
            String winner = board.findWinner();
            if(winner != null)
            {
                System.out.print(winner);
                gameover = true;
            }
        }
    }
    
    public static int [] readPlayerInput(Board board) //player's input
    {
        Scanner kbScanner = new Scanner(System.in);
        System.out.println("Type your move as one three digit number(Level, row, column)");
        //int position = kbScanner.nextInt();
        String pos = kbScanner.next();
        int [] position = lrc(pos);
        //board.playSet.add(new Location(position[0], position[1], position[2]));
        return position;
    }
    
    public static int[] lrc(String move)
    {
        String spot = move;
        String [] lrc = spot.split("");
        int [] posit = new int [3];
        for(int i = 0; i < lrc.length; i++)
        {
            posit[i] = Integer.parseInt(lrc[i]);
        }
        return posit; 
    }
}