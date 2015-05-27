/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


 class A

 {

  public static void main(String[] args)throws Exception

    {  
	
	/*  BufferedReader br=new BufferedReader(new FileReader("input.txt"));
        BufferedWriter out=new BufferedWriter(new FileWriter("output.txt"));
    */               

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    
        int tests=Integer.parseInt(br.readLine());
        for(int t=0;t<tests;t++){
			/*String[] s=br.readLine().split(" ");
			  int n=Integer.parseInt(s[0]); int k=Integer.parseInt(s[1]);
			 */ 
			
			String[] s=br.readLine().split(" ");
			long a = Long.parseLong(s[0]);
			long d = Long.parseLong(s[1]);
			
			long p=Long.parseLong(br.readLine());	
        	if(a!=p && d==0){
				out.write("-1\n");out.flush();
				continue;
			}
			if(a==p && d==0){
				out.write("0\n");out.flush();
				
			}
			
        }//tests
    }//end of public static void main    	
 } //end of class        
        
		
		
		
		
		
		
		