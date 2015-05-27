#include <iostream>
#include <fstream>
#include <math.h>
using namespace std;

int main () {
  ofstream myfile;
  myfile.open ("input2.txt");
  myfile<<10<<endl;
  int i=0;
  for(;i<10;i++){
                  
                  int a = 1000000000+(rand()%100000);
                  int b = a+(rand()%10000000);
                  int c = 2+(1000*rand())%1000000000;
                  myfile<<a<<" "<<b<<" "<<c<<endl;
                   
                
                  }
  myfile.close();
  return 0;
}
