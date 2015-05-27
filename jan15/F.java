/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
 class Node{
   //public int [] C = new int[3]; 
   public long T = 0;
      
   public long [] L = new long[3];
   public long [] R = new long[3];
   public long [] M = new long[3];
  
   public Node(){
   
   }
  
  }
 class F{
 
   public static InputStream inputStream = System.in;
	public static OutputStream outputStream = System.out;
	public static FastReader in = new FastReader(inputStream);;
    public static PrintWriter out = new PrintWriter(outputStream);;
	/*
	Overhead [Additional Temporary Strorage]
	*/
	public static int tempints[] = new int[100005];
	public static long templongs[] = new long[100005];
	public static double tempdoubles[] = new double[100005];
	public static char tempchars[] = new char[100005];
	public static long mod = 1000000000+7;
	
	public static void main(String[] args) throws java.lang.Exception{
		//let_me_start 
//		 int tests=i();
	
	int n = i();int q = i();
	String ss = s();
	int num[] = new int[n+1];
	for(int i=1;i<=ss.length();i++){
	  num[i]= (ss.charAt(i-1)-'0')%3;
	}
	 
	Node[] m = new Node[3*n+1];//size = 2*n+1
	for(int i=1;i<=3*n;i++)m[i] = new Node();
    
	maketree(1,1,n,m,num);
	
	for(int qq=1;qq<=q;qq++){
	//s = br.readLine().split(" ");
    int sgn = i();	
	int i = i(); int j=i();
	if(sgn==1){
	   num[i]=j%3;
	   
	   update(1,1,n,m,num,i,i);
	
	}else{ 
	  Node ans = query(1,1,n,m,num,i,j);
	   
	  long res = 0;
	  res = ans.L[0]+ans.M[0]+ans.R[0];
	  if(ans.T==0)res--;
	  //res-=merge;
	  out.write(""+res+"\n");out.flush();
	  //out.write("tot mer="+merge+"\n");
	  out.flush();
	}
	}
	
    }   
	public static void maketree(int node,int i,int j,Node[] m,int []num)throws Exception{
		if(i==j){
		
		        m[node].T = num[i];
			    m[node].R[num[i]]=1;m[node].L[num[i]]=1;
				//print(node,m);	
			 return;
		}
	
		maketree(2*node,i,(i+j)/2,m,num);
		maketree(2*node+1,((i+j)/2)+1,j,m,num);
		//logic
		for(int k=0;k<=2;k++)m[node].L[k]=m[2*node].L[k];
		for(int k=0;k<=2;k++)m[node].L[(int)((m[2*node].T + k)%3)] += m[2*node+1].L[k];
		//left updated  
		for(int k=0;k<=2;k++)m[node].R[k]=m[2*node+1].R[k];
		for(int k=0;k<=2;k++)m[node].R[(int)((m[2*node+1].T + k)%3)] += m[2*node].R[k];
		//right updated
		//m[node].Merge = m[2*node].Merge + m[2*node+1].Merge ;
		m[node].T=( m[2*node].T + m[2*node+1].T )%3;
		//if(m[node].T==0)m[node].Merge += 1;
		//total updated
		for(int k=0;k<=2;k++)m[node].M[k] = m[2*node].M[k] + m[2*node+1].M[k] ;
		for(int k=0;k<=2;k++){
			if(m[2*node].T==k)m[node].M[k] += Math.max(0,m[2*node].R[k]-1);
			 else m[node].M[k] += Math.max(0,m[2*node].R[k]);
			if(m[2*node+1].T==k)m[node].M[k] += Math.max(0,m[2*node+1].L[k]-1);
			 else m[node].M[k] += Math.max(0,m[2*node+1].L[k]);
		}
		
		for(int k=0;k<=2;k++)for(int s=0;s<=2;s++){
		    if(m[2*node].T==k&&m[2*node+1].T==s)
		      m[node].M[(int)((k+s)%3)] += (Math.max(m[2*node].R[k]-1,0))*(Math.max(0,m[2*node+1].L[s]-1));
			else if(m[2*node].T!=k&&m[2*node+1].T==s) 
			  m[node].M[(int)((k+s)%3)] += (Math.max(m[2*node].R[k],0))*(Math.max(0,m[2*node+1].L[s]-1));
			else if(m[2*node].T==k&&m[2*node+1].T!=s)
              m[node].M[(int)((k+s)%3)] += (Math.max(m[2*node].R[k]-1,0))*(Math.max(0,m[2*node+1].L[s]));			
			else if(m[2*node].T!=k&&m[2*node+1].T!=s)
              m[node].M[(int)((k+s)%3)] += (Math.max(m[2*node].R[k],0))*(Math.max(0,m[2*node+1].L[s]));				
		}
		//m[node].M[(int)((m[2*node].T + m[2*node+1].T)%3)] -= 1 ;
	//	print(node,m);
	}
	
	public static void print(int node,Node[] m)throws Exception{
	 System.out.println("printing node "+node);
	 System.out.println("T= "+m[node].T);
	 //System.out.println("Merge= "+m[node].Merge);
	 
	 for(int i=0;i<=2;i++){
	   System.out.println("L,M,R"+m[node].L[i]+" "+m[node].M[i]+" "+m[node].R[i]);
	 }
	}
	public static Node query(int node,int l,int r,Node[] m,int []num,int i,int j)throws Exception{
		if(l>j||r<i||l>r)return null;  //invalid condition
		//if(l>=i&&r<=j) return m[node].L[0]+m[node].M[0]+m[node].R[0]-1;
		if(l>=i&&r<=j) { return m[node]; }
		
		Node arr1 = query(2*node,l,(l+r)/2,m,num,i,j);
	    Node arr2 = query(2*node+1,((l+r)/2)+1,r,m,num,i,j);
		
		if(arr1==null)return arr2;
		if(arr2==null)return arr1;
		Node arr = new Node();
		//logic
		for(int k=0;k<=2;k++)arr.L[k]=arr1.L[k];
		for(int k=0;k<=2;k++)arr.L[(int)((arr1.T + k)%3)] += arr2.L[k];
		//left updated  
		for(int k=0;k<=2;k++)arr.R[k]=arr2.R[k];
		for(int k=0;k<=2;k++)arr.R[(int)((arr2.T + k)%3)] += arr1.R[k];
		//right updated
		
		arr.T=( arr1.T + arr2.T )%3;
		//total updated
		
		for(int k=0;k<=2;k++)arr.M[k] = arr1.M[k] + arr2.M[k] ;
		
		for(int k=0;k<=2;k++){
		       if(arr1.T==k)arr.M[k] += Math.max(0,arr1.R[k]-1);
			    else arr.M[k] += arr1.R[k];
			   if(arr2.T==k)arr.M[k]+= Math.max(0,arr2.L[k]-1);
			    else arr.M[k]+= arr2.L[k];
		}	   
		for(int k=0;k<=2;k++)for(int s=0;s<=2;s++){
				if(arr1.T==k&&arr2.T==s)
					arr.M[(int)((k+s)%3)] += (Math.max(0,arr1.R[k]-1))*(Math.max(0,(arr2.L[s]-1)));
				else if(arr1.T!=k&&arr2.T==s)
					arr.M[(int)((k+s)%3)] += (Math.max(0,arr1.R[k]))*(Math.max(0,(arr2.L[s]-1)));
				else if(arr1.T==k&&arr2.T!=s)
					arr.M[(int)((k+s)%3)] += (Math.max(0,arr1.R[k]-1))*(Math.max(0,(arr2.L[s])));
				else if(arr1.T!=k&&arr2.T!=s)
					arr.M[(int)((k+s)%3)] += (Math.max(0,arr1.R[k]))*(Math.max(0,(arr2.L[s])));
				
		}
		// arr.M[(int)((k+s)%3)] += arr1.R[k]*arr2.L[s];
	    //arr.M[(int)((arr1.T + arr2.T)%3)] -= 1 ;
		//print(node,m);
		
		return arr;
	}

	public static void update(int node,int l,int r,Node[] m,int []num,int i,int j)throws Exception{
		if(l>j||r<i||l>r)return ;  //invalid condition
		//if(l>=i&&r<=j) return m[node].L[0]+m[node].M[0]+m[node].R[0]-1;
		if(l>=i&&r<=j) {
		       for(int k=0;k<=2;k++){
				 m[node].L[k]=m[node].R[k]=m[node].M[k]=0;
		       }
		        m[node].T = num[i];
			    m[node].R[num[i]]=1;m[node].L[num[i]]=1;
				//print(node,m);	
			 return;
	
		}
		
		update(2*node,l,(l+r)/2,m,num,i,j);
	    update(2*node+1,((l+r)/2)+1,r,m,num,i,j);
	     
		//logic
		m[node].T=0;
		for(int k=0;k<=2;k++){
				m[node].L[k]=m[node].R[k]=m[node].M[k]=0;
		}
		for(int k=0;k<=2;k++)m[node].L[k]=m[2*node].L[k];
		for(int k=0;k<=2;k++)m[node].L[(int)((m[2*node].T + k)%3)] += m[2*node+1].L[k];
		//left updated  
		for(int k=0;k<=2;k++)m[node].R[k]=m[2*node+1].R[k];
		for(int k=0;k<=2;k++)m[node].R[(int)((m[2*node+1].T + k)%3)] += m[2*node].R[k];
		//right updated
		//m[node].Merge = m[2*node].Merge + m[2*node+1].Merge ;
		m[node].T=( m[2*node].T + m[2*node+1].T )%3;
		//if(m[node].T==0)m[node].Merge += 1;
		//total updated
		for(int k=0;k<=2;k++)m[node].M[k] = m[2*node].M[k] + m[2*node+1].M[k] ;
		for(int k=0;k<=2;k++){
			if(m[2*node].T==k)m[node].M[k] += Math.max(0,m[2*node].R[k]-1);
			 else m[node].M[k] += Math.max(0,m[2*node].R[k]);
			if(m[2*node+1].T==k)m[node].M[k] += Math.max(0,m[2*node+1].L[k]-1);
			 else m[node].M[k] += Math.max(0,m[2*node+1].L[k]);
		}
		
		for(int k=0;k<=2;k++)for(int s=0;s<=2;s++){
		    if(m[2*node].T==k&&m[2*node+1].T==s)
		      m[node].M[(int)((k+s)%3)] += (Math.max(m[2*node].R[k]-1,0))*(Math.max(0,m[2*node+1].L[s]-1));
			else if(m[2*node].T!=k&&m[2*node+1].T==s) 
			  m[node].M[(int)((k+s)%3)] += (Math.max(m[2*node].R[k],0))*(Math.max(0,m[2*node+1].L[s]-1));
			else if(m[2*node].T==k&&m[2*node+1].T!=s)
              m[node].M[(int)((k+s)%3)] += (Math.max(m[2*node].R[k]-1,0))*(Math.max(0,m[2*node+1].L[s]));			
			else if(m[2*node].T!=k&&m[2*node+1].T!=s)
              m[node].M[(int)((k+s)%3)] += (Math.max(m[2*node].R[k],0))*(Math.max(0,m[2*node+1].L[s]));				
		}
		//m[node].M[(int)((m[2*node].T + m[2*node+1].T)%3)] -= 1 ;
		//print(node,m);
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
 return in.nextInt();
}
public static int[] is(int n)throws Exception{
  //int arr[] = new int[n+1];
  for(int i=1 ; i <= n ;i++)tempints[i] = in.nextInt();  
 return tempints;
}
public static long l()throws Exception{
 return in.nextLong();
}
public static long[] ls(int n)throws Exception{
  for(int i=1 ; i <= n ;i++)templongs[i] = in.nextLong();  
 return templongs;
}

public static double d()throws Exception{
 return in.nextDouble();
}
public static double[] ds(int n)throws Exception{
  for(int i=1 ; i <= n ;i++)tempdoubles[i] = in.nextDouble();  
 return tempdoubles;
}
public static char c()throws Exception{
 return in.nextCharacter();
}
public static char[] cs(int n)throws Exception{
  for(int i=1 ; i <= n ;i++)tempchars[i] = in.nextCharacter();  
 return tempchars;
}
public static String s()throws Exception{
 return in.nextLine();
}
public static BigInteger bi()throws Exception{
 return in.nextBigInteger();
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

class FastReader{

	private boolean finished = false;

	private InputStream stream;
	private byte[] buf = new byte[2048];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public FastReader(InputStream stream){
		this.stream = stream;
	}

	public int read(){
		if (numChars == -1){
			throw new InputMismatchException ();
		}
		if (curChar >= numChars){
			curChar = 0;
			try{
				numChars = stream.read (buf);
			} catch (IOException e){
				throw new InputMismatchException ();
			}
			if (numChars <= 0){
				return -1;
			}
		}
		return buf[curChar++];
	}

	public int peek(){
		if (numChars == -1){
			return -1;
		}
		if (curChar >= numChars){
			curChar = 0;
			try{
				numChars = stream.read (buf);
			} catch (IOException e){
				return -1;
			}
			if (numChars <= 0){
				return -1;
			}
		}
		return buf[curChar];
	}

	public int nextInt(){
		int c = read ();
		while (isSpaceChar (c))
			c = read ();
		int sgn = 1;
		if (c == '-'){
			sgn = -1;
			c = read ();
		}
		int res = 0;
		do{
			if(c==','){
				c = read();
			}
			if (c < '0' || c > '9'){
				throw new InputMismatchException ();
			}
			res *= 10;
			res += c - '0';
			c = read ();
		} while (!isSpaceChar (c));
		return res * sgn;
	}

	public long nextLong(){
		int c = read ();
		while (isSpaceChar (c))
			c = read ();
		int sgn = 1;
		if (c == '-'){
			sgn = -1;
			c = read ();
		}
		long res = 0;
		do{
			if (c < '0' || c > '9'){
				throw new InputMismatchException ();
			}
			res *= 10;
			res += c - '0';
			c = read ();
		} while (!isSpaceChar (c));
		return res * sgn;
	}

	public String nextString(){
		int c = read ();
		while (isSpaceChar (c))
			c = read ();
		StringBuilder res = new StringBuilder ();
		do{
			res.appendCodePoint (c);
			c = read ();
		} while (!isSpaceChar (c));
		return res.toString ();
	}

	public boolean isSpaceChar(int c){
		if (filter != null){
			return filter.isSpaceChar (c);
		}
		return isWhitespace (c);
	}

	public static boolean isWhitespace(int c){
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	private String readLine0(){
		StringBuilder buf = new StringBuilder ();
		int c = read ();
		while (c != '\n' && c != -1){
			if (c != '\r'){
				buf.appendCodePoint (c);
			}
			c = read ();
		}
		return buf.toString ();
	}

	public String nextLine(){
		String s = readLine0 ();
		while (s.trim ().length () == 0)
			s = readLine0 ();
		return s;
	}

	public String nextLine(boolean ignoreEmptyLines){
		if (ignoreEmptyLines){
			return nextLine ();
		}else{
			return readLine0 ();
		}
	}

	public BigInteger nextBigInteger(){
		try{
			return new BigInteger (nextString ());
		} catch (NumberFormatException e){
			throw new InputMismatchException ();
		}
	}

	public char nextCharacter(){
		int c = read ();
		while (isSpaceChar (c))
			c = read ();
		return (char) c;
	}

	public double nextDouble(){
		int c = read ();
		while (isSpaceChar (c))
			c = read ();
		int sgn = 1;
		if (c == '-'){
			sgn = -1;
			c = read ();
		}
		double res = 0;
		while (!isSpaceChar (c) && c != '.'){
			if (c == 'e' || c == 'E'){
				return res * Math.pow (10, nextInt ());
			}
			if (c < '0' || c > '9'){
				throw new InputMismatchException ();
			}
			res *= 10;
			res += c - '0';
			c = read ();
		}
		if (c == '.'){
			c = read ();
			double m = 1;
			while (!isSpaceChar (c)){
				if (c == 'e' || c == 'E'){
					return res * Math.pow (10, nextInt ());
				}
				if (c < '0' || c > '9'){
					throw new InputMismatchException ();
				}
				m /= 10;
				res += (c - '0') * m;
				c = read ();
			}
		}
		return res * sgn;
	}

	public boolean isExhausted(){
		int value;
		while (isSpaceChar (value = peek ()) && value != -1)
			read ();
		return value == -1;
	}

	public String next(){
		return nextString ();
	}

	public SpaceCharFilter getFilter(){
		return filter;
	}

	public void setFilter(SpaceCharFilter filter){
		this.filter = filter;
	}

	public interface SpaceCharFilter{
		public boolean isSpaceChar(int ch);
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
