import java.io.*;
import java.util.Scanner;

public class Simulation{

    //-----------------------------------------------------------------------------
    //
    // The following function may be of use in assembling the initial backup and/or
    // storage queues.  You may use it as is, alter it as you see fit, or delete it
    // altogether.
    //
    //-----------------------------------------------------------------------------

    public static Job getJob(Scanner in) {
        String[] s = in.nextLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        return new Job(a, d);
    }

    //-----------------------------------------------------------------------------
    //
    // The following stub for function main contains a possible algorithm for this
    // project.  Follow it if you like.  Note that there are no instructions below
    // which mention writing to either of the output files.  You must intersperse
    // those commands as necessary.
    //
    //-----------------------------------------------------------------------------

    public static void main(String[] args) throws IOException{
        if(args.length != 1){
            System.err.println("Usage: Simulation infile outfile");
            System.exit(1);
        }
        // count the number of lines in file
        // count the number of lines in file 
        Scanner in = new Scanner(new File(args[0]));
        in.useDelimiter("\\Z"); // matches the end of file character
        String s = in.next();  // read in whole file as a single String
        in.close();
        String [] lines = s.split("\n");  // split s into individual lines
        int lineCount = lines.length;  // extract length of the resulting array
        int m = Integer.parseInt(lines[0]); //number of jobs
        int [] arrival = new int [m];
        int [] durration = new int [m];
        int [] finish = new int[m];
        int time = 0; 
        Queue StorQ = new Queue();
        for(int a = 0; a < m; a++) {
            finish[a] = -1; //remember if it is -1, print *
        }
        
        for(int i = 1; i < lineCount; i++) {
            String [] num = lines[i].split(" ");
            for(int j = 0; j < num[j].length(); j++) {
                if(j%2 == 0){
                   arrival[j] = Integer.parseInt(num[j]);
                }
                else{
                    durration[j] = Integer.parseInt(num[j]);                  
                }
            }
        }
        /*
        FileReader input = new FileReader(args[0]);
        */
        while(
        
        
        //    1.  check command line arguments
        //
        //    2.  open files for reading and writing
        //
        //    3.  read in m jobs from input file
        //
        //    4.  run simulation with n processors for n=1 to n=m-1  {
        //
        //    5.      declare and initialize an array of n processor Queues and any 
        //            necessary storage Queues
        //
        //    6.      while unprocessed jobs remain  {
        //
        //    7.      determine the time of the next arrival or finish event and 
        //            update time
        //
        //    8.      complete all processes finishing now
        //
        //    9.      if there are any jobs arriving now, assign them to a processor 
        //               Queue of minimum length and with lowest index in the queue array.
        //
        //    10.     } end loop
        //
        //    11.     compute the total wait, maximum wait, and average wait for 
        //            all Jobs, then reset finish times
        //
        //    12. } end loop
        //
        //    13. close input and output files
    
    }
}
