/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

 class Node{
	public int max,min,inc,dcr,d;
	public long sum;
	public Node(){
		this.max=0;
		this.min=0;
		this.inc=0;
		this.dec=0;
		this.sum=0;
		this.d=0;
	}
	public Node(int min , int max , int inc ,int dec,int d,long sum){
		this.max=max;
		this.min=min;
		this.inc=inc;
		this.dec=dec;
		this.sum=sum;
		this.d=d;
	}
	public String toString(){
		return " heads="+this.heads+" tails="+this.tails+" flips="+this.flips;
	}
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
  class Main

 {

  public static void main(String[] args)throws Exception

    {                 

       	 InputStream inputStream = System.in;
 		 OutputStream outputStream = System.out;
         FastReader in = new FastReader(inputStream);
         PrintWriter out = new PrintWriter(outputStream);

         int n = in.nextInt();
         int q = in.nextInt();
		 int d[]= new int[n+1];
	   	 Node[] node = new Node[4*n+1];
		 for(int i=1;i<=n;i++)d[i]=in.nextInt();
		 for(int i=0;i<=4*n;i++)node[i]=new Node();
		 
		 maketree(1,1,n,node,d);
		// printtree(1,1,n,node);//debug
		for(int qq=1;qq<=q;qq++){
	
			char sgn = in.nextCharacter(); int i=in.nextInt(); int j=in.nextInt();
			int ans=0;
			if(sgn=='U'){ 
						update(1,1,n,node,i,j);
			}else if(sgn=='M'){
	 				    ans = queryM(1,1,n,node,i+1,j+1,0);
	  					out.write(""+ans+"\n");//out.flush();
			}else if(sgn=='S'){
				   ans = queryS(1,1,n,node,i+1,j+1,0);
	  			   out.write(""+ans+"\n");//out.flush();
			}else if(sgn=='I'){
				   ans = queryI(1,1,n,node,i+1,j+1,0);
	  			   out.write(""+ans+"\n");//out.flush();
			}else if(sgn=='D'){
			       ans = queryD(1,1,n,node,i+1,j+1,0);
	  			   out.write(""+ans+"\n");//out.flush();
			}
		}
		out.flush();
	
    }  
    public static void printtree(int index,int i,int j,Node[] node)throws Exception{
		if(i==j){
				node[index].d=d[i];
				node[index].min=node[index].max=d[i];
				node[index].inr=node[index].dcr=1;
				node[index].sum=d[i];
				//System.out.println("l="+i+" r="+j+node[index].toString());
				return;
		}
		//node[index].tails = j-i+1;
		//System.out.println("l="+i+" r="+j+node[index].toString());
		printtree(2*index,i,(i+j)/2,node);
		printtree(2*index+1,((i+j)/2)+1,j,node);
		
	} 
	public static void maketree(int index,int i,int j,Node[] node,int []d)throws Exception{
		if(i==j){
				node[index].d=d[i];
				node[index].min=node[index].max=d[i];
				node[index].inr=node[index].dcr=1;
				node[index].sum=d[i];
				return;
		}
		//node[index].tails = j-i+1;
		
		maketree(2*index,i,(i+j)/2,node,d);
		maketree(2*index+1,((i+j)/2)+1,j,node,d);
		node[index].max = Math.max(node[2*index].max,node[2*index+1].max);
		node[index].min = Math.min(node[2*index].min,node[2*index+1].min);
		if(node[2*index].asc==1&&node[2*index+1].asc==1&&node[2*index].min<node[2*index+1].min)node[index].inc=1;
		 else node[index].inc=0;
	}
	public static int query(int index,int l,int r,Node[] node,int i,int j,int flips)throws Exception{
		if(l>j||r<i||l>r)return 0;  //invalid condition
		if(l>=i&&r<=j){
						if(flips==1)return (node[index].tails);
						 else return node[index].heads;
						
					   }//completly contain the segment
					   
		
		int p1 = query(2*index,l,(l+r)/2,node,i,j,(flips+node[index].flips)%2);
		int p2 = query(2*index+1,((l+r)/2)+1,r,node,i,j,(flips+node[index].flips)%2);
		
		
		return p1+p2;
		
	}
	public static void update(int index,int l,int r,Node[] node,int i,int j)throws Exception{
		
		if(l>j||r<i||l>r)return ;  //invalid condition
		
		if(l>=i&&r<=j){
						 swap(node , index);
						 node[index].flips++;
						 node[index].flips%=2;	  	
						 				 	
						 return ;					 
						 
		}	
		
		update(2*index,l,(l+r)/2,node,i,j);
		update(2*index+1,((l+r)/2)+1,r,node,i,j);
		
		node[index].heads=(node[2*index].heads+node[2*index+1].heads);
		node[index].tails=r-l+1-node[index].heads;
		if(node[index].flips==1)swap(node , index);
		return ;
		
	}
	public static void swap(Node[] node ,int index)throws Exception{
		int temp = node[index].heads;
		node[index].heads = node[index].tails;
		node[index].tails = temp;
	}
	public static boolean isPrime(long n)throws Exception{
		if(n==1)return false;
		if(n==2||n==3)return true;
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0)return false;
		}
	return true;
	}
	public static long gcd(long a, long b)throws Exception{
		if(b==0)return a;
		return gcd(b,a%b);
	}
	public static long lcm(long a, long b)throws Exception{
		if(b==0||a==0)return 0;
		return (a*b)/gcd(a,b);
	}
    public static long pow(long a,long b,long mod)throws Exception{
		if(b==1)return a%mod;
		if(b==0)return 1;
		long ans=pow(a,b/2,mod);
		ans=(ans*ans)%mod;
		if(b%2!=0)ans=(ans*a)%mod;
	
		return ans;
	}
 } //end of class        
        
