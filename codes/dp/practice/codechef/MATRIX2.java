//user joney_000/kg/let_me_start
 // package joney_000 
 
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    import java.math.*;
     
    class Codechef_MATRIX2{
    
    
     
	    public static void main(String[] args)throws Exception{
     
		
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
	    int mat[][] = new int[2001][2001];
	    int dp[][] = new int[2001][2001];
	    
		//int tests=Integer.parseInt(br.readLine());
	    //for(int t=0;t<tests;t++){
		
		    String[] s=br.readLine().split(" ");
		    int n=Integer.parseInt(s[0]);
			int m=Integer.parseInt(s[1]);
		    for(int i=1;i<=n;i++){
				s=br.readLine().split(" ");
				for(int j=1;j<=n;j++){
					mat[i][j]=Integer.parseInt(s[j-1]);
				}
			}
			
			for(int i=1;i<=n;i++){
				
				for(int j=1;j<=n;j++){
					if(mat[i][j]==1)dp[i][j]+=1;
					dp[i][j]=dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1];
					if(dp[i-1][j]-dp[i-1][j-1]==j-1)dp[i][j]+=dp[i-1][j-1];
				}
			}
			ans=dp[n][m];
    		out.write(""+ans+"\n");out.flush();
    	}	
    	
    }

