/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


 class E

 {

  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		int mod=1000000007;
		long pc[]=new long[100];long nc[]=new long[100];
		int pdp[][]=new int[200001][100];
		int ndp[][]=new int[200001][100];
		int count[]=new int[101];		
		int pindex[][]=new int[101][100];
		int nindex[][]=new int[101][100];
        int tests=Integer.parseInt(br.readLine());
        int num[]=new int[200001];
		for(int t=0;t<tests;t++){
			for(int i=0;i<100;i++){pc[i]=0;nc[i]=0;count[i]=0;}
			count[100]=0;
			
			int n=Integer.parseInt(br.readLine());
			String[] s=br.readLine().split(" ");
			for(int i=0;i<n;i++){
				num[i]=Integer.parseInt(s[i]);
			}
		for(int i=0;i<101;i++){for(int j=0;j<100;j++){pindex[i][j]=0;nindex[i][j]=0;}}	
	    for(int i=0;i<n;i++){for(int j=0;j<100;j++){pdp[i][j]=0;ndp[i][j]=0;}}
			
        count[num[0]]=1;int temp=0;
		for(int i=1;i<n;i++){
			for(int j=-99;j<=99;j++){
				temp=num[i]-j;
				if(temp>=0&&temp<=100 &&count[temp]!=0){
					
					if(j<0){
						ndp[i][-j]=(count[temp]+nindex[temp][-j])%mod;
						nc[-j]+=ndp[i][-j];nc[-j]%=mod;nindex[num[i]][-j]+=ndp[i][-j];nindex[num[i]][-j]%=mod;
					}else{
						pdp[i][j]=(count[temp]+pindex[temp][j])%mod;
						pc[j]+=pdp[i][j];pc[j]%=mod;pinsdex[num[i]][j]+=pdp[i][j];pindex[num[i]][j]%=mod;
					}
					
				}
			
			}
			
			count[num[i]]++;
		}
		long ans=n+1;
		for(int i=0;i<=99;i++){ans+=pc[i];ans+=nc[i];ans%=mod;}
		long total=pow(2,n,mod);out.write("pow="+total+"ans="+ans+"\n");
		long tans = total-ans%mod;
		if(tans<0)ans=(total+mod)-ans%mod;
		else ans=tans;
        out.write(""+ans+"\n");out.flush();               
        }
    }    	
	public static long pow(long a,long b,long mod)throws Exception{
	if(b==0)return 1;
	long ans = pow(a,b>>1,mod);
	ans=((ans%mod)*(ans%mod))%mod;
	if(b%2!=0){
	  ans = (a*ans)%mod;
	}
	return ans;
	}
 }        
        //////////////////////////////////////////
#include <iostream>
using namespace std;
unsigned int pc[100];unsigned int nc[100];
unsigned int pdp[200001][100];
unsigned int ndp[200001][100];
unsigned int count[101];		
unsigned int pindex[101][100];
unsigned int nindex[101][100];
unsigned long long pow(unsigned long long  a,unsigned long long  b,unsigned long long mod);
unsigned int num[200001];
unsigned long long mod=1000000007;
int main() {
	int tests;
	cin>>tests;
	
		for(int t=0;t<tests;t++){
			for(int i=0;i<100;i++){pc[i]=0;nc[i]=0;count[i]=0;}
			count[100]=0;
			
			int n;
			cin>>n;
			//String[] s=br.readLine().split(" ");
			for(int i=0;i<n;i++){
				cin>>num[i];
			}
		for(int i=0;i<101;i++){for(int j=0;j<100;j++){pindex[i][j]=0;nindex[i][j]=0;}}	
	    //for(int i=0;i<n;i++){for(int j=0;j<100;j++){pdp[i][j]=0;ndp[i][j]=0;}}
			
        count[num[0]]=1;int temp=0;
		for(int i=1;i<n;i++){
			for(int j=-99;j<=99;j++){
				temp=num[i]-j;
				if(temp>=100)continue;
				if(temp<0)break;
				if(temp<0)break;
				if(count[temp]!=0){
					
					if(j<0){
						ndp[i][-j]=(count[temp]+nindex[temp][-j]);
						if(ndp[i][-j]>=mod)ndp[i][-j]=ndp[i][-j]-mod;
						nc[-j]+=ndp[i][-j];
						if(nc[-j]>=mod)nc[-j]=nc[-j]-mod;
						nindex[num[i]][-j]+=ndp[i][-j];
						if(nindex[num[i]][-j]>=mod)nindex[num[i]][-j]=nindex[num[i]][-j]-mod;
						
					}else{
						pdp[i][j]=(count[temp]+pindex[temp][j]);
						if(pdp[i][j]>=mod)pdp[i][j]=pdp[i][j]-mod;
						pc[j]+=pdp[i][j];
						if(pc[j]>=mod)pc[j]=pc[j]-mod;
						pindex[num[i]][j]+=pdp[i][j];
						if(pindex[num[i]][j]>=mod)pindex[num[i]][j]=pindex[num[i]][j]-mod;
						
					}
					
				}
			
			}
			
			count[num[i]]++;
		}
		unsigned long long ans=n+1;
		for(int i=0;i<=99;i++){ans+=pc[i];ans%=mod;ans+=nc[i];ans%=mod;}
		unsigned long long two=2;
		unsigned long long total=pow(two,n,mod);//out.write("pow="+total+"ans="+ans+"\n");
		long long tans = total-ans;
		if(tans<0)ans=(total+mod)-ans;
		else ans=tans;
        //out.write(""+ans+"\n");out.flush();        
        ans%=mod;
        cout<<ans<<endl;
        }
	return 0;
}
	unsigned long long pow(unsigned long long  a,unsigned long long  b,unsigned long long mod){
	if(b==1)return a;
	if(b==0)return 1;
	unsigned long long int ans = pow(a,b/2,mod);
	ans=(ans*ans)%mod;
	if(b%2!=0){
	  ans = (a*ans)%mod;
	}
	return ans;
	}