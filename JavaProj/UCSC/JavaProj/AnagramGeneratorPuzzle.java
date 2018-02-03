import java.util.*;
import java.io.*;

class AnagramGeneratorPuzzle
{
        public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(new FileInputStream(args[0]));
        int size = in.nextInt();
        Random rng = new Random();
        int randNum = rng.nextInt(size);
        int i = 0;
        while ( i < size )
        {
            if(i == randNum )
            {
                String chosen = "HelloMyNameis";
                //String chosen = in.next();
              // You should call scambleWord here and print the result and then exit.  Otherwise you will keep reading the words.
                                System.out.println("[" + i + "] -> " + chosen + " scrambled => " + scrambleWord(chosen));
              break;  // This break out of the loop, and exit the program.
            }
            String not_chosen = in.next();
            // if you put this here, you should see it keep reading past i==rand
            //System.out.println("[" + i + "] not-chosen: " + not_chosen);
            i++;
        }
    }


    public static String scrambleWord(String chosen)
    {
        StringBuffer chosenWord = new StringBuffer(chosen); //selected word
        char [] newWord = new char [chosenWord.length()];
        Random rand = new Random();
        int randNum = rand.nextInt(chosenWord.length());
        System.out.println(randNum); //sets up the random function
        System.out.println(chosenWord);
        for(int i = 0; i < newWord.length; i++) // for the first letter in the list, randomly place it in the new location of the new list.
        {
            System.out.println("randNum: " + randNum);
            newWord[i] = chosenWord.charAt(randNum); // takes the randomly selected letter from letterList and places it in the newPhrase
            chosenWord.deleteCharAt(randNum);  // removes the selected letter
            System.out.println(chosenWord);
            System.out.println("newWord[i]: " + newWord[i]);
        }
        return new String(newWord);
    }
}