public class Location 
{
    public int levels;
    public int row;
    public int col;
    public String empty = " _";
    
    public Location(int levels, int row, int col)
    {
        this.levels = levels;
        this.row = row;
        this.col = col;
    }
    
    public boolean isEqual(Location that)
    {
        return this.levels == that.levels && this.row == that.row && this.col == that.col;
    }
    
  
}

