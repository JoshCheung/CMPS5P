public class Problem1
{
    public static void main(String[] args)
    {
        int num = Integer.parseInt(args[0]);
        System.out.println("[1]: " + threeFive(num));
        System.out.println("[2]: " + threeFiveRecursion(num));
        
    }
    
    public static int threeFive(int num)
    {
        int sum = 0;
        for(int i = 0; i < num; i++)
        {
            if(i % 3 == 0 || i % 5 == 0)
            {
                sum += i;
            }
        }
        return sum;
    }
    
    public static int threeFiveRecursion(int num)
    {
        int sum = 0;
        if(num % 3 == 0 || num % 5 == 0)
        {
            System.out.println("sum " + sum);
            return sum+=threeFiveRecursion(num-1);
        }
        return sum;
    }
}