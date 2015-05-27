/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


 class spoj_CPCRC1C

 {

  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    
        const long num[]={0L,10L,90L,900L,9000L,90000L,900000L,9000000L,90000000L,900000000L,9000000000L,90000000000L};
        const long pow[]={0L,10L,100L,1000L,10000L,100000L,1000000L,10000000L,100000000L,1000000000L,10000000000L};
        
        for(int t=0;;t++){
		String[] s=br.readLine().split(" ");
		int a=Integer.parseInt(s[0]);int b=Integer.parseInt(s[1]);
		if(a==-1&&b==-1)break;
        
		int start=s[0].length();int end=s[1].length();
		long ans=0;
		if(start==end){
						ans=start*(b-a+1);
						out.write(""+ans+"\n");out.flush();continue;
		}
		ans=start*(num[start]-(a-pow[start-1]));
		
		for(int i=start+1;i<end;i++){
		ans+=i*(num[i]-(a-pow[i-1]));
		}
		ans+=end*(a-pow[start-1]+1);
		
        out.write(""+ans+"\n");out.flush();               
        	
        }
    }    	
 }        
        