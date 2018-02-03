//Joshua Cheung
//CMPS-12A
//Main TicTacToe 3d (4x4x4)

import java.util.*;
import java.io.*;
public class Main
{
    
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
            board.setLocs(input[0], input[1], input[2], " P");
            List<List<Integer>> emptyList = board.emptyLocs();
            List<Integer> comp = board.smartMove();
            board.setLocs(comp.get(0), comp.get(1), comp.get(2), " C");
            board.print();
            //gameover = board.containsWin(board.playSet);
            //System.out.println(board.playSet);
            //System.out.println(gameover);
            //System.out.println(board.winningLocs.get(0).iterator().next().levels);
            //System.out.println(board.emptyLocs); 
            //board.smartMove();
            //System.out.println("comp " + comp);
            //System.out.println(emptyList);
            
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