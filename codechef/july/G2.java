/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


 class G2 {
	
	
  public static void main(String[] args)throws Exception

    {  
	
	/*  BufferedReader br=new BufferedReader(new FileReader("input.txt"));
        BufferedWriter out=new BufferedWriter(new FileWriter("output.txt"));
    */               

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    		
    	int tests=Integer.parseInt(br.readLine());
    	int mod[][][] = new int[101][101][101];
    	
    	for(int i=0;i<=100;i++){
    		for(int j=0;j<=100;j++){
    			for(int k=1;k<=100;k++){
    			
    				mod[i][j][k]=(i*j)%k;
    			}
    		
    		}
    	}
    	
			int[][] dp = new int[51][51];
			//int num[]=new int[100000];
        for(int t=0;t<tests;t++){
        		
				String[] s=br.readLine().split(" ");
				int n=Integer.parseInt(s[0]);int c=Integer.parseInt(s[1]);int k=Integer.parseInt(s[2]);
				
				
				double [][] cp= new double[k+1][c+1];
				for(int i=0;i<=k;i++){
				
					for(int kk=0;kk<c;kk++){
						cp[i][kk]=0;
					}
				}
				cp[0][1]=1.0D;
				
				for(int i=1;i<=k;i++){
				
					for(int kk=0;kk<c;kk++){
							//dp[i][j][k]+=dp[i-1][j][k]/c;
							cp[i][kk]+=0.5*cp[i-1][kk];
							for(int m=0;m<c;m++){
								cp[i][mod[kk][m][c]]+=0.5*(cp[i-1][kk]*(1.0/c));			
							}
						}
				
				}
				
				for(int i=0;i<=k;i++)for(int j=1;j<=n;j++)dp[i][j]=0;
				
				
				for(int i=1;i<=k;i++){
					s=br.readLine().split(" ");
					int l=Integer.parseInt(s[0]);int r=Integer.parseInt(s[1]);
					
					
					for(int j=1;j<l;j++){
					
							dp[i][j]=dp[i-1][j];
						
					}
					for(int j=r+1;j<=n;j++){
					
						  dp[i][j]=dp[i-1][j];
						
					}
					
					for(int j=l;j<=r;j++){
					
						
						dp[i][j]=dp[i-1][j]+1;
						}
					
					}
				
				double ans=0.0D;
				for(int i=1;i<=n;i++){
				
				for(int j=0;j<c;j++){
					ans+=j*cp[dp[k][i]][j];
					}
				}
				out.write(""+ans+"\n");out.flush();	
			
		}
    }//end of public static void main 
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
        
