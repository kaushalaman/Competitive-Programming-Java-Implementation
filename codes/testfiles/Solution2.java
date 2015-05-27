/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


 public class Solution implements Comparable<Solution>

 { 
  public int a=0,b=0;
  public Solution(){}
  public int compareTo(Solution p){
  if(this.b==p.b){
   return this.a-p.a;  
  }
  return this.b-p.b; 
 }
  public static void main(String[] args)throws Exception

    {  

	/*  BufferedReader br=new BufferedReader(new FileReader("input.txt"));
        BufferedWriter out=new BufferedWriter(new FileWriter("output.txt"));
    */               

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
			int tests = Integer.parseInt(br.readLine());
			//int arr[] = new int[100005];
			for(int t=1;t<=tests;t++){
			  // String s[] = br.readLine().split(" ");
			    int k = Integer.parseInt(br.readLine());
				int n = Integer.parseInt(br.readLine());
			    
				//s = br.readLine().split(" ");
				long ans =0;
				Solution pair[]= new Pair[n+1]; 
				int arr[] = nw int [24*600];
				for(int i=1;i<=n;i++){
				  String s[] = br.readLine().split(" ");
				  String a[] = s[0].split(":");
				  int t1 = 60*Integer.parseInt(a[0])+Integer.parseInt(a[1]);
				  a = s[1].split(":");
				  int t2 = 60*Integer.parseInt(a[0])+Integer.parseInt(a[1]);
				  if(t2<=t1)t2+=12*60;
				  pair[i]=new Solution();
				  pair[i].a=t1;pair[i].b=t2;
				  arr[t1]+=-1;
				  arr[t2+1]+=1;
				  //arr[i]=Integer.parseInt(s[i-1]);
				}
				Arrays.sort(pair,1,n+1);
				for(int i=0;i<=24*600;i++){
				
				
				}
			    out.write(""+ans+"\n");
			}
			
			
			out.flush();
			  			  
			   
        	
        
    }//end of public static void main();
//1 1 1 1 1 1 1 1 1 1 1 1 1
 
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
        
