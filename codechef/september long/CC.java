//pakage joney_000

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


class CC
{	
    public static void main (String[] args) throws java.lang.Exception
	{
		
 	     int mod = 1000000009;
		 
		 
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		 int tests = Integer.parseInt(br.readLine());
		 
		 short arr[] = new short[100005];
		 
		 for(int t = 1 ; t<=tests ;t++){
		   String s[] = br.readLine().split(" ");
		   int n = Integer.parseInt(s[0]);
		   int m = Integer.parseInt(s[1]);
		   
		   for(int i=0;i<=n;i++){arr[i]=-1;}
		   
		   for(int i=1;i<= m;i++){
		     s = br.readLine().split(" ");
			 char ch= s[0].charAt(0);			  
			 int idx = Integer.parseInt(s[1]);
			 arr[idx]= (short)(ch-'A');
		     //out.write(""+arr[idx]+" fdsf "+idx+"\n");out.flush();
		   }
		   
		   short pre=-2; int id=1;
		   long ans=1L;
		   
		   for(int i=1;i<=n;i++){
		    if(arr[i]==-1)continue;
		    if(pre==-2){
			  pre = arr[i];
			  id=i;
			  continue;
			}
			if(arr[i]==pre){
			  id=i;
			  continue;
			}
		
			ans = ans * (i-id);
			if(ans>=mod)ans = ans%mod;
			id= i;
			pre = arr[i];
		   }
		   //   long ans=0;
	     out.write(""+ans+"\n");
		//out.flush();
		} 
		out.flush();
    
   }
		
}