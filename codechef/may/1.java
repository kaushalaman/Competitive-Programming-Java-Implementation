import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;
class Main{

	public static long ans=0;
	public static void main(String[] arg)throws Exception{
	
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
	long tests=Long.parseLong(br.readLine());
	//for(int t=0;t<tests;t++){
	
		//int n=Integer.parseInt(br.readline());
		//int num[]=new int[n];
		//String[] s=br.readline().split(" ");
		/*for(int i=0;i<n;i++){
			num[i]=Integer.parseInt(s[i]));
		}*/
		if((tests+5)%6==0||(tests+3)%6==0||(tests)%6==0){out.write("yes\n");out.flush();
		 }else out.write("no\n");out.flush();
	 //}
	}
}