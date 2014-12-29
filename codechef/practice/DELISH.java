/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


class MaxSubArraySum

 {
		public static long ans=0;

  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
     
            
        int tests=Integer.parseInt(br.readLine());
     
    	for(int t=0;t<tests;t++){
								
					int n=Integer.parseInt(br.readLine());	
					int num[]=new int[n];					
					String[] s=br.readLine().split(" ");    
					long []lmax=new long[n],[]lmin=new long[n],[]rmax=new long[n],rmin[]=new long[n];
  					for(int i=0;i<n;i++){
        			    num[i]=Integer.parseInt(s[i]);
					}
					long temp1=0,temp2=100000000000L;
					/*  //does not handle the case all array element are negative.
					for(int i=0;i<n;i++){
						tempSum=+num[i];
						if(tempSum<0){
							tempSum=0;
						}
						ans=Math.max(ans,temp);
					}
					 */
					 //handle the all negative case
					long ans1=-100000000000L;long ans2=10000000000000L;
					
					for(int i=0;i<n;i++){
						temp1=Math.max(num[i],temp1+num[i]);
						lmax[i]=Math.max(ans1,temp1);
						temp2=Math.min(num[i],temp2+num[i]);
						lmin[i]=Math.min(ans2,temp2);
					} 
					temp1=0;temp2=100000000000L;
					ans1=-100000000000L;ans2=10000000000000L;
					
					for(int i=n-1;i>=0;i--){
						temp1=Math.max(num[i],temp1+num[i]);
						rmax[i]=Math.max(ans1,temp1);
						temp2=Math.min(num[i],temp2+num[i]);
						rmin[i]=Math.min(ans2,temp2);
					}
					ans=0;
					for(int i=0;i<n-1;i++){
					ans=Math.max(ans,Math.abs(lmax[i]-rmin[i+1]);
					ans=Math.max(ans,Math.abs(lmin[i]-rmax[i+1]);
					
					}
        			out.write(""+ans+"\n");out.flush();
  		}	      
  }
}
