/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


 class B

 {

  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    
        int tests=Integer.parseInt(br.readLine());
        for(int t=0;t<tests;t++){
        String[] s=br.readLine().split(" ");
		long n=Long.parseLong(s[0]);
		long m=Long.parseLong(s[1]);
		long p=(n/2)*(m-(m/2))+(n-(n/2))*(m/2);
		long q=m*n;
		long g=gcd(p,q);
		p/=g;
		q/=g;
        out.write(""+p+"/"+q+"\n");out.flush();               
        	
        }
    }  
	public static long gcd(long a ,long b)throws Exception{
	 if(b==0)return a;
	 else return gcd(b,a%b);
	}
 }        
        