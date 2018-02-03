public class number7 {
    public static void main(String[] args){
        displayOctal(100);
    }
    
    static void displayOctal(int n){
        if(n>0){
            if(n/8>0){
                displayOctal(n/8);
            }
            System.out.println(n%8);
        }
    }
}