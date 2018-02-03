//Joshua Cheung
//CMPS-12A
//Board class for TICTACTOE
import java.util.*;
import java.io.*;

public class Board
{
    public static final String EMPTY = "_";
    public static final String PLAYER = "P";
    public static final String COMPUTER = "C";
    public int num_rows;
    public int num_cols;
    public int num_levels;
    private Random rand;
 
    public static final int [][][] winList = {
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
    
    int [] pScore = new int [winList.length];
    int [] cScore = new int [winList.length];
    
    int pScoreMax = 0;
    int cScoreMax = 0;
    
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
                    locs[l][i][j] = EMPTY; //Empty = " _ "
                }
            }
        }
    }
    
    public String getCellValue(Location loc)
    {
        return locs[loc.levels][loc.row][loc.col];
    }
        
    public void computeScore() //computes score of winning cells
                               // my father helped with come up with this idea
                               //basically, to know if someone is winning, it looks through the the winList
                               //   and loops through and see which cells it occupies. adds one to each int [] for player 
                               //   and computer.
                               // the higher the number in the int [] for either player or computer, the better chance of winning
                               
    {
        for(int i = 0; i < winList.length; i++)
        {
            int [][] combo = winList[i];
            pScore[i] = 0;
            cScore[i] = 0;
            
            for(int j = 0; j < combo.length; j++)
            {
                String cellValue = locs[combo[j][0]][combo[j][1]][combo[j][2]];
                //System.out.println("CellValue : " + cellValue);
                //System.out.println("Location : " + i + ", " + j);
                pScore[i] += (cellValue.equals(PLAYER) ? 1 : 0);
                cScore[i] += (cellValue.equals(COMPUTER) ? 1 : 0);
                //System.out.println("P: " + pScore[i]);
                // System.out.println("C: " + cScore[i]);
            }
            
            if(pScore[i] != 0 && cScore[i] != 0)
            {
                pScore[i] = -1;
                cScore[i] = -1;
            }
            
            cScoreMax = (cScore[i] > cScore[cScoreMax] ? i : cScoreMax);
            pScoreMax = (pScore[i] > pScore[pScoreMax] ? i : pScoreMax);
        }
    }
   
    public String comboHasWinner(int [][] combo) //Checks winning combo locations
                                                 //Works with findWinner()
                                                 //
    {
        //System.out.println("[combo]: " + combo[0][0] + ", " +  combo[0][1]+ ", " + combo[0][2]);
        String firstValue = locs[combo[0][0]][combo[0][1]][combo[0][2]];
        //System.out.println("[00]: " + firstValue);

        if(firstValue.equals(EMPTY))
        {
            //System.out.println("[01]");
            return null;
        }

        for(int j = 1; j < combo.length; j++)
        {
            //System.out.println("[04]");
            String cellValue = locs[combo[j][0]][combo[j][1]][combo[j][2]];
            //System.out.println("cellValue: " + j + "::" + cellValue);

            if(!cellValue.equals(firstValue))
            {
                //System.out.println("[02]");
                return null;
            }

        } 
        //System.out.println("[03]: " + firstValue);
        return firstValue;
    }

    public String findWinner() // if a combo exists and is made, this function looks through the list and
                               // finds which character or String has occupied those winning locations
                               // returns the winner String
    {
        for(int i = 0; i < winList.length; i++)
        {
            String winner = comboHasWinner(winList[i]);
            if(winner != null)
            {
                return winner;
            }
        }
        return null;
    }

    public void setLocs(int l, int r, int c, String val) //Sets the location[level][row][col] with a string value 
    {
        locs[l][r][c] = val; //initiallizes location to new String value;
    }
    
    public Location findBestMove()//Find the best move through the scoring of each cell it occupies.
                                  
    {
        //if the combo score is at three, that means a combo in the winList has a higher chance of winning
        // therefore the computer looks at it as important and tries to block the move.
        Location winLoc;
        int [][] combos = winList[cScoreMax];
        if(pScore[cScoreMax] == 3)
        {   
            for(int k = 0; k < winList[cScoreMax].length; k++)
            {
                winLoc = new Location(combos[k][0], combos[k][1], combos[k][2]);
                if(getCellValue(winLoc).equals(EMPTY))
                {
                   return winLoc;
                }               
            }
        }
        
        //if there is nothing important like the one above,
        // it will try to fulfill the winList or block the player
        for(int i = 0; i < winList.length; i++)
        {
            combos = winList[cScoreMax];
            for(int j = 0; j < combos.length; j++)
            {              
                winLoc = new Location(combos[j][0], combos[j][1], combos[j][2]);
                System.out.println(winLoc + ", " + getCellValue(winLoc));
                if(getCellValue(winLoc).equals(EMPTY))
                {
                    return winLoc;
                }
            }
        }
        return null;
    }
    
    public boolean isOccupied(int i, int j, int k) //checks to see if a location is occupied
    {
        return !locs[i][j][k].equals(EMPTY);
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
                    System.out.print(" " + locs[l][i][j]); 
                }
                System.out.println();
            }   
            System.out.println();
        }
    }
}

