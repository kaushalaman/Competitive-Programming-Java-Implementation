//let_me_start[joney_000]
#include<string>
#include<cstdio>
#include<iostream>
#include<cstring>
#include<sstream>
#include<stdlib.h>
#include<algorithm>
#include<cmath>
#include<vector>
#include<map>
#include<set>
#include<list>
#include<stack>
#include<queue>

#define  pb push_back
using namespace std;
vector<ll>adj[500];
int vis[500]={0};
void dfs(int v,int c){
	vis[v]=c;
	for(ll i=0;i<adj[v].size();i++){
		if(!vis[adj[v][i]]){
		dfs(adj[v][i],c);
		}	
	}
	return ;
}
main(){
	ll T;
	cin>>T;//number of test cases you want to check
	while(T--){
		string str;
		ll n;
		cin>>str>>n;
		for(ll i=0;i<n;i++){
			ll x,y;
			cin>>x>>y;
			adj[x].pb(y);
			adj[y].pb(x);
		}
		ll c=0;
		for(int i=0;i<str.length();i++){
			vis[i]=0;
		}
		for(ll i=0;i<str.length();i++){
			if(!vis[i]){
				c++;
			dfs(i,c);}
			
		}
		vector<char>v[c+1];
		vector<ll>v1[c+1];
		for(int i=0;i<str.length();i++){
			v[vis[i]-1].pb(str[i]);
			v1[vis[i]-1].pb(i);
			adj[i].clear();
		}
		for(int i=0;i<c;i++){
			sort(v[i].begin(),v[i].end());
			sort(v1[i].begin(),v1[i].end());
		}
		//for(int i=0;i<c;i++){
		//	for(int j=0;j<v1[i].size();j++){
		//		cout<<i<<"   vij  "<<v1[i][j]<<" char "<<v[i][j]<<endl;
		//	}
		//}
		for(int i=0;i<c;i++){
			for(int j=0;j<v1[i].size();j++){
				str[v1[i][j]]=v[i][j];
			}
		}
		cout<<str<<endl;
	}
	
}
