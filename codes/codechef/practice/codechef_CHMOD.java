/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


class codechef_CHMOD  

 {
		public static long ans;

  public static void main(String[] args)throws Exception

    {                 

       //InputStream inputStream = System.in;
// OutputStream outputStream = System.out;
 //FastReader in = new FastReader(inputStream);
 //PrintWriter out = new PrintWriter(outputStream);
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
     
// byte digit[]=new byte[101];
	 //boolean[] check=new boolean[101];
     //int num[]=new int[99999]; 
      //  ans=0;     
   //     int tests=Integer.parseInt(br.readLine());
     
    	//for(int t=0;t<tests;t++){   
				        int prime[]=new int[30];
					int primes=0;
					for(int i=2;i<=100;i++){

						if(isPrime(i)){
						
						prime[primes]=i;
						primes++;	
						}

						
					}
					
					int n=Integer.parseInt(br.readLine());	
					//int n=in.nextInt();
					int num[]=new int[n+1];					
					String[] ss=br.readLine().split(" ");    
					int [][] p = new int [primes][n+1];
                    for(int i=0;i<primes;i++)p[i][0]=0;
					
					for(int i=1;i<=n;i++){
						num[i]=Integer.parseInt(ss[i-1]);//in.nextInt();
					}
					
					
					//int [][] p = new int [primes][n+1];
					//for(int i=0;i<primes;i++)p[i][0]=0;
					for(int i=1;i<=n;i++){
						for(int j=0;j<primes;j++){
						p[j][i]=p[j][i-1];
						
						}
						for(int j=0;j<primes;j++){
						
							if(num[i]%prime[j]==0){
								
								p[j][i]+=1;
								num[i]/=prime[j];
								j--;
							}
						}

					} 
					
					int q=Integer.parseInt(br.readLine());//in.nextInt();
					 for(int i=1;i<=q;i++){
                                                
						ss=br.readLine().split(" ");
						 int a=Integer.parseInt(ss[0]);//in.nextInt();
						 int b=Integer.parseInt(ss[1]);//in.nextInt();
						 int m=Integer.parseInt(ss[2]);//in.nextInt();
						 long an=cal(p,a,b,m,primes,prime);
						  out.write(""+an+"\n");out.flush(); 

                                        }
	

        			//out.write("\n"+ans);out.flush();
  	//}	      
  }
public static boolean isPrime(int n)throws Exception{
		
		if(n<=3)return true;
		boolean ch=true;
		for(int i=2;i<=Math.sqrt(n);i++){
		if(n%i==0)return false;
		
		}
		return true;
}
public static long cal(int[][] p, int a,int b,int m,int primes,int[] prime)throws Exception{

	long ans=1;
	for(int i=0;i<primes;i++){
	
	ans=(ans*pow(prime[i],p[i][b]-p[i][a-1],m))%m;
		
	}
	return ans;

}
public static long pow(int i,int j,int m)throws Exception{

	if(j==1)return i;
	if(j==0)return 1;
	long ans=1;
	if(j%2==0){
	    
		ans=pow(i,j/2,m);
		ans=(ans*ans)%m;
		}else{

		 ans=pow(i,j/2,m);
                ans=(((ans*ans)%m)*i)%m;

		}
		return ans;
	}
}
