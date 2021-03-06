//-----------------------------------------------------------------------------
//IntegerList.java
//Array based implementation of Integer List ADT
//-----------------------------------------------------------------------------

public class IntegerList {

    public static final int MAX_LENGTH = 1000;
    private int[] item;        // array of IntegerList items
    private int numItems;      // number of items in this IntegerList
    public static void main(String [] args) {
        IntegerList A = new IntegerList();
        for(int i = 1; i <= 10; i++) {
            A.add(i, i);
        }
        System.out.println(A.size());
        reverse(A);
        System.out.println(A.toString());
    }
    
    // IntegerList
    // constructor for the IntegerList class
    /*public static String toString(IntegerList L) {
    String s = "";
    for(int i = 1; i < L.size()+1; i++) {
    s += "/"+ L.get(i);
    }
    return s;
    }*/
    public String toString(){
        int i;
        StringBuffer sb = new StringBuffer();

        for(i=0; i<numItems; i++) {

            if(i%10 == 0 && i != 0) {
                sb.append("\n");
                sb.append(item[i]).append(" ");
            }
            else sb.append(item[i]).append(" ");
        }
        return new String(sb);
    }
    
    public static void swap(IntegerList theList, int p, int q){
        int ptemp = theList.get(p);
        int qtemp = theList.get(q);
        theList.remove(p);
        theList.remove(q);
        theList.add(q, ptemp);
        theList.add(p, qtemp);
    }
    
    /*
    public static void reverse(IntegerList theList) {
        for(int i = 1; i < (theList.size())/2; i++){
            swap(theList, i, theList.size()-i );
        }
    }
    */
    public static void reverse(IntegerList L){
        if(L.size() == 0){
            return;
        }
        else{
            int front = L.get(1);
            //System.out.println(L);
            L.remove(1);
            System.out.println(L);
            reverse(L);
            L.add(L.size()+1, front);
            System.out.println(L);
            
        }
    }
   
    
    public IntegerList(){
        item = new int[MAX_LENGTH];
        numItems = 0;
    }

    // arrayIndex
    // transforms a IntegerList index to an Array index
    private int arrayIndex(int listIndex){
        return listIndex-1;
    }

    // isEmpty
    // pre: none
    // post: returns true if this IntegerList is empty, false otherwise
    public boolean isEmpty(){
        return(numItems == 0);
    }

    // size
    // pre: none
    // post: returns the number of elements in this IntegerList
    public int size() {
        return numItems;
    }

    // get
    // pre: 1 <= index <= size()
    // post: returns item at position index
    public int get(int index){
        if( index<1 || index>numItems ){
            System.err.println("IntegerList Error: get() called with index out of bounds");
            System.exit(1);
        }
        return item[arrayIndex(index)];
    }

    // add
    // inserts newItem in this IntegerList at position index
    // pre: size() < MAX_LENGTH, 1 <= index <= size()+1
    // post: !isEmpty(), items to the right of newItem are renumbered
    public void add(int index, int newItem){
        if( numItems == MAX_LENGTH ){
            System.err.println("IntegerList Error: add(,) called on full IntegerList");
            System.exit(1);
        }
        if( index<1 || index>(numItems+1) ){
            System.err.println("IntegerList Error: add(,) called with index out of bounds");
            System.exit(1);
        }
        for(int i=numItems; i>=index; i--){ 
            item[arrayIndex(i+1)] = item[arrayIndex(i)];
        }
        item[arrayIndex(index)] = newItem;
        numItems++;
    }

    // remove
    // deletes item from position index
    // pre: 1 <= index <= size()
    // post: items to the right of deleted item are renumbered
    public void remove(int index){
        if( index<1 || index>numItems ){
            System.err.println("IntegerList Error: remove() called with index out of bounds");
            System.exit(1);
        }
        for(int i=index+1; i<=numItems; i++){
            item[arrayIndex(i-1)] = item[arrayIndex(i)];
        }
        numItems--;
    }

    // removeAll
    // pre: none
    // post: isEmpty()
    public void removeAll(){
        numItems = 0;
    }
}