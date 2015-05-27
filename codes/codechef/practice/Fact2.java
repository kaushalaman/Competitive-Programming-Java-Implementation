/* packagie joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


class Main  

 {
		public static int ans;

  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    
      // byte digit[]=new byte[101];
	 //boolean[] check=new boolean[101];
     //int num[]=new int[99999]; 
        ans=0;     
        int tests=Integer.parseInt(br.readLine());
        BigInteger f[]=new BigInteger[101];
	
	for(int i=1;i<=100;i++){f[i]= new BigInteger((""+i));}
        for(int i=2;i<=100;i++){f[i]=f[i].multiply(f[i-1]);}
        
    for(int i=0;i<tests;i++){
								
					int n=Integer.parseInt(br.readLine());	
					out.write("\n"+f[n].toString());out.flush();
					
		}
							

  	}				      
  }

