// package [let_me_start]joney_000 

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
/*
 * Author       : joney_000[let_me_start]
 * Algorithm    : zee algorithm to find pattern P in the larger text T in O(|S|+|T|)
 * 
 */
 class ZeeStringMatching{
	
	
  public static void main(String[] args)throws Exception

    {  

	BufferedReader br=new BufferedReader(new InputStreamReader(System.in),2000);
    BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out),2000);
	String T = br.readLine();
	String P = br.readLine();
	String S = P+"$"+T;
	char []s = S.toCharArray();
	int z[] = new int[1+S.length()];
	//computation of Zi(S) function
	int len=S.length(),l=0,r=0;
	z[0]=len;
		for(int i=1;i<len;i++){
			if(i>r){
				l=i;r=i;
				while(r<len&&s[r]==s[r-l])r++;
				z[i]=r-l;r--;
			}else{
				int k=r-i; //k represents k'
				
				if(z[k]<r-i+1){z[i]=z[k];r=i+z[k];}
				
				else if(z[k]>=r-i+1){
					l=i;
					while(r<len&&s[r]==s[r-l])r++;
					z[i]=r-l;r--;
				}
				l=i;
			}
		
		}
	 for(int i=0;i<len;i++){
		out.write(""+z[i]+" ");out.flush();
	 
	 }	
    }   
	
 } //end of class        
        
