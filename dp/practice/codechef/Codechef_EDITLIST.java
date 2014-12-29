//user joney_000/kg/let_me_start
    /* package joney_000 
    
    wrong sub
    */
     
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    import java.math.*;
     
    class Codechef_EDITLIST{
    
    
     
	    public static void main(String[] args)throws Exception{
     
     
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int tests=Integer.parseInt(br.readLine());
	    for(int t=0;t<tests;t++){
		    int n=Integer.parseInt(br.readLine());
		    int a[]=new int[n];
		    String[] s=br.readLine().split(" ");
		    for(int i=0;i<n;i++){
			    a[i]=Integer.parseInt(s[i]);
		    }
		    int m=Integer.parseInt(br.readLine());
		    int b[]=new int[m];
		    String[] s=br.readLine().split(" ");
		    for(int i=0;i<m;i++){
			    b[i]=Integer.parseInt(s[i]);
		    }
		    int[] min,[] max;in count=0;
		    if(a.length()<=b.length()){min=a;max=b}else{min=b;max=a;}
    		for(int i=0;i<min.length();i++){
    			for(int j=0;j<max.length();j++){
    			  if(min[i]==max[j] && min[i]!=-1 && max[j]!=-1){min[i]=-1;max[j]=-1;count++;break;}
    			}
    		
    		}
    		long ans=max.length()-min.length()+min.length()-count;
    		out.write(""+ans+"\n");out.flush();
    	}	
    	}
    }

