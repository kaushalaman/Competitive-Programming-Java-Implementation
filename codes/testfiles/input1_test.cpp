#include <iostream>
#include <fstream>
#include <math.h>
using namespace std;

int main () {
  ofstream myfile;
  myfile.open ("input1.txt");
  myfile<<100<<endl;
  int i=0;
  for(;i<100;i++){
                  
                  int m = 1+(rand()%100);
                  myfile<<100<<" "<<m<<endl;
                  for(int j=1;j<=100;j++){
                    int k = rand()%101;
                    int s = rand()%2;
                    if(s==0||k==0)myfile<<k<<" ";
                     else myfile<<(-k)<<" ";
                  } 
                  myfile<<endl;
                  
                  }
  myfile.close();
  return 0;
}
