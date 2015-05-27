/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
// BFS
class D

 {

  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		String s=br.readLine();
        int n=s.length();
        int num[]=new int[n];
		Queue dpos[]=new LinkedList[101];
		for(int i=0;i<101;i++){
			dpos[i]=new LinkedList();
		}
		for(int i=0;i<n;i++){
			num[i]=Integer.parseInt(""+s.charAt(i));
			dpos[num[i]].add(i);
		}
		int []path=new int[n];
		boolean []visited=new boolean[n];	
		for(int i=0;i<n;i++){path[i]=-1;visited[i]=false;}
		
		Queue q=new LinkedList();
		q.add(0);visited[0]=true;
		while(!q.isEmpty()){
		
		int index=(int)q.remove();
		
		if(index==n-1)break;
		while(!dpos[num[index]].isEmpty()){
			int j=(int)dpos[num[index]].remove();
			if(!visited[j]){
				visited[j]=true;
				q.add(j);path[j]=index;
			}
		}
		if(!visited[index+1]){q.add(index+1);path[index+1]=index;visited[index+1]=true;}
		if((index-1)>=0&&!visited[index-1]){q.add(index-1);path[index-1]=index;visited[index-1]=true;}
		
		
		}
		//for(int i=0;i<n;i++)out.write(" "+path[i]);
		int cost=0;
		int next=n-1;
		while(next!=0&&visited[next]){
		cost++;
		next=path[next];
		}
		out.write("\n"+cost);out.flush();               
        	
        }
     	
 }

 /* //wrong soln
 class D

 {

  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    
        //int tests=Integer.parseInt(br.readLine());
        //for(int t=0;t<tests;t++){
        String s=br.readLine();
        int n=s.length();
        int num[]=new int[n];
		int dp[]=new int[n];
        for(int i=0;i<n;i++){
			num[i]=Integer.parseInt(""+s.charAt(i));
		}
		
		int [][]next=new int[n][10];
		int []optdig=new int[10];
		
		for(int i=0;i<10;i++)optdig[i]=10000000;
		optdig[num[0]]=0;
		
		for(int j=0;j<10;j++)next[n-1][j]=-1;
		next[n-1][num[n-1]]=n-1;
		for(int i=n-2;i>=0;i--){
			for(int j=0;j<10;j++)next[i][j]=next[i+1][j];
		    next[i][num[i]]=i;
		}
		for(int i=1;i<n;i++)dp[i]=10000000;
		dp[0]=0;
		if(1<n && next[1][num[0]]!=-1)dp[next[1][num[0]]]=Math.min(dp[next[1][num[0]]],optdig[num[0]]+1);
		
		for(int i=1;i<n;i++){
					//current dp element;
		 if(i+1<n)dp[i]=Math.min(dp[i],1+dp[i+1]);
				  dp[i]=Math.min(dp[i],1+dp[i-1]);
				  dp[i]=Math.min(dp[i],1+optdig[num[i]]);
				  //update optimal digit
				  optdig[num[i]]=Math.min(optdig[num[i]],dp[i]);
				  //updates forward / upcoming elements
		 if(i+1<n)dp[i+1]=Math.min(dp[i+1],dp[i]+1);
		 if((i+1<n) && next[i+1][num[i]]!=-1)dp[next[i+1][num[i]]]=Math.min(dp[next[i+1][num[i]]],optdig[num[i]]+1);
				
		}
		out.write(""+dp[n-1]);out.flush();               
        	
        }
 //}    	
 }*/        
        