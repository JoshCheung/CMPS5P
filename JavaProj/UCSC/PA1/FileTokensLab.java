//import java.io.*;
//import java.util.Scanner;

class FileTokensLab{
    public static void main(String []args) {
      	String [] sA = {"the"};
		char[] cA = sA[0].toCharArray();
		//System.out.println(stringReverse(sA[0], cA.length-1));
		System.out.println(stringReverse("hello", 5));
	}
	
	public static String stringReverse(String s, int n) 
	{
	     int len = n-1;
	     if(n > 0) 
	     {
	         System.out.println(s.substring(len, n));
	     } 
	     else 
	     {
		    stringReverse(s.substring(0, len), n-1);
	     }
	     return s;
	}
}








