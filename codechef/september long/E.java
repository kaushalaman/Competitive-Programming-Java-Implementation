//pakage joney_000[let_me_start]

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Reader {
private static final int SIZE = 1<<12;
private static InputStream in = System.in;
private int offSet;
private int bufferSize;
private byte[] buffer;
private char[] charBuffer;
public Reader() {
buffer = new byte[SIZE];
charBuffer = new char[SIZE];
}
public int readInt() {
int number = 0;
boolean neg = false;
try {
if(offSet == bufferSize) {
offSet = 0;
bufferSize = in.read(buffer);
}
for(; offSet < bufferSize && buffer[offSet] != '-' && buffer[offSet] < '0'; offSet++) {
if(offSet == bufferSize-1) {
offSet = -1;
bufferSize = in.read(buffer);
}
}
if(buffer[offSet] == '-') {
neg = true;
offSet++;
if(offSet == bufferSize) {
offSet = 0;
bufferSize = in.read(buffer);
}
}
for(; offSet < bufferSize && buffer[offSet] >= '0' && buffer[offSet] <= '9'; offSet++) {
number = number * 10 - '0' + buffer[offSet];
if(offSet == bufferSize-1) {
offSet = -1;
bufferSize = in.read(buffer);
}
}
offSet++;
} catch(IOException io) {
io.printStackTrace();
System.exit(0);
}
return neg ? -number : number;
}
public long readLong() {
long number = 0;
boolean neg = false;
try {
if(offSet == bufferSize) {
offSet = 0;
bufferSize = in.read(buffer);
}
for(; offSet < bufferSize && buffer[offSet] != '-' && buffer[offSet] < '0'; offSet++) {
if(offSet == bufferSize-1) {
offSet = -1;
bufferSize = in.read(buffer);
}
}
if(buffer[offSet] == '-') {
neg = true;
offSet++;
if(offSet == bufferSize) {
offSet = 0;
bufferSize = in.read(buffer);
}
}
for(; offSet < bufferSize && buffer[offSet] >= '0' && buffer[offSet] <= '9'; offSet++) {
number = number * 10 - '0' + buffer[offSet];
if(offSet == bufferSize-1) {
offSet = -1;
bufferSize = in.read(buffer);
}
}
offSet++;
} catch(IOException io) {
io.printStackTrace();
System.exit(0);
}
return neg ? -number : number;
}
public double readDouble() {
return Double.parseDouble(readWord());
}
public String readLine() {
StringBuffer sb = new StringBuffer();
try {
if(offSet == bufferSize) {
offSet = 0;
offSet = in.read(buffer);
}
for(; offSet < bufferSize && buffer[offSet] < ' '; offSet++) {
if(offSet == bufferSize-1) {
offSet = -1;
bufferSize = in.read(buffer);
}
}
if(bufferSize == -1) {
return null;
}
int count = 0;
for(; offSet < bufferSize && buffer[offSet] != '\r' && buffer[offSet] != '\n'; offSet++) {
charBuffer[count] = (char)buffer[offSet];
count++;
if(count == SIZE) {
count = 0;
sb.append(charBuffer, 0, count);
}
if(offSet == bufferSize-1) {
offSet = -1;
bufferSize = in.read(buffer);
}
}
offSet++;
sb.append(charBuffer, 0, count);
} catch(IOException io) {
io.printStackTrace();
System.exit(0);
}
return sb.toString();
}
public String readWord() {
StringBuffer sb = new StringBuffer();
try {
if(offSet == bufferSize) {
offSet = 0;
offSet = in.read(buffer);
}
for(; offSet < bufferSize && buffer[offSet] < ' '; offSet++) {
if(offSet == bufferSize-1) {
offSet = -1;
bufferSize = in.read(buffer);
}
}
if(bufferSize == -1) {
return null;
}
int count = 0;
for(; offSet < bufferSize && buffer[offSet] != ' ' && buffer[offSet] != '\r' && buffer[offSet] != '\n'; offSet++) {
charBuffer[count] = (char)buffer[offSet];
count++;
if(count == SIZE) {
count = 0;
sb.append(charBuffer, 0, count);
}
if(offSet == bufferSize-1) {
offSet = -1;
bufferSize = in.read(buffer);
}
}
offSet++;
sb.append(charBuffer, 0, count);
} catch(IOException io) {
io.printStackTrace();
System.exit(0);
}
return sb.toString();
}
 
public char[] readWord(int n) {
char[] word = new char[n];
try {
if(offSet == bufferSize) {
offSet = 0;
offSet = in.read(buffer);
}
for(; offSet < bufferSize && buffer[offSet] < ' '; offSet++) {
if(offSet == bufferSize-1) {
offSet = -1;
bufferSize = in.read(buffer);
}
}
if(bufferSize == -1) {
return null;
}
for(int wi=0; offSet < bufferSize && buffer[offSet] != '\r' && buffer[offSet] != '\n'; offSet++) {
word[wi++] = (char)buffer[offSet];
if(offSet == bufferSize-1) {
offSet = -1;
bufferSize = in.read(buffer);
}
}
offSet++;
} catch(IOException io) {
io.printStackTrace();
System.exit(0);
}
return word;
}
 
}
 /******************** Pair class ***********************/
 class Pair implements Comparable<Pair>{
 public int a;
 public int b;
 public Pair(){
  this.a = 0;
  this.b = 0;
 }
 public Pair(int a,int b){
  this.a = a;
  this.b = b;
 }
 public int compareTo(Pair p){
  if(this.a==p.a){
   return this.b-p.b;  
  }
  return this.a-this.b; 
 }
 public String toString(){
  return "a="+this.a+" b="+this.b;
 }
 
} 
 /******************** Main Class ***********************/

class E
{	
    public static Reader in ;
    public static BufferedWriter out ;
	/*
	Overhead
	*/
	public static int tempints[] = new int[100005];
	public static long templongs[] = new long[100005];
	public static double tempdoubles[] = new double[100005];
	
	public static void main (String[] args) throws java.lang.Exception
	{
		//let_me_start 
		
		 in = new Reader();
		 out = new BufferedWriter(new OutputStreamWriter(System.out));
		 int n = i();
		 if(n==0){out.write("4\n");out.flush();return;}
		 if(n==1){i();i();out.write("3\n");out.flush();return;}
		 if(n==2){i();i();i();i();out.write("2\n");out.flush();return;}
		 Pair[]  point = new Pair[n];
		 HashMap <Pair , Integer> hm = new HashMap<Pair,Integer>();
		 for(int i=0;i<n;i++){
		  point[i] = new Pair(i(),i());
		  hm.put(point[i],1);
		 }
		 int ans = 2 ; 
		 Pair p1,p2,p3,p4 ;int a=0,b=0;
		 for(int i=0;i<n ;i++){
		   for(int j=i+1;j<n;j++){
				//tan(@)=-b/a;
				 b = point[i].a - point[j].a ;
				 a = point[j].b - point[i].b ;
				 p1 = new Pair(point[i].a + point[j].b-point[i].b , point[i].b + point[i].a - point[j].a);
				 p2 = new Pair(point[j].a + point[j].b-point[i].b , point[j].b + point[i].a - point[j].a);
				 p3 = new Pair(point[i].a - point[j].b-point[i].b , point[i].b - point[i].a - point[j].a);
				 p4 = new Pair(point[j].a - point[j].b-point[i].b , point[j].b - point[i].a - point[j].a);
				 
				 if((hm.get(p1)&&hm.get(p2))||(hm.get(p3)&& hm.get(p4)){
				   ans = 0;
				   out.write(""+ans+"\n");out.flush();return;
				 }else{
				    if(hm.get(p1)||hm.get(p2))||(hm.get(p3)|| hm.get(p4))ans = 1;
				 }
		   }
		 
		 }
		 out.write(""+ans+"\n");out.flush();
		 
}
//****************************** Utilities ***********************//
 public static boolean isPrime(long n)throws Exception{
  if(n==1)return false;
  if(n<=3)return true;
  for(int i=2 ;i <= Math.sqrt(n); i++){
   if(n%i==0)return false;
  }
  return true;
 }
 // sieve
 public static int[] primes(int n)throws Exception{       // for(int i=1;i<=arr.length-1;i++)out.write(""+arr[i]+" ");
  boolean arr[] = new boolean[n+1];
  Arrays.fill(arr,true);
  for(int i=1;i<=Math.sqrt(n);i++){
	if(!arr[i])continue;
	for(int j = 2*i ;j<=n;j+=i){
		arr[i]=false;
	}
  }
  LinkedList<Integer> ll = new LinkedList<Integer>();
  for(int i=1;i<=n;i++){
   if(arr[i])ll.add(i);
  }
  n = ll.size();
  
  int primes[] = new int[n+1];
  for(int i=1;i<=n;i++){
    primes[i]=ll.removeFirst();
  }
  return primes;
 }
 public static long gcd (long a , long b)throws Exception{
  if(b==0)return a;
  return gcd(b , a%b);
 }
 public static long lcm (long a , long b)throws Exception{
  if(a==0||b==0)return 0;
  return (a*b)/gcd(a,b);
 }
 public static long mulmod(long a , long b ,long mod)throws Exception{
   if(a==0||b==0)return 0;
   if(b==1)return a;
   long ans = mulmod(a,b/2,mod);
   ans = (ans*2)% mod;
   if(b%2==1)ans = (a + ans)% mod;
   return ans;
 }
 public static long pow(long a , long b ,long mod)throws Exception{
   if(b==0)return 1;
   if(b==1)return a;
   long ans = pow(a,b/2,mod);
   ans = (ans * ans)% mod;
   if(b%2==1)ans = (a * ans)% mod;
   return ans;
 }
 // 20*20   nCr Pascal Table
 public static long[][] ncrTable()throws Exception{
  long ncr[][] = new long[21][21];
  for(int i=0 ;i<=20 ;i++){ncr[i][0]=1;ncr[i][i]=1;}
  for(int j=0;j<=20 ;j++){
   for(int i=j+1;i<= 20 ;i++){
    ncr[i][j] = ncr[i-1][j]+ncr[i-1][j-1];
   }
  }
  return ncr;
 }
//*******************************I/O******************************//	
public static int i()throws Exception{
 //return Integer.parseInt(br.readLine().trim());
 return in.readInt();
}
public static int[] is(int n)throws Exception{
  //int arr[] = new int[n+1];
  for(int i=1 ; i <= n ;i++)tempints[i] = in.readInt();  
 return tempints;
}
public static long l()throws Exception{
 return in.readLong();
}
public static long[] ls(int n)throws Exception{
  //long arr[] = new long[n+1];
  for(int i=1 ; i <= n ;i++)templongs[i] = in.readLong();  
 return templongs;
}

public static double d()throws Exception{
 return in.readDouble();
}
public static double[] ds(int n)throws Exception{
  //double arr[] = new double[n+1];
  for(int i=1 ; i <= n ;i++)tempdoubles[i] = in.readDouble();  
 return tempdoubles;
}
public static String w()throws Exception{
 return in.readWord();
}

//***********************I/O ENDS ***********************//
}