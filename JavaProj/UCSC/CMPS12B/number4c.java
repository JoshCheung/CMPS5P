public class number4c
{
    public static void main(String [] args)
    {
        int A [] = new int[] {5,6,7,8,9,10};
        int s = 0;
        int l = A.length-1;  
        System.out.println(sumArray(A, s, l));
    }
    
    public static int sumArray(int [] A, int s, int l)
    {
        if(s == l)
        {
            return A[s];
        }
        else
        {
            int midpoint = (s+l)/2;
            return sumArray(A, s, midpoint) + sumArray(A, midpoint+1, l);
        }
    }
}