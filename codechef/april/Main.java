/* package joney_000 
   codechef/april/count_matrics	
	*/

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
 	int a=0,b=0,c=0,d=0;    
    	for(int t=0;t<tests;t++){
								
					int n=Integer.parseInt(br.readLine());	
					//int num[]=new int[n];					
					//String[] ss=br.readLine().split(" ");    
					int count=0,count1=0,count2=0;
  					for(int i=1;i<=n/2;i++){
        				  a=i;d=n-i;
				          

						//for(int j=1;j<(int)Math.sqrt(a*d);j++){
					  
					 		
				         count2=0;
					 for(int j=1;j<=(int)Math.sqrt(a*d-1);j++){						
							
						b=j;
						c=(a*d-1)/j;
						count2=2*(c-(j-1))-1; 		
						} 
					if(a==d)count+=count2;
				        else count+=2*count2; 
					}		
        		out.write("\n"+count);out.flush();
  	}				      
  }
}
