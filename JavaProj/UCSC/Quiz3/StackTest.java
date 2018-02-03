public class StackTest{
    public static void main(String [] args){
        Node H = new Node(9);
        H.next = new Node(7);
        H.next.next = new Node(5);
        for(Node N=H; N!=null; N=N.next) System.out.print(N.item+" ");
        System.out.println();
        //Node N = new Stack.Node(10);
        // Stack.Node.push(10);
        System.out.print(H.item);
            
            
    }
}