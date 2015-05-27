/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

//zee algorithm to find pattern P in the larger text T in O(|S|+|T|)
 class Zee_StringMatching{
	
	
  public static void main(String[] args)throws Exception

    {  
	
	/*  BufferedReader br=new BufferedReader(new FileReader("input.txt"));
        BufferedWriter out=new BufferedWriter(new FileWriter("output.txt"));
    */
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in),2000);
    BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out),2000);
	String T = br.readLine();
	String P = br.readLine();
	String S = P+"$"+T;
	char []s = S.toCharArray();
	int z[] = new int[1+S.length()];
	//compution of Zi(S) function
	int len=S.length(),l=0,r=0;
	z[0]=len;
		for(int i=1;i<len;i++){
			if(i>r){
				l=i;r=i;
				while(r<len&&s[r]==s[r-l])r++;
				z[i]=r-l;r--;
			}else{
				int k=r-i; //k represents k'
				
				if(z[k]<r-i+1){z[i]=z[k];r=i+z[k];}
				//else if(z[k]>r-i+1)z[i]=r-i+1;
				else if(z[k]>=r-i+1){
					l=i;
					while(r<len&&s[r]==s[r-l])r++;
					z[i]=r-l;r--;
				}
				l=i;//
			}
		
		}
	 for(int i=0;i<len;i++){
		out.write(""+z[i]+" ");out.flush();
	 
	 }	
    }   
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
	public static long lcm(long a, long b)throws Exception{
		if(b==0||a==0)return 0;
		return (a*b)/gcd(a,b);
	}
	public static long pow(long a,long b,long mod)throws Exception{
	if(b==1)return a%mod;
	if(b==0)return 1;
	long ans=pow(a,b/2,mod);
	ans=(ans*ans)%mod;
	if(b%2!=0)ans=(ans*a)%mod;
	
	return ans;
	}
 } //end of class        
        
