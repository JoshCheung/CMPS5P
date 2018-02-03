public class Problem4 extends IntegerList {
	public static void main(String [] args)
	{
	    IntegerList Q = new IntegerList();
	    for(int i = 1; i < 100; i++)
	    {
	        System.out.print(i+ " ");
	        if(i % 20== 0)
	        {
	            
	            System.out.println("\n");
	           }
	        Q.add(i, i);
	       }
	    System.out.println();
	    System.out.println(toString(Q));
	    
	   }
	   
	public static String toString(IntegerList Q){
		 int i;
		 StringBuffer sb = new StringBuffer();
		
		for(i=1; i<= Q.size(); i++) {
			
			if((i-1)%10 == 0) {
				sb.append("\n");
				sb.append(Q.get(i)).append(" ");
			}
			else 
			{
			    sb.append(Q.get(i)).append(" ");
			 }
		}
			return new String(sb);
	}
}
