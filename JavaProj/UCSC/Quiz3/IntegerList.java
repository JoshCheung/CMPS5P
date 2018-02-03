public class IntegerList implements IntegerListInterface{
    private int[] theList;        // array of IntegerList items
    private int numItems;      // number of items in this IntegerList
    
    public IntegerList(){
        theList = new int[100];
        numItems = 0;
    }
    
    public boolean isEmpty(){
        return numItems == 0;
    }
    
    public int size(){
        return numItems;
    }
    
    public int get(int index){
        if(index < 1 || numItems < 1){
            System.out.println("can't get on an empty list");
        }
        return theList[index];
    }
    
    public void add(int index, int newItem){
        if( index<1 || index > (numItems+1) ){
            System.err.println("IntegerList Error: add(,) called with index out of bounds");
            System.exit(1);
        }
        for(int i=numItems; i>=index; i--){ 
            theList[get(i+1)] = theList[get(i)];
        }
        theList[index] = newItem;
        numItems++;
    }
    
    public void remove(int index){
        if(index < 1 || numItems < 1){
            System.out.println("can't remove on an empty list");
        }
        for(int i = numItems; i <= index; i++){
             theList[get(i-1)] = theList[get(i)];
        }
        numItems--;
    }
    
    public void removeAll(){
        numItems = 0;
    }
}