public class Board
{
    public static final String Player = " X ";
    public static final String Empty = " _";
    Location [][] locs = null;
    
    public int num_rows;
    public int num_cols;
    
    public Board (int rows, int cols) //,int level)
    {
        this.num_rows = rows;
        this.num_cols = cols;
        //this.num_levels = levels;
        locs = new Location [rows][cols];
        
        for(int i = 0; i<rows;i++)
        {
            for(int j = 0; j<cols;j++)
            {
                locs[i][j] = new Location(i,j);
            }
        }
    }
}
