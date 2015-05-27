/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


 class D

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
			int n=Integer.parseInt(br.readLine());
			int num[]=new int[n];
			String[] s=br.readLine().split(" ");
			for(int i=0;i<n;i++){
				num[i]=Integer.parseInt(s[i]);
			}
        
        out.write(""++"\n");out.flush();               
        	
        }//tests
    }//end of public static void main    	
 } //end of class        
        