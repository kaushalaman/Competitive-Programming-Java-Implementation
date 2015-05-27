//pakage joney_000[let_me_start]
 
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
 /******************** Main Class ***********************/
class Node implements Comparable<Node>{
	public int id=0;
	public int xmin,size;
	public int ymin;
	public int pairs[][];
	public Node(){size=0;}
	public Node(int id,int size){
		this.id = id;
		this.size = size;
		pairs = new int[size+2][2]; 
	}
	public int compareTo(Node a){	
		if(this.ymin<a.ymin) return -1;
		if(this.ymin==a.ymin) return this.xmin - a.xmin;
		else return 1;
   }
   
}
class F
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
	public static int h=0,k=0,w=0;
public static void main(String[] args) throws java.lang.Exception{
		//let_me_start 
			
	    h=i();w=i();k=i();
		Node node[] = new Node[k+4];
		for(int t=1;t<=k;t++){
		  
		  int n=i();
		  node[t] = new Node(t,n);
		  int xmin=1000000;
		  int xmax=-1000000;
		  int ymin=1000000;
		  int ymax=-1000000;
		  
		  for(int i=1;i<=n;i++){
		   node[t].pairs[i][0]=i();node[t].pairs[i][1]=i();
		   xmin = Math.min(xmin,node[t].pairs[i][0]);
		   ymin = Math.min(ymin,node[t].pairs[i][1]);
		   xmax = Math.min(xmax,node[t].pairs[i][0]);
		   ymax = Math.min(ymax,node[t].pairs[i][1]);
		   
		  }
		  node[t].size = n;
		  node[t].xmin = xmin;
		  
		  node[t].ymin = ymin;
		}  
		
		int density = 0;
		int cnt1=0,cnt2=0;
		Arrays.sort(node,1,k+1);
		int mat1[][] = new int[h+1][w+1];
		int mat2[][] = new int[h+1][w+1];
		//int mat3[][] = new int[h+1][w+1];
		/*
		
		  Oh my Shinchan , Dear i miss the left points which not allocated , let_me_start to allocate them  ..:D..:P 
		
		*/
		LinkedList<Integer> missed1 = new LinkedList<Integer>();
		
		LinkedList<Integer> missed2 = new LinkedList<Integer>();
		
		for(int t=1;t<=k;t++){
		    if(!checkAvilableDown(mat1,node,t,0,0)){
			int idx = t;
			int xShift = 0;
			int yShift = 0;
			while(!checkAvilableDown(mat1,node,idx,xShift,yShift)){
				if(xShift>99){xShift--;break;}
			     if(yShift>99){yShift--;break;}
				xShift++;
				yShift++;
			}
			if(xShift!=99&&yShift!=99){
				
			   for(int i=1;i<=node[idx].size;i++){
					cnt1++;
					mat1[xShift+node[idx].pairs[i][0]][yShift+node[idx].pairs[i][1]]=node[idx].id;
				
				}
			
			}else{
			  missed1.add(t);
			}
			continue;
			}
			int xShift=0;
			for(xShift=1;;xShift++){
			 if(!checkAvilableDown(mat1,node,t,xShift,0)){
			  xShift--;break;
			 }
			}
			int yShift = 0;
			for(yShift=1;;yShift++){
			 if(!checkAvilableDown(mat1,node,t,xShift,yShift)){
			  yShift--;break;
			 }
			}
			for(int i=1;i<=node[t].size;i++){
					cnt1++;
					mat1[xShift+node[t].pairs[i][0]][yShift+node[t].pairs[i][1]]=node[t].id;
				
			}
		}
		for(int t=1;t<=k;t++){
		  if(!checkAvilableUp(mat2,node,t,0,0)){
			int idx = t;
			int xShift = 0;
			int yShift = 0;
			while(!checkAvilableUp(mat2,node,idx,xShift,yShift)){
				if(xShift<-99){xShift++;break;}
			    if(yShift<-99){yShift++;break;}
				xShift--;
				yShift--;
			}
			if(xShift!=-99&&yShift!=-99){
				
			   for(int i=1;i<=node[idx].size;i++){
					cnt2++;
					mat2[-xShift+node[idx].pairs[i][0]][-yShift+node[idx].pairs[i][1]]=node[idx].id;
				
				}
			
			}
			continue;
			}//that's it Baby
			int xShift=0;
			for(xShift=1;;xShift++){
			 if(!checkAvilableUp(mat2,node,t,xShift,0)){
			  xShift--;break;
			 }
			}
			int yShift = 0;
			for(yShift=1;;yShift++){
			 if(!checkAvilableUp(mat2,node,t,xShift,yShift)){
			  yShift--;break;
			 }
			}
			for(int i=1;i<=node[t].size;i++){
					cnt2++;
					mat2[-xShift+node[t].pairs[i][0]][-yShift+node[t].pairs[i][1]]=node[t].id;
				
			}
		
		}
		//missed 1 processing
		while(!missed1.isEmpty()){
			int idx = missed1.removeFirst();
			int xShift = 0;
			int yShift = 0;
			while(!checkAvilableDown(mat1,node,idx,xShift,yShift)){
				if(xShift<-99){xShift++;break;} 
				xShift--;
			}
			if(xShift==-99){
				xShift=0;
				yShift=0;
				while(!checkAvilableDown(mat1,node,idx,xShift,yShift)){
					if(yShift<-99){yShift++;break;}
					yShift--;
				}
				if(yShift!=-99){
				 for(int i=1;i<=node[idx].size;i++){
					cnt1++;
					mat1[xShift+node[idx].pairs[i][0]][yShift+node[idx].pairs[i][1]]=node[idx].id;
				
				 }
				}
		    }else{
			  
			   for(int i=1;i<=node[idx].size;i++){
					cnt1++;
					mat1[xShift+node[idx].pairs[i][0]][yShift+node[idx].pairs[i][1]]=node[idx].id;
				
				}
			
			}
			}
			
		
	
		
		
		
		if(cnt1>cnt2){
			//	out.write("\ncnt1="+cnt1+"\n");
		for(int i=1;i<=h;i++){
			for(int j=1;j<=w;j++){
			
				out.write(""+mat1[i][j]+" ");
			}
			
				out.write("\n");
		}
		}else{  //out.write("\n"+cnt2+"\n");
		  for(int i=1;i<=h;i++){
			for(int j=1;j<=w;j++){
			
				out.write(""+mat2[i][j]+" ");
			}
			
				out.write("\n");
		   }
		
		}
		out.flush();
		return;
		}





//****************************** Utilities ***********************//

 public static boolean checkAvilableUp(int mat[][],Node[] node,int t,int xShift,int yShift)throws Exception{
   for(int i=1;i<=node[t].size;i++){
   	
     if(-xShift+node[t].pairs[i][0]>h||-yShift+node[t].pairs[i][1]>w)return false;
     if(-xShift+node[t].pairs[i][0]<1|| -yShift+node[t].pairs[i][1]<1)return false;
	 if(mat[-xShift+node[t].pairs[i][0]][-yShift+node[t].pairs[i][1]]!=0)return false;
   }
   return true;
 }
 public static boolean checkAvilableDown(int mat[][],Node[] node,int t,int xShift,int yShift)throws Exception{
   for(int i=1;i<=node[t].size;i++){
     if(xShift+node[t].pairs[i][0]>h||yShift+node[t].pairs[i][1]>w)return false;
	 if(xShift+node[t].pairs[i][0]<1||yShift+node[t].pairs[i][1]<1)return false;
	 if(mat[xShift+node[t].pairs[i][0]][yShift+node[t].pairs[i][1]]!=0)return false;
   }
   return true;
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
