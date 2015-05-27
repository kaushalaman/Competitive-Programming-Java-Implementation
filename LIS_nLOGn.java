/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


class LIS_nLOGn  

 {
		public static long ans=0;
		
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args)throws Exception

    {                 

     
        ans=0;     
        int tests=Integer.parseInt(br.readLine());
     
    	for(int t=0;t<tests;t++){
								
					int n=Integer.parseInt(br.readLine());	
					int num[]=new int[n];					
					String[] s=br.readLine().split(" ");    
					
  					for(int i=0;i<n;i++){
        			    num[i]=Integer.parseInt(s[i]);
					}
					PrintLis(num);

        			//out.write(""+ans+"\n");out.flush();
  		}	      
  }
  //example A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
  public static void main PrintLis(int[] n)throws Exception{

	int[] li=new int[n.length()];   // holds the lis numbers index 	(indirectly numbers of maximum lis sequence)  
	int[] pi=new int[n.length()];	// holds previous index of current maximum lis no  
	int size=0;                     //size of maximum lis
	 
    li[0]=0;
	pi[0]=-1;
	size=1;

	for(int i=1;i<n.length();i++){

		if(n[i]<n[li[0]]){
							
			li[0]=i;
			
		}else if(n[i]>li[size-1]){
				
			 pi[i]=li[size-1];
			 li[size]=i;
			 size++;

		}else if()

		}



  }
}



















