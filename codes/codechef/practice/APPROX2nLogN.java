/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Pair implements Comparable<Pair>{
		
		int i,j;
		public Pair(int i , int j){this.i=i;this.j=j;}
		public int compareTo(Pair p){
		return this.j-p.j;}
}
class APPROX2nLogN  

 {
		public static long ans=0;
		static long min=0;static int min1=0,min2=0;
  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
     
        ans=0;     
        int tests=Integer.parseInt(br.readLine());
     
    	for(int t=0;t<tests;t++){
					String[] s=br.readLine().split(" ");  			
					int n=Integer.parseInt(s[0]);int k=Integer.parseInt(s[1]);	
					Pair pair[]=new Pair[n];					
					s=br.readLine().split(" ");    
					
  					for(int i=0;i<n;i++){
        			    pair[i]=new Pair(i+1,Integer.parseInt(s[i]));
					}
					
					Arrays.sort(pair);
					
					min=100000000001L;min1=min2=0;
					for(int i=0;i<n-1;i++){
					
						int j=binSearch(pair,i+1,n-1,k-pair[i].j);	
						
						if(Math.abs(pair[i].j+pair[j].j-k)<min){min=Math.abs(pair[i].j+pair[j].j-k);min1=i;min2=j;}
					}
					
        			out.write(""+pair[min1].i+" "+pair[min2].i+"\n");out.flush();
  		}	      
  }
  public static int binSearch(Pair[] p,int si,int ei,int key)throws Exception{
  
  		if(ei==si)return si;
  		if(ei-si==1){
  					if(Math.abs(p[si].j-key)>Math.abs(p[ei].j-key)){return ei;}
  						else return si;
  		}
 		int mid=(si+ei)/2;
 		if(p[mid].j==key)return mid;
 		else if(p[mid].j>key){
 					return binSearch(p,si,mid,key);
 					}else{ 
 							return binSearch(p,mid,ei,key);
 					} 
 	//return -1;						
  	}
}
