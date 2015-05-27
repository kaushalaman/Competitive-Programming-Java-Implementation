/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


 public class Solution

 { 
  public static void main(String[] args)throws Exception

    {  
	
	/*  BufferedReader br=new BufferedReader(new FileReader("input.txt"));
        BufferedWriter out=new BufferedWriter(new FileWriter("output.txt"));
    */               

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
			String s[] = {"6AM#8AM","11AM#1PM","7AM#3PM","7AM#10AM","10AM#12PM","2PM#4PM","1PM#4PM","8AM#9AM"};
			int ans = jobMachine(s);
			out.write(""+ans);
			out.flush();
			  			  
			   
        	
        
    }//end of public static void main();
//1 1 1 1 1 1 1 1 1 1 1 1 1
 
    public static int jobMachine(String[] input1)throws Exception
    {
        //Write code here
        int n = input1.length;
        int st[] = new int[n+1];
        int end[] = new int[n+1];
        for(int i=1;i<=n;i++){
         String s[] =input1[i-1].split("#");
         String temp = "";
         for(int j=0;j<s[0].length()-2;j++){
          temp+=s[0].charAt(j);
         }
         
         st[i]=Integer.parseInt(temp);
         if(s[0].charAt(s[0].length()-2)=='P'&&st[i]<12)st[i]+=12;
         temp = "";
         for(int j=0;j<s[1].length()-2;j++){
          temp+=s[1].charAt(j);
         }
         
         end[i]=Integer.parseInt(temp);
         if(s[1].charAt(s[1].length()-2)=='P'&&end[i]<12)end[i]+=12;
         
        }
        int dp [][] = new int[n+1][26];
        for(int i=1;i<=n;i++){
          for(int j=1;j<=25;j++){
            dp[i][j] = Math.max(dp[i-1][j],dp[i][j]);
            dp[i][j] = Math.max(dp[i][j-1],dp[i][j]);
            
            if(end[i]==j){
            	dp[i][j]=Math.max(dp[i-1][j],1+dp[i][st[i]]);
            }
			
          }
        
        }
        int ans = 500 * dp[n][25];
        return ans;
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
        
