/* package joney_000 
   codechef/march/prob1  */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


class Main  

 {
		public static  long ans,one;

  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    
      // byte digit[]=new byte[101];
	 //boolean[] check=new boolean[101];
     //int num[]=new int[99999]; 
        ans=0;     one=1;
        int tests=Integer.parseInt(br.readLine());
        for(int i=0;i<tests;i++){
								
					//int n=Integer.parseInt(br.readLine());	
					//int num[]=new int[n];					
					String[] ss=br.readLine().split(" ");    
				    long a=Integer.parseInt(ss[0]);long b=Integer.parseInt(ss[1]);
				    long aa=a;long bb=b;
					while(a!=b){
						if(a<b){
						   if((b&one)==0)b=b>>1;
						    else b=(b-1)>>1;	
						}else{ 
                                                   if((a&one)==0)a=a>>1;
                                                    else a=(a-1)>>1;
						     }
					}	
				ans=dist(aa)+dist(bb)-2*dist(a);			    		
        			out.write("\n"+ans);out.flush();
  	}	      
  }
	public static long dist(long n)throws Exception{
		
	if(n==1||n<1)return 0;
	if(n==2||n==3)return 1;
	if((n&one)==one)return (1+dist((n-1)>>1));
	else return (1+dist(n>>1));
	}
}
