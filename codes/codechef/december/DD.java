//pakage joney_000[let_me_start]
/*
8 4
8
3 2
2 1
1 8
8 6
8 7
7 4
4 5
3
2
3
4
1
1
4
4
8
2 1
2 2
2 3
2 4
8 1
8 2
8 3
8 4
*/
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
 /******************** Main Class ***********************/

class DD
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
	
	public static void main(String[] args)throws Exception{
		
			
		
		
		int n = i();//m=n-1; 
		int k = i();
		ArrayList al[] = new ArrayList[k+1];
		for(int i =1;i<=k;i++)al[i]=new ArrayList();
		int root = i();
		
		
		int et[] = new int[2*n];  //euler tour [1..2n-1]
		LinkedList<Integer> adj[] = new LinkedList[n+1]; //Adjency List
		for(int i=1;i<=n ;i++)adj[i]=new LinkedList<Integer>();   //init List
		int l[] = new int[2*n];     //l[i] = level of node et[i]
		int f[] = new int[n+1];		  //f[i] = first occurence of node i in the et  
		
		int node[] = new int[4*(2*n)]; //seg tree
		int level[] = new int[n+1];		 // level[i]= level of node i in the tree
		int u=0,v=0;
		int m = n-1;
		for(int i=1;i<=m;i++){
			
			u=i();
			v=i();
			adj[u].add(v);
			adj[v].add(u);
		}
		for(int i=1;i<=n;i++){
		  al[i()].add(i);
		}
		
		dfs(adj,root,level,et,n);		//Assuming that node 1 is the root node
		//printEt(et,n);
		//printNodeLevels(level,n);
		
		for(int i=1;i<=2*n-1;i++){
			l[i]=level[et[i]];
			if(f[et[i]]==0)f[et[i]]=i;
			
		}
		
		maketree(1,1,2*n-1,node,l);    //l[1..2*n-1]
		//out.write("\nTree Built\n");out.flush();
		//for(int i=1;i<=n;i++)out.write(" "+f[i]);
		//out.flush();
		//printtree(1,1,2*n-1,node,l);
		int q = i();
		int temp=0,ans=0;
		HashMap<Integer,HashMap<Integer,Integer>> hm = new HashMap<Integer,HashMap<Integer,Integer>>();
		HashMap<Integer,Integer> tmp;
		for(int i=1;i<=q;i++){
		    int st = i(); int type = i();
			if(al[type].size()==0){
			  out.write("-1"+"\n");
			  continue;
			}
			tmp = hm.get(st);
			if(tmp!=null){
			   Integer nd = tmp.get(type); 
			  if(nd!=null){
			  
			   out.write(""+nd.intValue()+"\n");
			   out.flush();
			   continue;
			  
			  }
			
			}
			int max=-1;
			int ans_node=-1;int vv=0;
			for(int j = 0;j<al[type].size();j++){
			   // s = br.readLine().split(" ");
		    	u = st;
		    		v =(Integer) al[type].get(j);
				
				vv=v;
				if(f[u]>=f[v]){  //swap u,v
					temp = u; u=v; v=temp;
				}
				//out.write("indexes i="+f[u]+" j="+f[v]);out.flush();
				ans = et[query(1,1,2*n-1,node,l,f[u],f[v])];
				if(l[ans]>max){
				  max=l[ans];
				  ans_node = vv;
				}else if(l[ans]==max&& vv<ans_node){
				  ans_node=vv;
				}
			   
			}
			
			out.write(""+ans_node+"\n");out.flush();
		    tmp = hm.get(st);
			if(tmp==null){
			  HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
			  h.put(new Integer(vv),new Integer(ans_node));
			  hm.put(new Integer(st),h);
			}else{
			  tmp.put(new Integer(vv),new Integer(ans_node));
			}
		}
		out.flush();
		
		
	}
	 public static void printtree(int index,int i,int j,int[] node,int []L)throws Exception{
		if(i==j){out.write("\n min value btwn i="+i+" j="+j+" is"+node[index]);out.flush();
				return;}
	
		printtree(2*index,i,(i+j)/2,node,L);
		printtree(2*index+1,((i+j)/2)+1,j,node,L);
		out.write("\n min value btwn i="+i+" j="+j+" is"+node[index]);out.flush();
		
	}
	public static void maketree(int index,int i,int j,int[] node,int []L)throws Exception{
		if(i==j){node[index]=i;	return;	}
	
		maketree(2*index,i,(i+j)/2,node,L);
		maketree(2*index+1,((i+j)/2)+1,j,node,L);
	
		if(L[node[2*index]]<=L[node[2*index+1]])node[index]=node[2*index];
		else node[index]=node[2*index+1];
	}
	public static int query(int index,int l,int r,int[] node,int []L,int i,int j)throws Exception{
		if(l>j||r<i||l>r)return -1;  //invalid condition
		if(l>=i&&r<=j) return node[index];
		
		int p1 = query(2*index,l,(l+r)/2,node,L,i,j);
		int p2 = query(2*index+1,((l+r)/2)+1,r,node,L,i,j);
		
		if(p1==-1)return p2;
		if(p2==-1)return p1;
		if(L[p1]<=L[p2])return p1;
		else return p2;
	}
		
	public static void printEt(int[] et , int n)throws Exception{
		out.write("Euler Tour\n");out.flush();
		for(int i=1; i<=2*n-1 ;i++){
			out.write(" "+et[i]);
		
		}
		out.flush();
	}
	public static void printNodeLevels(int[] level , int n)throws Exception{
		out.write("levels\n");out.flush();
		for(int i=1; i<=n ;i++){
			out.write(" node "+i+" ="+level[i]);
		
		}
		out.flush();
	}
	public static void dfs(LinkedList<Integer> adj[] ,int root, int level[] ,int et[] , int n)throws Exception{
	
		boolean visited[] = new boolean[n+1];	
		LinkedList <Integer> q = new LinkedList<Integer>();
		int index = 1;
		int l = 0;//level
		
		q.add(root);
		visited[root]=true;
			
		while(!q.isEmpty()){
		
			int u = q.getLast(); //top
			if(et[index-1]!=u){et[index]=u;index++;}//if it's not leaf node
			level[u]=l;
			
			if(adj[u].size()>0){
				int v = adj[u].removeFirst();
				if(!visited[v]){
					q.add(v);l++;
					visited[v]=true; level[v]=l;
					et[index]=v; index++;
				}
			
			}else{
			
				int v = q.removeLast();
				l--;
			
			}
		
		}
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
 public static double pow(double a , long b )throws Exception{
   if(b==0)return 1.0D;
   if(b==1)return a;
   double ans = pow(a,b/2);
   ans = (ans * ans);
   if(b%2==1)ans = (a * ans);
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
