import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;
class Main{

	public static long ans=0;
	public static void main(String[] arg)throws Exception{
	
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
//	int tests=Integer.parseInt(br.readLine());
//	for(int t=0;t<tests;t++){
			String[] s=br.readLine().split(" ");
		 int n=Integer.parseInt(s[0]);long k=Long.parseLong(s[1]);
		 long num[]=new long[n];
		 s=br.readLine().split(" ");
	     for(int i=0;i<n;i++){
			num[i]=Long.parseLong(s[i]);
		}
		long max=num[0];
		for(int i=0;i<n;i++){
		
			if(num[i]>max)max=num[i];	
			}
			
		out.write("\n");
		if(k==0){
			for(int i=0;i<n;i++){
		
			out.write(""+num[i]+" ");out.flush();	
			}
			
			}else if(k%2==1){
							for(int i=0;i<n;i++){
		    								num[i]=max-num[i];	
							}
							for(int i=0;i<n;i++){
		    								out.write(""+num[i]+" ");out.flush();
							}
			
			}else{
					
					for(int i=0;i<n;i++){
		    								num[i]=max-num[i];	
							}
					max=num[0];
					for(int i=0;i<n;i++){
							if(num[i]>max)max=num[i];	
					}
					for(int i=0;i<n;i++){
		    								num[i]=max-num[i];	
					}		
					for(int i=0;i<n;i++){
		    								out.write(""+num[i]+" ");out.flush();
							}
				}
		 
	 }
//	}
}