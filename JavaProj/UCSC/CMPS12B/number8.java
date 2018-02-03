public class number8
{
    public static void main (String []  args)
    {
        System.out.print(integerToString(100, 8));
    }
    
    public static String integerToString(int n, int b)
    {
        String num = "";
        if(n>0)
        {
            if(n/b>0)
            {
                num += integerToString(n/b, b);
            }
            num += Integer.toString(n%b);
        }
        return num;
    }
}