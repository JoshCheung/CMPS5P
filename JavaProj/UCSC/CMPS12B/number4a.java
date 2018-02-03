public class number4a
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
        //Recur on A[0...n-2], add the result to A[n-1], then return the sum.
        if(s == A.length-1)
        {
            return A[s];
        }
        else
        {
            return A[s] + sumArray(A, s+1, l) ;
        }
    }
}
        