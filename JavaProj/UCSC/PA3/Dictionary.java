public class Dictionary implements DictionaryInterface{
    private class Node{
        // fields
        public String key;
        public String value;
        public Node next;
        // constructor
        public Node(String x, String val){
            key = x;
            value = val;
            next = null;
        }
    }   
    
    private int numItems = 0;
    private Node top;
    
    public void Dictionary()
    {
        top = null;
        numItems = 0;
    }
    
    public boolean isEmpty(){
        return numItems == 0;
    }
    
    public int size(){
        return numItems;
    }
    
    public String lookup(String key){        
        Node N = top;
        while(N != null){
            if(N.key==(key)){
                return N.value; //return the values
            }
            N = N.next; 
        }
        return null; //if N.next is null
    }
    
    public void insert(String key, String value){
        if(lookup(key) != null){
           throw new DuplicateKeyException("Cannot insert duplicate key");
        }
        else {
            if(top == null) { //checks to see if top is null
                Node t = new Node(key, value); //if it is, insert at the top
                top = t; 
                numItems++; 
                //Node N = top; 
            }
            else{
                Node N = top; 
                while(N != null){
                    if(N.next == null){ //if N.next is null
                        break; // because nothing found
                    }
                    N = N.next; //check next node
                }
                N.next = new Node(key, value); //insert new node 
                numItems++;
            }
        }
    }
    
    public void delete(String key) {
        if(lookup(key) == null) {
            throw new KeyNotFoundException("cannot delete non-existent key");
        }
        else{
            Node N = top; 
            if(N.key == key){ //checks key
                top = N.next; //takes out the first item
                numItems--; 
            }
            else {
                while(N.next.key!=key){ //searches for the same key
                    N = N.next; //if not the same, check next node/key
                }
                N.next = N.next.next; // check next Node
                numItems--; //decrement numItems
            }
        }
    }
    
    public void makeEmpty(){
        top = null;
        numItems = 0;
    }
    
    
    public String toString(){
        String s = ""; 
        Node t = top;
        while(t != null){
            s+= t.key+ " " + t.value+ "\n";
            t = t.next;
        }
        return s;
    }
   
}
   
    
