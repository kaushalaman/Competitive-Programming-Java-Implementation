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

using namespace std;
void solve(string str)
 {
	
    int len=str.length();
    int i, j ;
	i=0;j=0;
    while (i < len)
	{
        if (str[i] == 'b') break;
        i += 1;
     }
     if (i == len)
	 {
	   cout<<"0,0\n";
        return;
	  }
      int temp= -(len - i - 1);
      int rightj = i;
      int temp2= 0;
      for(int  j=i+1;j<len;j++)
       {
 	     if (str[j] == 'a')
            temp2 += 1;
        else
            temp2-= 1;
        if (temp2>=temp){
            rightj = j;
            temp=temp2;
          }
		 }
    if (rightj == i)
        {cout<<"0,0\n";
        return;}
    cout<<i<<","<<rightj<<endl;
}
int main()
{
   int t;
   cin>>t;
   while(t--)
   {
     string str;
     cin>>str;
	solve(str);}
	return 0;
}

