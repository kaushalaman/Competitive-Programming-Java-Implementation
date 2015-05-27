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

typedef long long ll ;
#define  pb push_back
#define mp make_pair
using namespace std;
vector<pair<ll,ll> >adj[500];
int visited[500]={0};
vector<ll>father[500];
typedef struct {
	int w;
	int i;
	int fath;
} node;

int wt[500];
struct new_comparator{
bool operator()(node x,node y){
	
	return x.w>y.w;
}

};
void dijkastra(int s,int t){
	for(int i=0;i<500;i++){
		wt[i]=9000000;
	}
	priority_queue<node,vector<node>,new_comparator>pq;
	node i1;
	i1.i=s;
	i1.fath=-1;
	i1.w=0;
	pq.push(i1);
	wt[s]=0;
	while(!pq.empty()){
		i1=pq.top();
		pq.pop();
		if(visited[i1.i]){
			continue;
		}
		visited[i1.i]=1;
		
		for(int i=0;i<adj[i1.i].size();i++){
			int temp=wt[i1.i]+adj[i1.i][i].first;
			if(wt[adj[i1.i][i].second]==temp){
				wt[adj[i1.i][i].second]=temp;
				father[adj[i1.i][i].second].pb(i1.i);
			}
			if(wt[adj[i1.i][i].second]>temp){
				wt[adj[i1.i][i].second]=temp;
				if(father[adj[i1.i][i].second].size()){
					father[adj[i1.i][i].second].clear();
				}
		//		cout<<adj[i1.i][i].second<<"    "<<i1.i<<"    ds"<<endl;
				father[adj[i1.i][i].second].pb(i1.i);
			}
			
			node t2;
			t2.i=adj[i1.i][i].second;
			t2.w=adj[i1.i][i].first;
			pq.push(t2);
		}
	}
}


main(){
	ll n;
	cin>>n;
	for(int i=0;i<n;i++){
		ll x,y,w;
		cin>>x>>y>>w;
		adj[x].pb(mp(w,y));
		adj[y].pb(mp(w,x));
		
	}
	int s,t;
	cin>>s>>t;
	dijkastra(s,t);
	cout<<"min distaance "<<wt[t]<<endl;
	queue<int>q[2];
//	cout<<father[t].size()<<"sss"<<endl;
	for(int i=0;i<500;i++){
		unique(father[i].begin(),father[i].end());
	}
	cout<<"printing the edges[PATH]."<<endl;
	for(int i=0;i<father[t].size();i++){
		q[0].push(father[t][i]);
		cout<<t<<" "<<father[t][i]<<endl;
	}
	bool f=0;
//	cout<<endl;
	while(!(q[0].empty()&&q[1].empty()))
	{
		while(!q[f].empty()){
		int b=q[f].front();
		q[f].pop();
		for(int i=0;i<father[b].size();i++){
			cout<<b<<" "<<father[b][i]<<endl;
			q[1-f].push(father[b][i]);
		}
		}
		f=1-f;
	}
}
