#include <iostream>
#include <math.h>
#include <stdio.h>
using namespace std;
long long po[1000001][60];
long long constant[10001];
long long two=2L,large=1000000000000000000L;
long long mod=1000000007L;
long long num[10001];
long long query[15001];
long long st=1L,start=1L,end=1000000L,mid=0L;
long long steps=0,maxsteps=0;
inline long long root(long long x,int j){
	//steps++;if(steps>maxsteps)maxsteps=steps;
	if(end==st)return 1L;
	if(po[(int)start][j]==x){return start;}
	if(po[(int)end][j]==x){return end;}
	//if(end==start){return end;}
	mid=(start+end);
	mid=mid/2;
	if(po[(int)mid][j]==x){return mid;}
	if(po[(int)mid][j]<x){
		if(po[(int)(mid+1)][j]>x){return mid;}
		start=mid+1;
	    return root(x,j);
	}else if(po[(int)mid][j]>x){
		end=mid-1;
	    return root(x,j);
	}
	
} 
int main() {
	//precomputation of power(i^j)
	for(int i=1;i<=1000000;i++){
		for(int j=0;j<60;j++){
					po[i][j]=1000000000000000016L;
					}
	}
	
	for(int i=1;i<=1000000;i++){
		for(int j=0;j<60;j++){
					if(i==1){po[1][j]=1L;continue;}
					if(j==0){po[i][0]=1L;continue;}
					po[i][j]=po[i][j-1]*i;
					if(po[i][j]>(large/i))break;
		}
	}
	long long x=po[2][59];cout<<x<<endl;
	int tests;int n=0,q=0;
	cin>>tests;
	for(int t=0;t<tests;t++){
		
		cin>>n>>q;
		for(int i=0;i<n;i++)cin>>num[i+1];
		for(int i=0;i<q;i++)cin>>query[i+1];
		long long ans=0L;
			constant[n]=num[n];
			for(int i=n-1;i>=1;i--){
			constant[i]=(constant[i+1]+num[i])%mod;	 
			}
			
		long long x=0L,temp=0L;
		for(int i=1;i<=q;i++){
			ans=0;
			x=query[i];
			ans+=(num[1]*(x%mod))%mod;
			if(n>=2){
				temp=(long long)sqrt(x);
				if(temp*temp<x){
					if(((temp+1)*(temp+1))<=x){
						temp=temp+1;
					}
				}else if(temp*temp>x){
					temp--;
					
				}
				ans+=(num[2]*temp)%mod;
				ans%=mod;
				if(ans<mod)ans+=mod;
				
				if(temp==1 && n>2){
					ans+=constant[3];
					ans%=mod;
					if(ans<0)ans+=mod;
					cout<<ans<<" ";
					continue;
				}
			}
			//steps=0;
			bool ch=false;
			for(int j=3;j<=min(n,59);j++){
				start=st;long long t=root(x,j);cout<<"root("<<x<<","<<j<<")=="<<t<<endl;
				//cout<<"steps=="<<steps<<endl;
				if(t==1){
					ch=true;
					ans+=(num[j]*t)%mod;
					if(n>j)ans+=constant[j+1];
					break;
				}
				//ans+=constant[j+1];
				
				end=t-1;
				ans+=(num[j]*t)%mod;
			}
			if(!ch && n>=60){ans+=constant[60];}
			ans%=mod;
			
			if(ans<0)ans+=mod;
			//cout<<"maxsteps=="<<maxsteps<<endl;
			cout<<ans<<" ";
			end=1000000;
		}
			cout<<endl;
	}
		
	

return 0;
}
