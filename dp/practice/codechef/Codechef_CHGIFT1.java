    /* package joney_000 */
     
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    import java.math.*;
     
     
    class Codechef_CHGIFT1
     
    {
    public static long ans=0;
     
    public static void main(String[] args)throws Exception
     
    {
     
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    ans=0;
    int tests=Integer.parseInt(br.readLine());
    for(int t=0;t<tests;t++){
    int n=Integer.parseInt(br.readLine());
    int num[]=new int[n];
    String[] s=br.readLine().split(" ");
    for(int i=0;i<n;i++){
    num[i]=Integer.parseInt(s[i]);
    }
    if(n==1){out.write(""+num[0]+"\n");out.flush();continue;}
    long preMax=num[0],max=num[0],preMin=num[0],min=num[0];
    
    for(int i=1;i<n;i++){
  		if(num[i]>=0){
  			max=Math.max(preMax*num[i],preMax+num[i]);
  			min=Math.min(preMin-num[i],preMin*num[i]);
  		}else{
  			max=Math.max(preMax*num[i],Math.max(preMin*num[i],preMax-num[i]));
  			min=Math.min(preMax*num[i],Math.min(preMin*num[i],preMin+num[i]));
  		}
  		preMax=max;
  		preMin=min;
    	
    }
    
    ans=Math.min(max,min);
    out.write(""+ans+"\n");out.flush();
    }	
    }
    }

