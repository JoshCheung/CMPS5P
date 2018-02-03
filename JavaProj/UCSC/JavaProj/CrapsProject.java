//Joshua Cheung
//CMPS-12A
//Program Assignment 3

import java.util.*;
import java.io.*;

public class Craps
{
    public static void main(String[] args)
    {
        System.out.println("Enter the seed");
        Scanner kbScanner = new Scanner(System.in);
        int seed = kbScanner.nextInt();
        System.out.println("How many chips do you want?");
        int numberOfChips = kbScanner.nextInt();
        int quantityOfChips = numberOfChips;
        int bet = enterBet(quantityOfChips);
        String enter = enterToPlay();
        boolean hasMoney = true;
        while(hasMoney)
        { 
            if(quantityOfChips <= 0)
        	{
        	    System.out.println("Sorry, you are out of money");
        	    break;
        	}
            int point = rollDice();
            if(point == 2 || point == 3 || point == 12)
            {
                quantityOfChips = (quantityOfChips - bet);
        	    System.out.println("You lost, you now have "+ quantityOfChips);
        	    if(quantityOfChips <= 0)
        	    {
        	        System.out.println("Sorry, you are out of money");
        	        break;
        	    }
        	    bet = enterBet(quantityOfChips); 
        	    enterToPlay();
            }
            else if(point == 7 || point == 11)
            {
                quantityOfChips = (quantityOfChips + bet);
                System.out.println("You won, you now have " + quantityOfChips);
                bet = enterBet(quantityOfChips);
                enterToPlay();
            }
            else
            {
                 System.out.println("The point is " + point);
                 enterToPlay();
                 boolean done = false;
                 while(!done)
                 {  
                     int toss = rollDice();
                     if(toss == point)
                     {
                         quantityOfChips = (quantityOfChips + bet);
                         System.out.println("You win, you now have " + quantityOfChips);
                         done = true;
                         bet = enterBet(quantityOfChips);
                     }
                     else if (toss == 7)
                     {
                         quantityOfChips = (quantityOfChips - bet);
                         System.out.println("You lost, you now have " + quantityOfChips);
                         if(quantityOfChips <= 0)
                         {
                             System.out.println("Sorry, you are out of money");
                             break;
                         }
                         done = true;
                         bet = enterBet(quantityOfChips);
                     }
                 }
            }
        }
    }
    
    public static int enterBet(int num)
    {
        int amountOfChips = num;
        System.out.println("Enter a bet");
        Scanner scanBet = new Scanner(System.in);
        int betSize = scanBet.nextInt();
        boolean invalid = true;
        if(betSize > amountOfChips)
        {
            while(invalid)
            {
                System.out.println("Not an ok bet");
                int newBet = scanBet.nextInt();
                if(newBet <= amountOfChips)
                { 
                    betSize = newBet;
                    invalid = false;
                   }
               }
        }
        return betSize;
    }
        
    public static String enterToPlay()
    {
        System.out.println("Hit enter to roll the dice");
        String enterKey;
        Scanner myScanner = new Scanner(System.in);
        enterKey = myScanner.nextLine();
        return enterKey;
    }
        
    public static int rollDice()
    {
        int die1 = (int)(Math.random()*6+1);
        int die2 = (int)(Math.random()*6+1);
        System.out.println("roll is " + die1 + ", " + die2);
        int point = die1 + die2;
        return point;
    }
}