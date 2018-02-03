import java.io.*;
import java.util.Scanner;

public class Search
{
    public static void main(String[] args)
    {
        
    
    
    }

    public static void main(String[] args) throws IOException 
    {

        // check number of command line arguments
        if(args.length != 1){
            System.err.println("Usage: LineCount file");
            System.exit(1);
        }
      
        // count the number of lines in file
        Scanner in = new Scanner(new File(args[0]));
        int lineCount = 0;
        while( in.hasNextLine() ){
            in.nextLine();
            lineCount++;
        }
        in.close();
      
        // print out the number of lines in file
        System.out.println( args[0]+" contains "+lineCount+" lines" );
    }
    
    static mergeSort(String[] word, int [] lineNumber, int p, int r)
    {
        
        
        
    }
}
    


//Search file target1 
//file1
//entire
//beginning
//possibly
//specified
//key
//value
//initial
//before
//dictionary
//however

/*
 * import java.io.*;
import java.util.Scanner;

class LineCount {

   public static void main(String[] args) throws IOException {

      // check number of command line arguments
      if(args.length != 1){
         System.err.println("Usage: LineCount file");
         System.exit(1);
      }
      
      // count the number of lines in file
      Scanner in = new Scanner(new File(args[0]));
      int lineCount = 0;
      while( in.hasNextLine() ){
         in.nextLine();
         lineCount++;
      }
      in.close();
      
      // print out the number of lines in file
      System.out.println( args[0]+" contains "+lineCount+" lines" );
   }
}


import java.io.*;
import java.util.Scanner;

class LC {

   public static void main(String[] args) throws IOException {

      // check number of command line arguments
      if(args.length != 1){
         System.err.println("Usage: LC file");
         System.exit(1);
      }
      
      // count the number of lines in file
      Scanner in = new Scanner(new File(args[0]));
      in.useDelimiter("\\Z"); // matches the end of file character
      String s = in.next();  // read in whole file as a single String
      in.close();
      String[] lines = s.split("\n");  // split s into individual lines
      int lineCount = lines.length;  // extract length of the resulting array
      
      // print out number of lines in file
      System.out.println( args[0]+" contains "+lineCount+" lines" );
   }
}
 */




