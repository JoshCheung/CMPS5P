import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Stats{
   public static void main (String [] args) {
      String csvFile = ("/Users/joshuacheung/"\
                        "Documents/Projects/" \
                        "Compsci/JavaProj/"   \
                        "personal/Checking1.csv");
      
      String [] splits = csvFile.split(",");
	   for(int i = 0; i < splits.length; i++) {
         System.out.println("TESTING: " + splits[i]);
      }
   }
}
