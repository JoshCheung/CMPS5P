public class number3b
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
            return n + sum(n+1, (m+n)/2) + sum((m+n)/2 + 1 , m);
        }
    }
}