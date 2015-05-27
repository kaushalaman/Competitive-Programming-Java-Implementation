/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


class Codechef_CNTSOLS 

 {
		//public static long ans;

  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    
      // byte digit[]=new byte[101];
	 //boolean[] check=new boolean[101];
     //int num[]=new int[99999]; 
       // ans=0;     
        int tests=Integer.parseInt(br.readLine());
     
   	 for(int t=0;t<tests;t++){
								
					//int n=Integer.parseInt(br.readLine());	
					//int num[]=new int[n];					
					String[] ss=br.readLine().split(" ");    
					
  					long upper=Long.parseLong(ss[0]);long d=Long.parseLong(ss[1]);
					int m=Integer.parseInt(ss[2]);int n=Integer.parseInt(ss[3]);
					
					int []pow=new int[n];
					for(int i=0;i<n;i++){
							pow[i]=pow(i,d,n);
					}					
					long ans=0;long mod=1000000007;
					long p=upper/n;long q=upper%n;
					long x=0,y=0,z=0;
					for(int i=0;i<n;i++){
						if(i<=q)x=p+1;
						else x=p;
						for(int j=0;j<n;j++){
							 if(j<=q)y=p+1;
		                     else y=p;

							for(int k=0;k<n;k++){
								if(k<=q)z=p+1;
								else z=p;	
								if((pow[i]+pow[j]+pow[k])%n==m){
								
								ans=((ans+((x%mod)*(y%mod)%mod)*(z%mod))%mod)%mod;
											
								}

							}
						}
					}
							
        		out.write("\n"+ans);out.flush();
  	}	      
  }
public static int pow(int i,long d ,int n)throws Exception{

if(d==0)return 1;
 int ans=1;
 ans=pow(i,d>>1,n);
ans=(ans*ans)%n;
if(d%2!=0)ans=(i*ans)%n;
return ans;
}
}
