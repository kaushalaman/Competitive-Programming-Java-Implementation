import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


   class Asd

 {

  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    
  
     //byte digit[]=new byte[101];
	 //boolean[] check=new boolean[101];
     //int num[]=new int[99999]; 
     
        int fact[]=new int[1050000];
        fact[0]=1;fact[1]=1;
        for(int i=2;i<1050000;i++){
        	fact[i]=(i*fact[i-1])%1000000009;
        }
        int k=Integer.parseInt(br.readLine());
        long one=1;
        long n=1<<k;
        for(int i=1;i<=n;i++){
        	long ans=0;
        	if(i<n/2){out.write("\n0");out.flush();
        	}else{
        		ans=(fact[i-1]*fact[(int)n])/fact[(int)n-1];
        		out.write("\n"+ans);out.flush();
        	}
								
  	}				      
  }
}
