/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class A implements Comparable<A>{
 public String id;
 public int idd;
 public A(){}
 public A(String id,int idd){
 	this.id=id;
 	this.idd=idd;
 	
 }
 public int compareTo(A a){
 	if(this.idd<a.idd)return -1;
	else if(this.idd== a.idd)return 0;
	else return 1;
 	
 }
}
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		A [] a = new A[3];
		
		HashMap<Long,A> hm = new HashMap<Long,A>();
		a[1]=new A("5464664848814",101);
		hm.put(new Long(a[1].idd),a[1]);
		a[2]=new A("1548451248150",100);
		hm.put(new Long(a[2].idd),a[2]);
		a[0]=new A("5464664848815",15);
		hm.put(new Long(a[0].idd),a[0]);
		
		hm.get(new Long(a[1].idd)).idd=1111;
		///Arrays.sort(a);
		//for(int i=1;i<=3;i++)System.out.println(hm.get(a[i-1].id).id);
		for(int i=1;i<=3;i++)System.out.println(hm.get(new Long(101)).idd);
	}
}