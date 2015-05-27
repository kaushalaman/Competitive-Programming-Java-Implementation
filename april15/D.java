//pakage joney_000[let_me_start]
 
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
 /******************** Main Class ***********************/
 
 class Vertex implements Comparable<Vertex>{
	 
	 public int u,d;
	 public long weight; 
	 public LinkedList<Edge> adj ;//= new LinkedList<Edge>();	 
	 //public provide flexibility to access from outside the the class
	 //at the cost of security
	 public Vertex(){
		this.u= 0;
		this.d= 0;
		this.weight = 0L;
		this.adj = new LinkedList<Edge>();
	 }
	 public Vertex(int u){
		 this.u = u;
		 this.weight = weight;
	 }
	 @Override
	 public int compareTo(Vertex e){
		 if(this.d<e.d)return -1;
		 else if(this.d==e.d) return 0;
		 return 1;
	 }
 }

 class Edge implements Comparable<Edge>{
	 public int v;
	 public long weight; 
	 //public provide flexibility to access from outside the the class
	 //at the cost of security
	 public Edge(){
		
		this.v = 0;
		this.weight = 0L;
	 }
	 public Edge(int v , long weight){
		 this.v = v;
		 this.weight = weight;
	 }
	 @Override
	 public int compareTo(Edge e){
		 if(this.weight<e.weight)return -1;
		 else if(this.weight==e.weight) return 0;
		 return 1;
	 }
 }

 class D
{	
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
		 //int tests=i();
		 //int arr[] = is(n);
		 //String ans = "No";
			LinkedList<Integer> ansp = new LinkedList<Integer>();
			
			LinkedList<Integer> ansn = new LinkedList<Integer>();
			int n = i(); int m = i();
			int d[] = new int[n];
			// 0 - n-1
			Vertex[] vtx = new Vertex[n];
			//Edge adj[] = new Edge[m+2];
			for(int i=0;i<n;i++)vtx[i] = new Vertex();
			for(int i=1;i<=m;i++){
				int u =i(); int v = i(); int w =i();
			    vtx[u].adj.add(new Edge(v,w));
				vtx[u].u = u;
				vtx[u].weight += w; 
				vtx[v].adj.add(new Edge(u,w));
				vtx[v].u = v;
				vtx[v].weight += w; 
				d[u]++;
				d[v]++;
		   }
		for(int i=0;i<n;i++)vtx[i].d = d[i];
		Arrays.sort(vtx);
        int cntp = 0,cntn=0;
		int vis[] = new int[n]; //0novis  1vis  2anti vis
		
		for(int i=1;i<=n-1;i++){
			if(cntp>=n/2||cntn>=n/2)break;
			int u = vtx[i].u;
			if(vis[u]==0){
				ansp.add(u);
				cntp++;
				vis[u] = 1;
			}
			//if(!vtx[i].adj.isEmpty())Collections.sort(vtx[i].adj);
			while(!vtx[i].adj.isEmpty()){
				if(cntp>=n/2||cntn>=n/2)break;
				
				int v = ((Edge)vtx[i].adj.removeLast()).v;
				if(vis[v]==0){
						ansp.add(v);
						vis[v] = 1;
						cntp++;
				}
			}
		}
	//	out.write(""+cntp+" \n");
			
		
		if(cntp>=n/2){
			for(int i=1;i<=n/2;i++){
				int a =ansp.removeFirst();
				out.write(""+a+" ");
			}
		}
		
		out.flush();
		return;
		}


//****************************** Utilities ***********************//

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
	private byte[] buf = new byte[1024];
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
