public class Problem3
{
    public static void main(String[] args)
    {
        long value = 600851475143L;
        long bg = largestPrime(600851475143L);
        System.out.println();
        System.out.println("The largest Prime Factor is: " + bg);
    }
    
    public static long largestPrime(long value) //600851475143
    {
        long val = value;
        //long fact = 0;
        for(long i= 2; i < val; i++)
        {
            if(val%i!= 0)
            {   
                i++;
            }
            else
            {
                System.out.println(i);
                val/= i;
                i++;
                System.out.println(val);
            }
        }
        return val;
    }
}