import java.util.EmptyStackException;
class Stack{
    private class Node{
        int item;
        Node next;
        Node(int item){
            this.item = item;
            this.next = null;
        }
        private Node top;
        private int numItems;
        public void Stack() { top = null; numItems = 0;}
        
        void push(int x){
            if(numItems == 0){
                top = new Node(x);
                numItems++;
            }
            else{
                Node N = new Node(x);
                N.next = null;
                top = N;
                numItems++;
            }
        }
        
        int pop(){
            if(numItems == 0){
                 throw new EmptyStackException();
            }
            else{
                Node temp = top;
                top = top.next;
                numItems--;
                return temp.item;
            }
        }
        
        
       

	}
}


        