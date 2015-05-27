/* package joney_000 
	Fuck  TLE
*/

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


 class C

 {

  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    
        int tests=Integer.parseInt(br.readLine());
        for(int t=0;t<tests;t++){
        	
        	int n=Integer.parseInt(br.readLine());
        	char[]ch1=new char[200];char[]ch2=new char[200];
			for(int i=0;i<200;i++){ch1[i]='~';ch2[i]='~';}		
        	for(int i=0;i<n;i++){
				String[] s=br.readLine().split(" ");
				char c=s[0].charAt(0);
				char p=s[1].charAt(0);
				if(ch1[c]>p && p!='.')ch1[c]=p;
				else if(p=='.')ch2[c]='.';
			}
        String cipher=br.readLine();
		boolean dot=false;
		char[] plane=new char[cipher.length()];
		for(int i=0;i<cipher.length();i++){
			if(ch1[cipher.charAt(i)]=='~'&&ch2[cipher.charAt(i)]=='~'){if(cipher.charAt(i)=='.')dot=true;break;}
			}
		//check		
		for(int i=0;i<cipher.length();i++){
			if(ch1[cipher.charAt(i)]=='~'&&ch2[cipher.charAt(i)]=='~'){plane[i]=cipher.charAt(i);if(plane[i]=='.')dot=true;}
			else if(dot==false && ch2[cipher.charAt(i)]=='.'){dot=true;plane[i]='.';}
			else if(ch1[cipher.charAt(i)]!='~'){plane[i]=ch1[cipher.charAt(i)];}
		}
		plane=trail(plane,cipher.length(),dot);
	 out.write("");
		for(int i=0;i<plane.length;i++){
        out.write(""+plane[i]+"");out.flush();               
        	
        }
        out.write("\n");out.flush();
        }
    } 
  public static char[] trail(char[] plane , int n,boolean dot)throws Exception{
		String s="";
		boolean ch=false;
		for(int i=0;i<n;i++){
			if(ch==false){
				if(plane[i]=='0')continue;
				 else {ch=true;s+=(""+plane[i]);}
			}else{
				s+=(""+plane[i]);
			}
		}
		plane=s.toCharArray();
		n=s.length();
		s="";ch=false;
		if(dot){
		 
		 for(int i=n-1;i>=0;i--){
			if(ch==false){
				if(plane[i]=='0')continue;
				 else {ch=true;s=(""+plane[i]+""+s);}
			}else{
				s=(""+plane[i]+s);
			}
		 }
		 
		 plane=s.toCharArray();
		
		}
		if(plane[plane.length-1]=='.' && dot){  char[] c=new char[plane.length-1];
		for(int i=0;i<plane.length-1;i++){
			c[i]=plane[i];
			
		}
		return c;
		}	
		return plane;
	}
  
 }        
////////////////////////////////////////////////////////////////////////////////
#include <iostream>
#include <cstring>
using namespace std;
void trail(char* plane ,int n,bool dot){
long int st=0;
for(int i=0;i<n;i++){
if(plane[i]=='0')st++;
else break;
}
if(n==st){
cout<<"0"<<endl;return;
}
long int end=n-1;
if(dot){
for(int i=n-1;i>=0;i--){
if(plane[i]=='0')end--;
else break;
}
}
if(plane[end]=='.' && dot){
end--;
}	
if(st>end){cout<<"0"<<endl;return;}
for(int i=st;i<=end;i++){
cout<<plane[i];
}
cout<<endl;
return ;
}
int main() {
	// your code goes here
	long int tests;
	cin>>tests;
    	char ch1[200];
        char ch2[200];
	for(int t=0;t<tests;t++){
		long int n;
		cin>>n;
		for(int i=0;i<200;i++){ch1[i]='~';ch2[i]='~';}	
		for(int i=0;i<n;i++){
				
				char c,p;
				cin>>c>>p;
				if(ch1[c]>p && p!='.')ch1[c]=p;
				else if(p=='.')ch2[c]='.';
			}
			string cipher;
			cin>>cipher;
			bool dot=false;
			char plane[cipher.length()];
		/*for(int i=0;i<cipher.length();i++){
			if(ch1[cipher.charAt(i)]=='~'&&ch2[cipher.charAt(i)]=='~'){if(cipher.charAt(i)=='.')dot=true;break;}
			}
		//check		
		*/
		for(int i=0;i<cipher.length();i++){
			if(ch1[cipher[i]]=='~'&&ch2[cipher[i]]=='~'){plane[i]=cipher[i];if(plane[i]=='.')dot=true;}
			  else if(dot==false && ch2[cipher[i]]=='.'){dot=true;plane[i]='.';}
			  else if(ch1[cipher[i]]!='~'){plane[i]=ch1[cipher[i]];}
		}
		trail(plane,cipher.length(),dot);
        }
	
	return 0;
}        