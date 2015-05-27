/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


 class E {
	
	
  public static void main(String[] args)throws Exception

    {  
	
	/*  BufferedReader br=new BufferedReader(new FileReader("input.txt"));
        BufferedWriter out=new BufferedWriter(new FileWriter("output.txt"));
    */               

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    		
    		int tests=Integer.parseInt(br.readLine());
			int val[]=new int[100001];
			int papa[] = new int[100001]; 
			LinkedList<Integer> ll = new LinkedList<Integer>();
        for(int t=0;t<tests;t++){
				int n=Integer.parseInt(br.readLine());
				String[] s= br.readLine().split(" ");	
				for(int i=1;i<=n;i++){
					val[i]=Integer.parseInt(s[i-1]);
					papa[i]=i;
				}
				
				int q=Integer.parseInt(br.readLine());
				int a=0,b=0;
				for(int i=1;i<=q;i++){
					
				s= br.readLine().split(" ");
				if(s[0].charAt(0)=='0'){
				
					a= Integer.parseInt(s[1]);
					b= Integer.parseInt(s[2]);
					
					while(papa[a]!=a){
						
						a=papa[a];
						ll.add(a);
					}
					while(!ll.isEmpty()){
					
					papa[ll.poll()]=a;
					}
					while(papa[b]!=b){
						
						b=papa[b];
						ll.add(b);
					}
					while(!ll.isEmpty()){
					
					papa[ll.poll()]=b;
					}
					if(a==b){
						out.write("Invalid query!\n");out.flush();continue;
					}				
					if(val[a]==val[b])continue;
					if(val[a]>val[b])papa[b]=a;
					else papa[a]=b;
				}else{
				
				a=Integer.parseInt(s[1]);
				
					while(papa[a]!=a){
						
						a=papa[a];
						ll.add(a);
					}
					while(!ll.isEmpty()){
					
					papa[ll.poll()]=a;
					}
					out.write(""+a+"\n");out.flush();
				}
					
				}
				
        	
        }
    }//end of public static void main 
	public static boolean isPrime(long n)throws Exception{
		if(n==2||n==3)return true;
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0)return false;
		}
	return true;
	}
	public static long gcd(long a, long b)throws Exception{
		if(b==0)return a;
		return gcd(b,a%b);
	}
 } //end of class        
        