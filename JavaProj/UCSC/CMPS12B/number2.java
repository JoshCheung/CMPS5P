public class number2 extends number3b
{
    public static int sum(int n)
    {
        if(n==0)
        {
            return 0;
        }
        else
        {
            return n + sum(n-1);
        }
    }
}
    