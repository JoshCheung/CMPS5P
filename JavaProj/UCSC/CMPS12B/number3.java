public class number3
{
    public static int sum(int n, int m)
    {
        int sum;
        if(n > m)
        {
            return 0;
        }
        else
        {
            return m + sum(n, m-1); //sum(n+1, m) + n
        }
    }
}
    