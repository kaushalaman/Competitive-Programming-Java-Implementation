/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


class Main  

 {
		public static int ans;
		static boolean[] isPrime=new boolean[4001];

  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    	//boolean[] isPrime=new boolean[4001];
	for(int i=0;i<=4000;i++)isPrime[i]=false;
	
	for(int i=1;i<=4000;i++){isPrime[i]=isPrime(i);}	
      // byte digit[]=new byte[101];
	 //boolean[] check=new boolean[101];
     //int num[]=new int[99999]; 
        ans=0;     
        int tests=Integer.parseInt(br.readLine());
     
    for(int i=0;i<tests;i++){
								
					//int n=Integer.parseInt(br.readLine());	
					//int num[]=new int[n];					
					String[] ss=br.readLine().split(" ");    
					int a=Integer.parseInt(ss[0]);int b=Integer.parseInt(ss[1]);
					ans=getHigh(a+b);
					ans=ans-a-b;  					
    			out.write("\n"+ans);out.flush();
  	}	      
  }
	public static boolean isPrime(int x)throws Exception{
	if(x==1||x==2||x==3)return true;
	//boolean check=true;
	for(int i=2;i<=(int)Math.sqrt(x);i++){
	if(x%i==0)return false;
	}
	
	return true;
	}
	public static int getHigh(int x)throws Exception{
	for(int i=x+1;i<=4000;i++){
		if(isPrime[i]==true)return i;

	}
	return -1;
	}
}
