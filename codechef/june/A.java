/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


 class A

 {

  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    
        int tests=Integer.parseInt(br.readLine());
        for(int t=0;t<tests;t++){
        int n=Integer.parseInt(br.readLine());
        int num[]=new int[n];
		String[] s=br.readLine().split(" ");
        int maxln=0;int templn=0;
		for(int i=0;i<n;i++){
		num[i]=Integer.parseInt(s[i]);if(num[i]>0){templn++;if(maxln<templn){maxln=templn;}}else templn=0;
							}
        
        out.write(""+maxln+"\n");out.flush();               
        	
        }
    }    	
 }        
        