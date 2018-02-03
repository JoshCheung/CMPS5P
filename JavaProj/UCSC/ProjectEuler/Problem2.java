import java.io.*;
import java.util.*;
public class Problem2
{
    public static void main(String[] args)
    {
         int value = fib(0, 1, 1000);
         System.out.println(value);
    }
    
    public static int fib(int prev, int curr, int sequence)
    {
        int pre = prev;
        int cur = curr;
        int next;
        int seq = sequence;
        int evenSum = 0;
        for(int i = 0; i < sequence; i++)
        {
            next = pre + cur;
            if(next%2 == 0)
            {
                evenSum+=next;
                //System.out.println("n%2: " + next);
            }
            
            if(next > 4000000)
            {
                //System.out.println("prevNext: " + (next-pre));
                //System.out.println("exceed value: " + next);
                return evenSum;
                
            }
            pre = cur;
            cur = next;
            //System.out.println("next: " + next);
        }         
        return evenSum;
    }
    
}