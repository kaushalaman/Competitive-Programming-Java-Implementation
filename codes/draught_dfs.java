import java.util.*;
import java.lang.*;
import java.io.*;
class Graph{
	private long ans1;
	private long ans2;
	private int V; // no of vertices
    private ArrayList<ArrayList<Integer>> adj; // adjacency list
	
	public Graph(int V) {
		this.V = V;
		this.adj = new ArrayList<ArrayList<Integer>>(V+1);
		for(int i = 0; i <=V; i++) {
			this.adj.add(new ArrayList<Integer>());
		}
		this.ans1=0;
		this.ans2=0;
	}
	public void addEdge(int u, int v) {

		adj.get(u).add(v); // adding v to array list u
	}
	public long dfs1(boolean[] isValid){
		
		boolean visited[] = new boolean[V+1];
		for(int i = 1; i <=V; i++) {
			visited[i] = false;
		}
		long k=0;
	for(int i=1;i<=V;i++){
		k=0;
		if(isValid[i]==false||visited[i]==true)continue;
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(i);
		visited[i] = true;
		k++;
		//System.out.print("\n"+i + " ");
	    while(!stack.isEmpty()) {
		
			int top = stack.peek();    //not pop->we dont remove node from stack untilt its adj node are visited
			// check if the top element has any unvisited nodes
			int child = getNextUnvisitedChild(top, visited);
			if(child == -1) {
				// no more unvisited childs hence pop it
				stack.pop();
		
			}else{	
			
			visited[child] = true;
			if(isValid[child])k++;
				stack.push(child);
			//System.out.print(child + " ");
				 			      
				 }
	    }
            
	ans1+=(k*(k-1))/2;
        //System.out.println("\n"+k+" "+ans1);
	}  
	//System.out.println("\n"+ans1);
	return ans1;
	}
	

	public void dfs2(boolean[] isValid){
		
		boolean visited[] = new boolean[V+1];
		
		
		for(int i = 1; i <=V; i++) {
			visited[i] = false;
		}
		
		
	for(int i=1;i<=V;i++){
		
		if(visited[i]==true||isValid[i]==false)continue;
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(i);
		visited[i] = true;
		 
		//num[index]=i;index++;
		//.out.print("\n"+i + " ");
        boolean flag=false;  
	    while(!stack.isEmpty()) {
		
			int top = stack.peek();    //not pop->we dont remove node from stack untilt its adj node are visited
			// check if the top element has any unvisited nodes
			int child = getNextUnvisitedChild(top, visited);
			
			if(child == -1) {
				// no more unvisited childs hence pop it
				int a=stack.pop();
                int parent=-1;
				try{ parent=stack.peek(); 	}catch(Exception e){}
				if(flag==true &&parent>=0)isValid[parent]=true;
				;if(isValid[a]==true&&parent>=0){flag=true;isValid[parent]=true;}
			
			}else{	
			flag=false;
			visited[child] = true;
			
				stack.push(child);
				//num[index]=child;index++;
			//System.out.print(child + " ");
				}
				 
	    }
            
	

	}
	
	}	
public long dfs3(boolean[] isValid){
		
		
		boolean visited[] = new boolean[V+1];
		
		
		for(int i = 1; i <=V; i++) {
			visited[i] = false;
		}
		
	long k1=0,k=0;	
	for(int i=1;i<=V;i++){
		
		k=0;
		if(visited[i]==true||isValid[i]==false)continue;
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(i);
		visited[i] = true;
		 k++;
		//num[index]=i;index++;
		//.out.print("\n"+i + " ");
		boolean check1=false,check2=false;
	    while(!stack.isEmpty()) {
		
			int top = stack.peek();    //not pop->we dont remove node from stack untilt its adj node are visited
			// check if the top element has any unvisited nodes
			int child = getNextUnvisitedChild(top, visited);
			if(child == -1) {
				// no more unvisited childs hence pop it
				int a=stack.pop();
				
			
				
			}else{	
			
			visited[child] = true;
			    if(isValid[child]==true)k++;
				stack.push(child);
				//num[index]=child;index++;
			//System.out.print(child + " ");
				}
				 
	    }
            
	
	if(k==1)k=0;
	k1+=k;
	}
	return k1;
	}	
		
	private int getNextUnvisitedChild(int v, boolean visited[]) {

		for(int i = 0; i < adj.get(v).size(); i++) {

				if(visited[adj.get(v).get(i)] == false) {
							return adj.get(v).get(i);
				}
		}
	return -1;
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
class Main{
public static void main(String[] args)throws Exception{

InputStream inputStream = System.in;
 OutputStream outputStream = System.out;
 FastReader in = new FastReader(inputStream);
 PrintWriter out = new PrintWriter(outputStream);


//String[] s=br.readLine().split(" ");
int n=in.nextInt();
int m=in.nextInt();

boolean[] isValid1=new boolean[n+1];boolean[] isValid2=new boolean[n+1];
Graph g=new Graph(n);
for(int i=1;i<=n;i++){
	if(in.nextInt()==1){isValid1[i]=true;isValid2[i]=true;}else{isValid1[i]=false;isValid2[i]=false;}
}
int v=0,u=0;
if(m==0){out.write("\n0 0");out.flush();return;}
for(int i=1;i<=m;i++){
	s=br.readLine().split(" ");
	u=Integer.parseInt(s[0]);
	v=Integer.parseInt(s[1]);
	g.addEdge(u,v);g.addEdge(v,u);
}
long ans1=g.dfs1(isValid1);
g.dfs2(isValid2);
long ans2=g.dfs3(isValid2);
if(ans2==1)ans2=0;
out.write("\n"+ans1+" "+ans2);out.flush();


}
}