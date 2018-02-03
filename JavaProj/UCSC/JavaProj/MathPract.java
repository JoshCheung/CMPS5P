import java.util.*;
import java.io.*;

public class MathPract
{
    public static void main(String [] args)
    {
        Scanner kbScanner = new Scanner(System.in);
    	System.out.println("How many chips do you want?");
    	int numberOfChips = kbScanner.nextInt();
    	System.out.println("Enter a bet");
    	boolean valid = true;
    	int bet = kbScanner.nextInt();
    	if(bet > numberOfChips)
    	{
    	    while(!valid)
    	    {
    	        System.out.println("Not an ok bet");
    	        int newBet = 
            }
        }
    }
}