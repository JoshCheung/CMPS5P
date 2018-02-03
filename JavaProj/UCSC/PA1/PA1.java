public class PA1
{
    public static void main(String[] args)
    {

           int[] A = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
           int[] B = new int[A.length];
           int[] C = new int[A.length];
           
           int minIndex = minArrayIndex(A, 0, A.length-1);
           int maxIndex = maxArrayIndex(A, 0, A.length-1);

           for(int x: A) System.out.print(x+" ");
           System.out.println();

           //System.out.println( "minIndex = " + minIndex );
           //System.out.println( "maxIndex = " + maxIndex );
           reverseArray1(A, A.length, B);
           for(int x: B) System.out.print(x+" ");
           System.out.println();

           reverseArray2(A, A.length, C);
           for(int x: C) System.out.print(x+" ");
           System.out.println();

           //reverseArray3(A, 0, A.length-1);
           for(int x: A) System.out.print(x+" ");
           System.out.println();
  
    }

    public static int maxArrayIndex(int [] A, int n, int l)
    {
        int q;
        if(p < r) 
        {
            q = (p+r)/2;
        }
    }
}