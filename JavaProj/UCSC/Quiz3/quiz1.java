public class quiz1{
    public static void main(String[] args){
        int num = c(4,3);
        int sum = sum(5,10);
        System.out.println(sum);
        System.out.println(num);
        int [] data = {1,2,3,4,5,6,7,8,9,10};
        int sumA = sumSubArray(data, 0, data.length-1);
        System.out.println(sumA);
    }
    
    public static int c(int n, int k){
        if(k == 1){
            return 1;
        }
        else if(n ==k){
            return 1;
        }
        else{
            return c(n-1, k-1) + c(n-1,k);
        }
    }
    
    public static int sum(int left, int right){
        if(left > right){
            return 0;
        }
        else{
            //System.out.println("r " + right); 
            return right + sum(left, right -1);
        }
    }
    
    public static int sumSubArray(int [] data, int left, int right){
        int q = (left+right)/2;
        System.out.println("q: " + q);
        if(left == right){
            return data[right];
        }
        else{
            System.out.println("left:  " + sumSubArray(data, left, q));
            System.out.println("right: " + sumSubArray(data, q+1, right));
            return sumSubArray(data, left, q) + sumSubArray(data, q+1, right);
        }
    }
}