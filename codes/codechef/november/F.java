//pakage joney_000[let_me_start]
 
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
 /******************** Main Class ***********************/

 class F
{	
	

	public static long mod = 1000000000+9;
	public static BufferedWriter out;
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		 out = new BufferedWriter(new OutputStreamWriter(System.out));
		Reader in =new Reader();
		 long tests = in.readInt();
		 long arr [] =new long[500005];
		 long arr1 [] =new long[500005];
		 long po [] =new long[500005];
		 long f[] = new long[8];
		 long a[][] = new long[8][8];
		 long ansr [] =new long[501];
		 f[0]=1;
		 for(int i=1;i<=5 ; i++){
		   f[i] = f[i-1] * pow1(i,i);
		 }
		 for(int i=1;i<=5;i++){
		  for(int j=1;j<=i;j++){
		    a[i][j] = f[i]/(f[j]*f[i-j]);
		  }
		 }
		 long prime[] = new long[1000000];
		 int st=0;
		 prime[0]=2;
		 st++;
		 //int sq = (int)Math.sqrt(2000000000L);
		 int st1=1;
		 for(long i=3;i*i<=2000000000L;i+=2){
			if(isPrime(i)){prime[st]=i;st++;
			if(i<=500)st1++;
			}
			
		 }
		 long [][] fact = new long [505][st1+5];
		 for( int i=1;i<=500;i++){
		   int num =i;
		   for(int j=0;j<st1;j++){
				
				if(num%prime[j]==0){
				 
				 while(num%prime[j]==0){
				 
				  fact[i][j]+=1;
				  num=num/(int)prime[j];
				 }
				 
				}
				fact[i][j]=fact[i][j]*(i*1L);
				fact[i][j]+=fact[i-1][j];
		   }
		 
		 }
		// out.write(" st1=="+st1);out.flush();
		 HashMap<Integer , Integer > hm = new HashMap<Integer , Integer > ();
		 
		 Integer i1=null,i2=null;
		 for(int t = 1; t<= tests ;t++){
			int n = in.readInt(); long m = in.readLong(); int q=in.readInt();
			if(n<=5){
			for(int qq =1; qq<=q;qq++){
				int r = in.readInt();
				out.write(""+a[n][r]%m+"\n");
			
			}   
			continue;
			}
			Integer I = new Integer((int)m);
			I=hm.get(I);
			long to=0;
			if(I==null){
			 
			 to = tos(m,prime,st);
			 i1=new Integer((int)m);
			 i2=new Integer((int)to);
			 hm.put(i1,i2);
			}else{
			 to = I.intValue();
			} 
			if(n<=500 && to!=m-1){
				//prime factorization
				if(q<=95){
				
				for(int qq =1; qq<=q;qq++){
				int r = in.readInt();
				long ans =1L;
				for(int i=0;i<st1;i++){
				  ans = (ans * pow(prime[i],fact[n][i]-fact[r][i]-fact[n-r][i],m));
				  if(ans>=m)ans%=m;
				}
				out.write(""+ans+"\n");
			
				}
				}else{
				
				 for(int j=2;j<n;j++){
				  long ans =1L;
				  for(int i=0;i<st1;i++){
					ans = (ans * pow(prime[i],fact[n][i]-fact[j][i]-fact[n-j][i],m));
					if(ans>=m)ans%=m;
					}
				  ansr[j] = ans;
				 }
				 for(int qq =1; qq<=q;qq++){
					int r = in.readInt();
					long ans =ansr[r];
					out.write(""+ans+"\n");
				}
				
				
				
				}
				
				
				
			}else{
			
			arr[n+1]=arr[0]=1L;
			for(int i=n;i>=1;i--){
			 po[i]= pow(i,i,m);
			 arr[i] = (arr[i+1]*po[i]);//%m;
			 if(arr[i]>=m)arr[i]=arr[i]%m;
			}
			arr1[n+1]=arr1[0]=1L;
			for(int i=1;i<=n;i++){
			 
			 arr1[i] = (arr1[i-1]*po[i]);//%m;
			 if(arr1[i]>=m)arr1[i]=arr1[i]%m;
			 
			}
			long ans =1;
			
			
			int max=0,min=0,r=0;
			long nu=0 ,de=0;
			for(int qq =1; qq<=q;qq++){
				r = in.readInt();
				//long d= (arr[(int)r]*arr[(int)(n-r)])%m;
				//ans = (arr[(int)n]*pow(d,m-2,m))%m;
				//long nu =1;
				if(r>=n-r){
				  max = r;
				  min = n-r;
				}else{
					max = n-r;
					min = r ;
				}
				 nu = arr[max+1];
				 de = arr1[min];
				//out.write(" nu"+nu+" de="+de+"\n");
				 ans = (nu * pow(de , to-1 , m))%m;
				out.write(""+ans+"\n");
				
			}
			//out.write(""+ans+"\n");
			}
			}
			out.flush();
			return;
		}	 
		 
		 


//****************************** Utilities ***********************//
public static long tos(long n , long arr[] , int st)throws Exception{ 
        
       long result = n;
	 
       for(int i=0;i < st && n>=arr[i];i++) 
        { 
		  if(n<arr[i])break;
          if (n % arr[i] == 0) result -= result / arr[i]; 
          while (n % arr[i] == 0) n /= arr[i]; 
        } 
        if (n > 1) result -= result / n; 
        return result; 
 }
 public static boolean isPrime(long n)throws Exception{
  if(n==1)return false;
  if(n<=3)return true;
  if(n%2==0)return false;
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
 
 public static long pow1(long a , long b)throws Exception{
   if(b==0)return 1;
   if(b==1)return a;
   long ans = pow1(a,b/2);
   ans = (ans * ans);
   if((b&1L)==1)ans = (a * ans);
   return ans;
 }
 public static long pow(long a , long b ,long mod)throws Exception{
   if(b==0)return 1;
   if(b==1)return a;
   long ans = pow(a,b/2,mod);
   ans = (ans * ans);
   if(ans>=mod)ans%=mod;
   if((b%2)==1)ans = (a * ans);
   if(ans>=mod)ans%=mod;
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
//***********************I/O ENDS ***********************//
//*********************** 0.3%f [precision]***********************//
/* roundoff upto 2 digits 
   double roundOff = Math.round(a * 100.0) / 100.0;
                    or
   System.out.printf("%.2f", val);
					
*/
/*
  print upto 2 digits after decimal
  val = ((long)(val * 100.0))/100.0;
  
*/
}


class Reader {
private static final int SIZE = 1<<10;
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
  return this.a-p.a; 
 }
 public String toString(){
  return "a="+this.a+" b="+this.b;
 }
 
} 
