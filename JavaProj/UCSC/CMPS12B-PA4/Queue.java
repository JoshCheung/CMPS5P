public class Queue implements QueueInterface{
    private class Node{
        Object item;
        Node next;
        
        public Node(Object item){
            this.item = item;
            next = null;
        }
    }
   
    private Node front;         
    private Node back; 
    private int numItems;    
    
    public Queue() {
        front = null;
        back = null;
        numItems = 0;
    }
    
    public boolean isEmpty(){
        return numItems == 0;
    }
    
    public int length(){
        return numItems;
    }
    
    public void enqueue(Object newItem){
        if(front == null){
            front = new Node(newItem);
            back = front;
            numItems++;
        }
        else{
            Node N = front;
            while(N.next != null){
                N = N.next;
            }
            N.next = new Node(newItem);
            back = N.next;
            numItems++;
        }
    }
    
    public Object dequeue(){
        if(front == null){
            throw new QueueEmptyException("Cannot dequeue empty queue");
        }
        else{
             Node N = front;
             front = N.next;
             numItems--;
             return N.item;
        }
    }
    
    public Object peek(){
        if(front == null){
             throw new QueueEmptyException("Cannot peek empty queue");
        }
        else{
            return front.item;
        }
    }
    
    public void dequeueAll() throws QueueEmptyException{
        if(front == null){
            throw new QueueEmptyException("Queue is already empty");
        }
        else{
            numItems = 0;
            front = null;
            back = null;
        }
    }
    
    public String toString(){
        String s = "";
        for(Node N = front; N!= null; N= N.next) {
            s += N.item + "  ";
        }
        return s;
    }
}