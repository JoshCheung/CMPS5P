public class DictionaryTest{
    public static void main(String [] args){
        Dictionary A = new Dictionary(); 
        A.insert("1","a"); //insert Node to dictionaary
        System.out.println(A.isEmpty()); //check if it is empty, if this works it should return false
        A.insert("2","b"); //insert more nodes
        A.insert("3","c"); // " " "
        System.out.println(A.isEmpty()); //check again if dictionary is empty
        System.out.println(A.size()); //check size, should be 3
        A.insert("4","d"); //insert more nodes 
        A.insert("5","e"); //" " "
        A.insert("6","f"); //" " "
        A.insert("7","g"); //" " "
        A.insert("8","h"); //" " "
        A.insert("9","i"); //" " "
        A.insert("10","j"); //" " "
        System.out.println(A.size()); //check size again, should be 10
        System.out.println(A.lookup("5"));
        //System.out.println(A.toString());
        A.delete("7"); //delete Node from dictionary
        A.delete("3"); // "      "    "       "
        A.delete("10"); // "      "    "       "
        System.out.println(A.size()); //check size to make sure it still works. should be 7
        
        System.out.println(A.toString()); // print out all elements in the library
        A.makeEmpty(); //make everything empty
        System.out.println(A.isEmpty()); //should return true if make empty works
    }
}