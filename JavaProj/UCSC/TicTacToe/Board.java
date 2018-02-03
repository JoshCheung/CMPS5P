//Joshua Cheung
//CMPS-12A
//Board class for 3D TicTacToe 

import java.util.*;
import java.io.*;

public class Board
{
    public static final String Player = " P";
    public static final String Empty = " _"; 
    public int num_rows;
    public int num_cols;
    public int num_levels;
    private Random rand;
    //public Set<Location> compSet = new HashSet<Location>();
    //public Set<Location> playSet = new HashSet<Location>();
    
    public static final int [][][] lines = {
        {{0,0,0},{0,0,1},{0,0,2},{0,0,3}},  //lev 0; row 0   rows in each level
        {{0,1,0},{0,1,1},{0,1,2},{0,1,3}},  //       row 1
        {{0,2,0},{0,2,1},{0,2,2},{0,2,3}},  //       row 2
        {{0,3,0},{0,3,1},{0,3,2},{0,3,3}},  //       row 3
        {{1,0,0},{1,0,1},{1,0,2},{1,0,3}},  //lev 1; row 0
        {{1,1,0},{1,1,1},{1,1,2},{1,1,3}},  //       row 1
        {{1,2,0},{1,2,1},{1,2,2},{1,2,3}},  //       row 2
        {{1,3,0},{1,3,1},{1,3,2},{1,3,3}},  //       row 3
        {{2,0,0},{2,0,1},{2,0,2},{2,0,3}},  //lev 2; row 0
        {{2,1,0},{2,1,1},{2,1,2},{2,1,3}},  //       row 1
        {{2,2,0},{2,2,1},{2,2,2},{2,2,3}},  //       row 2
        {{2,3,0},{2,3,1},{2,3,2},{2,3,3}},  //       row 3
        {{3,0,0},{3,0,1},{3,0,2},{3,0,3}},  //lev 3; row 0
        {{3,1,0},{3,1,1},{3,1,2},{3,1,3}},  //       row 1
        {{3,2,0},{3,2,1},{3,2,2},{3,2,3}},  //       row 2
        {{3,3,0},{3,3,1},{3,3,2},{3,3,3}},  //       row 3
        {{0,0,0},{0,1,0},{0,2,0},{0,3,0}},  //lev 0; col 0   columns in each level
        {{0,0,1},{0,1,1},{0,2,1},{0,3,1}},  //       col 1
        {{0,0,2},{0,1,2},{0,2,2},{0,3,2}},  //       col 2
        {{0,0,3},{0,1,3},{0,2,3},{0,3,3}},  //       col 3
        {{1,0,0},{1,1,0},{1,2,0},{1,3,0}},  //lev 1; col 0
        {{1,0,1},{1,1,1},{1,2,1},{1,3,1}},  //       col 1
        {{1,0,2},{1,1,2},{1,2,2},{1,3,2}},  //       col 2
        {{1,0,3},{1,1,3},{1,2,3},{1,3,3}},  //       col 3
        {{2,0,0},{2,1,0},{2,2,0},{2,3,0}},  //lev 2; col 0
        {{2,0,1},{2,1,1},{2,2,1},{2,3,1}},  //       col 1
        {{2,0,2},{2,1,2},{2,2,2},{2,3,2}},  //       col 2
        {{2,0,3},{2,1,3},{2,2,3},{2,3,3}},  //       col 3
        {{3,0,0},{3,1,0},{3,2,0},{3,3,0}},  //lev 3; col 0
        {{3,0,1},{3,1,1},{3,2,1},{3,3,1}},  //       col 1
        {{3,0,2},{3,1,2},{3,2,2},{3,3,2}},  //       col 2
        {{3,0,3},{3,1,3},{3,2,3},{3,3,3}},  //       col 3
        {{0,0,0},{1,0,0},{2,0,0},{3,0,0}},  //cols in vert plane in front
        {{0,0,1},{1,0,1},{2,0,1},{3,0,1}},
        {{0,0,2},{1,0,2},{2,0,2},{3,0,2}},
        {{0,0,3},{1,0,3},{2,0,3},{3,0,3}},
        {{0,1,0},{1,1,0},{2,1,0},{3,1,0}},  //cols in vert plane one back
        {{0,1,1},{1,1,1},{2,1,1},{3,1,1}},
        {{0,1,2},{1,1,2},{2,1,2},{3,1,2}},
        {{0,1,3},{1,1,3},{2,1,3},{3,1,3}},
        {{0,2,0},{1,2,0},{2,2,0},{3,2,0}},  //cols in vert plane two back
        {{0,2,1},{1,2,1},{2,2,1},{3,2,1}},
        {{0,2,2},{1,2,2},{2,2,2},{3,2,2}},
        {{0,2,3},{1,2,3},{2,2,3},{3,2,3}},
        {{0,3,0},{1,3,0},{2,3,0},{3,3,0}},  //cols in vert plane in rear
        {{0,3,1},{1,3,1},{2,3,1},{3,3,1}},
        {{0,3,2},{1,3,2},{2,3,2},{3,3,2}},
        {{0,3,3},{1,3,3},{2,3,3},{3,3,3}},
        {{0,0,0},{0,1,1},{0,2,2},{0,3,3}},  //diags in lev 0
        {{0,3,0},{0,2,1},{0,1,2},{0,0,3}},
        {{1,0,0},{1,1,1},{1,2,2},{1,3,3}},  //diags in lev 1
        {{1,3,0},{1,2,1},{1,1,2},{1,0,3}},
        {{2,0,0},{2,1,1},{2,2,2},{2,3,3}},  //diags in lev 2
        {{2,3,0},{2,2,1},{2,1,2},{2,0,3}},
        {{3,0,0},{3,1,1},{3,2,2},{3,3,3}},  //diags in lev 3
        {{3,3,0},{3,2,1},{3,1,2},{3,0,3}},
        {{0,0,0},{1,0,1},{2,0,2},{3,0,3}},  //diags in vert plane in front
        {{3,0,0},{2,0,1},{1,0,2},{0,0,3}},
        {{0,1,0},{1,1,1},{2,1,2},{3,1,3}},  //diags in vert plane one back
        {{3,1,0},{2,1,1},{1,1,2},{0,1,3}},
        {{0,2,0},{1,2,1},{2,2,2},{3,2,3}},  //diags in vert plane two back
        {{3,2,0},{2,2,1},{1,2,2},{0,2,3}},
        {{0,3,0},{1,3,1},{2,3,2},{3,3,3}},  //diags in vert plane in rear
        {{3,3,0},{2,3,1},{1,3,2},{0,3,3}},
        {{0,0,0},{1,1,0},{2,2,0},{3,3,0}},  //diags left slice
        {{3,0,0},{2,1,0},{1,2,0},{0,3,0}},
        {{0,0,1},{1,1,1},{2,2,1},{3,3,1}},  //diags slice one to right
        {{3,0,1},{2,1,1},{1,2,1},{0,3,1}},
        {{0,0,2},{1,1,2},{2,2,2},{3,3,2}},  //diags slice two to right
        {{3,0,2},{2,1,2},{1,2,2},{0,3,2}},
        {{0,0,3},{1,1,3},{2,2,3},{3,3,3}},  //diags right slice
        {{3,0,3},{2,1,3},{1,2,3},{0,3,3}},
        {{0,0,0},{1,1,1},{2,2,2},{3,3,3}},  //cube vertex diags
        {{3,0,0},{2,1,1},{1,2,2},{0,3,3}},
        {{0,3,0},{1,2,1},{2,1,2},{3,0,3}},
        {{3,3,0},{2,2,1},{1,1,2},{0,0,3}}
    };

    
    
    public String [][][] locs;
    //public List<Set<Location>> winningLocs = createWinningLocs();
    /*
    public List<Set<Location>> createWinningLocs()
    {
        List<Set<Location>> winningLocs = new ArrayList<Set<Location>>();
        for(int l = 0; l < lines.length; l++)
        {
                Set<Location> sets = new HashSet<Location>();
            
                sets.add( new Location(lines[l][0][0], lines[l][0][1], lines[l][0][2]));
                sets.add( new Location(lines[l][1][0], lines[l][1][1], lines[l][1][2]));
                sets.add( new Location(lines[l][2][0], lines[l][2][1], lines[l][2][2]));
                sets.add( new Location(lines[l][3][0], lines[l][3][1], lines[l][3][2]));
                winningLocs.add(sets);
            
        }
        return winningLocs;
    }
    */
    
    public Board (int levels, int rows, int cols)  //initialization of the board
    {
        this.num_rows = rows;
        this.num_cols = cols;
        this.num_levels = levels;
        locs = new String [levels][rows][cols];
        rand = new Random();
        
        for (int l = 0; l < levels; l++)
        {   
            for(int i = 0; i < rows; i++)//it filled each box with its coordinates
            {
                for(int j = 0; j < cols; j++)
                {
                    locs[l][i][j] = " _";
                }
            }
        }
    }
    
    public void setLocs(int l, int r, int c, String val)
    {
        locs[l][r][c] = val;
    }
    
    public List<Integer> smartMove()
    {
        int i = rand.nextInt(emptyLocs().size());
        List<Integer> el = emptyLocs().get(i); 
        //compSet.add(new Location(el.get(0),el.get(1),el.get(2)));
        return el;
    }
    
    /*
    public boolean contains(List<Location> listLoc, Location l)
    {
        for(int i = 0; i < listLoc.size(); i++)
        {
            if(listLoc.get(i).isEqual(l))
            {
                return true;
            }
        }
        return false;
    }
    
   
    public boolean containsWin(Set<Location> setLoc)
    {
        boolean out = false;
        for(int i = 0; i < winningLocs.size(); i++)
        {
            //Location wl1 = winningLocs.get(i);
            Iterator<Location> it = winningLocs.get(i).iterator();
            if(setLoc.contains(it.next()) && setLoc.contains(it.next()) &&
               setLoc.contains(it.next()) && setLoc.contains(it.next()))
            {
                out =  true;
            }
        }
        return out;
    }
    */
    public List<List<Integer>> emptyLocs() //creates an ArrayList of numbers that should be the 
                                           //locations of the empty cells that contain " _". 
    {
        List<List<Integer>> emptyCells = new ArrayList<List<Integer>>();
        //List<Integer> ec = new ArrayList<Integer>();
        for(int i = 0; i < num_levels; i++)
        {
            for(int j = 0; j < num_rows; j++)
            {
                for(int k = 0; k < num_cols; k++)
                {
                    List<Integer> ec = new ArrayList<Integer>();
                    if (locs[i][j][k].equals(" _"))
                    {
                        ec.add(i);
                        ec.add(j);
                        ec.add(k);
                        emptyCells.add(ec);
                    }
                }
            }
        }
        return emptyCells;
    }
    
    public void print() //prints the entire board or updated board.
    {
        System.out.print("   ");
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
                    System.out.print(locs[l][i][j]); 
                }
                System.out.println();
            }   
            System.out.println();
        }
    }
}

