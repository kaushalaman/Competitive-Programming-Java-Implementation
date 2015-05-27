/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


 class B

 {

  public static void main(String[] args)throws Exception

    {  
	
	/*  BufferedReader br=new BufferedReader(new FileReader("input.txt"));
        BufferedWriter out=new BufferedWriter(new FileWriter("output.txt"));
    */               

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    
        
			//String[] s=br.readLine().split(" ");
			//int n=Integer.parseInt(s[0]); int k=Integer.parseInt(s[0]);
			
			int n=Integer.parseInt(br.readLine());
			int num[]=new int[n];
			String[] s=br.readLine().split(" ");
			for(int i=0;i<n;i++){
				num[i]=Integer.parseInt(s[i]);
			}
        long ans=0;
        out.write(""+ans+"\n");out.flush();               
        	
        
    }//end of public static void main();
	public static boolean isPrime(long n)throws Exception{
		if(n==2||n==3)return true;
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0)return false;
		}
	return true;
	}
	public static long gcd(long a, long b)throws Exception{
		if(b==0)return a;
		return gcd(b,a%b);
	}
 } //end of class       
        