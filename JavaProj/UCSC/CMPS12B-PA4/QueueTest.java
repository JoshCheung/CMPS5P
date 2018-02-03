public class QueueTest{
    public static void main(String[] args){
        Queue Q = new Queue();
        System.out.println("isEmpty = " + Q.isEmpty());
        Q.enqueue((int)10);
        Q.enqueue((int)20);
        Q.enqueue((int)30);
        Q.enqueue((int)40);
        Q.enqueue((int)50);
        Q.enqueue((int)100);
        System.out.println("Q = " + Q);
        System.out.println("isEmpty = " + Q.isEmpty());
        System.out.println("Length = " + Q.length());
        
    }
}