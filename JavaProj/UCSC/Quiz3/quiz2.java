public class quiz2{
    public static void main(String[] args){
        IntegerList list = new IntegerList();
        for(int i = 0; i < 10; i++){
            list.add(i, i);
        }
        System.out.println(list);
    }
}