// file: NodeTest.java
public class NodeTest{
    public static void main(String[] args){
        Node H = new Node(9);
        H.next = new Node(7);
        H.next.next = new Node(5);
        // part (a) refers to this point in the code

        for(Node N=H; N!=null; N=N.next) System.out.print(N.item+" ");
        System.out.println();
        // part (b) refers to this point in the code
        // part (c) refers to this point in the code
        //
        //
        Node newNode = new Node(4);
        newNode.next = H.next.next;
        H.next.next = newNode;
        //
        //
        //
        for(Node N=H; N!=null; N=N.next) System.out.print(N.item+" ");
        // your code goes here
        System.out.println();
        printForward(H);
        System.out.println();
        printBackward(H);
        System.out.println();
        System.out.println(product(H));
        insertAfter(H, 3, 11);
        for(Node N=H; N!=null; N=N.next) System.out.print(N.item+" ");
        System.out.println(isEqual(H, newNode));
    }
    
    static void printForward(Node H){
        // your code goes here
        if(H!=null)
        {
            System.out.print(H.item+ " ");
            printForward(H.next);
        }
    }
    
    static void printBackward(Node H){
      if(H!=null){
         printBackward(H.next);
         System.out.print(H.item+" ");
        }
    }
    
    static int product(Node H){
        // Your code goes here
        if(H == null){
            return 1;
        }
        else{
            return H.item*product(H.next);
        }
    }
    
    static void insertAfter(Node n, int idx, int value)
    {
        if( idx == 1 ) {
            Node t = new Node (value);
            t.next = n.next;
            n.next = t;
        }  
        else {
            insertAfter(n.next, idx-1, value);
        }
    }
        
        
    static boolean isEqual (Node n1, Node n2)
    {
        while (n1 != null && n2 != null && n1.item == n2.item)
        {  
            n1 = n1.next;
            n2 = n2.next;		
        }
        return (n1 == null && n2 == null);
	
    }
}