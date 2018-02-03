public class practice1{
    public static void main(String [] args) {
        char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[] beta  = {'a', 'j', 'c', 'k', 'e', 'l'};
        int index = search(alpha, 'c');
        String di = diff(alpha, beta);
        System.out.println(di);
        //System.out.println(index);
    }
    
    static int search(char [] word, char letter){
        for(int i = 0; i < word.length; i++){
            if(word[i] == letter) {
                return(i); //returns index
            }
        }
        return -1;
    }
    
    static String diff(char [] alpha, char [] beta) {
        String buffer = "";
        for(int i = 0; i < alpha.length; i++) {
            if(search(beta, alpha[i]) < 0) {
                System.out.println(alpha[i]);
                //buffer+=alpha[i];
            }
            //System.out.println(buffer);
        }
        return buffer;
    }
}