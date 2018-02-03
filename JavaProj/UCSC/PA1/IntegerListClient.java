 public class IntegerListClient extends IntegerList{
    static IntegerList reverse = new IntegerList();
    public static void main (String [] args) {
        
         IntegerList L = new IntegerList();
         reverse = L;
         int i, j;
         for(i=1; i<=16; i++){
             j = i*i;
             L.add(i, j);
          }
         System.out.println(L);
         reverseRecursion(L);
         System.out.println(L);
         System.out.println("Search: 100, Index: " + search(L, 100));
         System.out.println("max: "+max(L));
    }
    
    public static void swap (IntegerList L, int i, int j) {
        int iTemp;
        int jTemp;
        iTemp = L.get(i);
        jTemp = L.get(j);
        L.remove(j);
        L.add(j , iTemp);
        L.remove(i);
        L.add(i, jTemp);
    }  
    
    public static int search(IntegerList L, int x) {
        for (int i =1; i < L.size(); i++) {
            if (x == L.get(i)){
                return i;
            }
        }
        return 0;
    }
    
    public static void reverse(IntegerList L) {
        IntegerList reverse = new IntegerList();
        for (int i = 1; i < L.size()+1; i++) {
            reverse.add(i , L.get((L.size()+1)-i)); 
        }
        System.out.println(reverse);
    }   
    //reverseRecursion
    public static void reverseRecursion(IntegerList L) {
       if(L.size() == 0)
       {
           return;
       }
       else
       {
          int front = L.get(1);
          L.remove(1);
          reverseRecursion(L);
          L.add(L.size()+1, front);
        } 
    }
    
    
    public static int max(IntegerList L) {
        int max = L.get(1);
        for (int i = 2; i < L.size(); i++) 
        {
            if(max < L.get(i))
            {
                max = L.get(i);
            }
        }
        return max;  
    }
}



/* for (int i = length; i > 0; i--) {
for(int j = 1; j < length; j++) {
    iTemp = L.get(i);
    L.remove(i);
    L.add(j,iTemp);
}
}*/

/*
public static int max(IntegerList L) {
        int max = -1;
        for (int i = 1; i < L.size(); i++) {
            for(int j = L.size(); j > 0; j--) {
                if (L.get(i) > L.get(j)) {
                    max = L.get(i);
                }
                else max = L.get(j);
            }           
        }
        return max;  
    }
 */
