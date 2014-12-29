/* package joney_000 
   codechef/april/digits	
	*/

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


class Main  

 {
		public static int ans;

  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    
        ans=0;     
        
		
    
					int digit[]=new int[10];
					String[] s=br.readLine().split(" ");
					int n=Integer.parseInt(s[0]);int m=Integer.parseInt(s[1]);	
					//int num[]=new int[n];					
					String ss=br.readLine().trim();    
					int num[]=new int[n];
  					int sum[]=new int[n];
					for(int i=0;i<n;i++){
					 num[i]=Integer.parseInt(""+ss.charAt(i));
        			}		
					digit[num[0]]++;sum[0]=0;
					for(int i=1;i<n;i++){
					  for(int j=0;j<10;j++){
						if((j-num[i])>=0)sum[i]+=digit[j]*(j-num[i]);
							else sum[i]+=digit[j]*(num[i]-j);
						}
						digit[num[i]]++;
        			}		
				for(int i=0;i<m;i++){
				out.write("\n"+sum[Integer.parseInt(br.readLine())-1]);out.flush();
				}	
        		//out.write("\n"+count);out.flush();
  					      
  }
}
