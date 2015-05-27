/*logic ------------

*/
#include <iostream>
#include <algorithm>
#include <fstream>
#include <math.h>
using namespace std;

int main()
{ ofstream out;
  out.open("output1.txt");
  ifstream in;
  in.open("input1.txt");
  
int ttt;
in>>ttt;
while(ttt--){

	int a[110];

	int n , m , x , t=0 , sum=0;
	in >> n >> m;
	for( int i=0 ; i<n ; i++ )
	{
		in >> x;
		if( x < 0 )
			a[t++] = -x;
	}
	sort( a , a+t );
	reverse( a , a+t );
	for( int i=0 ; i<m && i<t ; i++ )
		sum += a[i];
    out << sum << endl;

}	return 0;
}
