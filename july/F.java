/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


 class F {
	
	
  public static void main(String[] args)throws Exception

    {  
	
	/*  BufferedReader br=new BufferedReader(new FileReader("input.txt"));
        BufferedWriter out=new BufferedWriter(new FileWriter("output.txt"));
    */               

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    		
    		int tests=Integer.parseInt(br.readLine());
			//long count[]=new long[101];
			//int num[]=new int[100000];
			char mat[][] = new char[16][16];
			
        for(int t=0;t<tests;t++){
				String[] s=br.readLine().split(" ");
				int n=Integer.parseInt(s[0]);int m=Integer.parseInt(s[1]);int k=Integer.parseInt(s[2]);
				
				for(int i=1;i<=n;i++){
					for(int j=1;j<=m;j++){
					 mat[i][j]='A';
					}
				}
				if(k>=(3*n*m)/2){
					int min = Math.min(4,k/m*n);
					fillCorner('G',min,mat,m,n);
					k=k-min*m*n;
					if(k>0){
					
					
					}
					if(k>0){
					 if(k<5*Math.max(n*n*m,m*m*n)){
						fillMid('T',mat,m,n);
					 }if(k>=3*Math.max(n*n*m,m*m*n)){
						fillRand(mat,m,n);
					 }
					}
					
					
					
				}
				
				for(int i=1;i<=n;i++){
					for(int j=1;j<=m;j++){
					 out.write(""+mat[i][j]);out.flush();
					}
					out.write("\n");out.flush();
				}
				out.write("\n");out.flush();	
        }
    }//end of public static void main 
	public static void fillMid(char ch,char[][] mat,int m,int n)throws Exception{
	
	for(int i=n/2-n/8;i<=n/2+n/8;i++){
		for(int j=m/2-m/8;j<=m/2+m/8;j++){
		
		mat[i][j]=ch;
		}
	}
		
	}
	public static void fillRand(char[][] mat,int m,int n)throws Exception{
	char [] ch = new char[5];
	ch[1]='A';ch[2]='T';ch[3]='G';ch[4]='C';
	for(int i=1;i<=n;i++){
		for(int j=1;j<=m;j++){
		int x= (int)(1+3*Math.random());
		mat[i][j]=ch[x];
		}
	
	}
	
	}
	public static void fillCorner(char ch,int min,char[][] mat,int m,int n)throws Exception{
	if(min==1)mat[1][1]=ch;
	else if(min==2){mat[1][1]=ch;mat[1][n]=ch;}
	else if(min==3){mat[1][1]=ch;mat[1][n]=ch;mat[n][1]=ch;}
	else if(min==4){mat[1][1]=ch;mat[1][n]=ch;mat[n][1]=ch;mat[n][n]=ch;}
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
 } //end of class        
        