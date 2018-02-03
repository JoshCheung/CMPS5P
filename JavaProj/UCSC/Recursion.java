class Recursion {
	public static void main(String[] args){
		   
		   int[] A = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7}; 
		   int[] B = new int[A.length];
		   int[] C = new int[A.length];
		  int minIndex = minArrayIndex(A, 0, A.length-1);
		  int maxIndex = maxArrayIndex(A, 0, A.length-1);
		   
		   for(int x: A) System.out.print(x+" ");
		   System.out.println(); 
		   
		   System.out.println( "minIndex = " + minIndex );  
		   System.out.println( "maxIndex = " + maxIndex );  

		   reverseArray1(A, A.length, B);
		   for(int x: B) System.out.print(x+" ");
		   System.out.println();
		   
		   reverseArray2(A, A.length, C);
		   for(int x: C) System.out.print(x+" ");
		   System.out.println();
		   
		   reverseArray3(A, 0, A.length-1);
		   for(int x: A) System.out.print(x+" ");
		   System.out.println(); 
		   
	}
	// reverseArray1()
	// Places the leftmost n elements of X[] into the rightmost n positions in
	// Y[] in reverse order
	static void reverseArray1(int[] X, int n, int[] Y){
		int length = X.length-1;
		if (n > 0) {
			Y[n-1] = X[length-(n-1)];
			reverseArray1(X, n-1, Y);
		}
	}

	// reverseArray2()
	// Places the rightmost n elements of X[] into the leftmost n positions in
	// Y[] in reverse order.
	static void reverseArray2(int[] X, int n, int[] Y){
		int length = X.length-1;
		if(n > 0) {
			Y[length - (n-1)] = X[n-1];
			reverseArray2(X, n-1, Y);
		}
	}

	// reverseArray3()
	// Reverses the subarray X[i...j].
	static void reverseArray3(int[] X, int i, int j){
		int temp [] = new int [X.length];
		
		if (i < j) {
			//We set the left and right part of the array into temp and then copy the left part 
			//of the array into the right part vice versa into X.
			temp[i] = X[i];
			temp[j] = X[j];
			X[i] = temp [j];
			X[j] = temp [i];
			reverseArray3(X, i+1, j-1);
		}
		
	}

	// maxArrayIndex()
	// returns the index of the largest value in int array X
	static int maxArrayIndex(int[] X, int p, int r){
		int q;
		int index;
		
		if (p < r) {
			
			q = (p+r)/2;
			//Checks if left part of array is greater than right part array.
			if (X[maxArrayIndex(X, p, q)] > X[maxArrayIndex(X, q+1, r)]) {
				index = maxArrayIndex(X, p, q);
			}
			else {
				//Checks if right part array is greater than or equal to left part.
				index = maxArrayIndex(X, q+1, r);
			}
			//Base case will set index to p
		} else {
			index = p;
		}
		return index;
	}

	// minArrayIndex()
	// returns the index of the smallest value in int array X
	static int minArrayIndex(int[] X, int p, int r){
		int q;
		int index;
		
		if (p < r) {
			
			q = (p+r)/2;
			//Checks if left part of array is less than right part of array.
			if (X[minArrayIndex(X, p, q)] < X[minArrayIndex(X, q+1, r)]) {
				index = minArrayIndex(X, p, q);
			}
			//Checks if right part array is less than or equal to right part.
			else {
				index = minArrayIndex(X, q+1, r);
			}
			//Base case will set index to p	
		} else {
			index = p;
		}
		return index;
	}

}
/* Output:
-1 2 6 12 9 2 -5 -2 8 5 7
minIndex = 6
maxIndex = 3
7 5 8 -2 -5 2 9 12 6 2 -1
7 5 8 -2 -5 2 9 12 6 2 -1
7 5 8 -2 -5 2 9 12 6 2 -1
*/