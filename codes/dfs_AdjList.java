import java.util.ArrayList;
import java.util.Stack;

 class Graph {

private int V; // no of vertices
private ArrayList<ArrayList<Integer>> adj; // adjacency list

public Graph(int V) {

this.V = V;
this.adj = new ArrayList<ArrayList<Integer>>(V);
for(int i = 0; i < V; i++) {
this.adj.add(new ArrayList<Integer>());
}
}

public void addEdge(int u, int v) {

adj.get(u).add(v); // adding v to array list u
}

public void DFSIterative(int v) {

System.out.print("DFS Iterative --> ");
// use stack and visited array
boolean visited[] = new boolean[V];
for(int i = 0; i < visited.length; i++) {
visited[i] = false;
}

Stack<Integer> stack = new Stack<Integer>();
stack.push(v);
visited[v] = true;
System.out.print(v + " ");

while(!stack.isEmpty()) {

int top = stack.peek();
// check if the top element has any unvisited nodes
int child = getNextUnvisitedChild(top, visited);
if(child == -1) {
// no more unvisited childs hence pop it
stack.pop();
} else {
stack.push(child);
visited[child] = true;
System.out.print(child + " ");
}
}
System.out.println();
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
class Main{
public static void main(String[] args)throws Exception{

Graph g=new Graph(5);
g.addEdge(1,2);g.addEdge(2,5);g.addEdge(4,3);g.addEdge(5,1);
g.DFSIterative(1);

}
}import java.util.ArrayList;
import java.util.Stack;

 class Graph {

private int V; // no of vertices
private ArrayList<ArrayList<Integer>> adj; // adjacency list

public Graph(int V) {

this.V = V;
this.adj = new ArrayList<ArrayList<Integer>>(V);
for(int i = 0; i < V; i++) {
this.adj.add(new ArrayList<Integer>());
}
}

public void addEdge(int u, int v) {

adj.get(u).add(v); // adding v to array list u
}

public void DFSIterative(int v) {

System.out.print("DFS Iterative --> ");
// use stack and visited array
boolean visited[] = new boolean[V];
for(int i = 0; i < visited.length; i++) {
visited[i] = false;
}

Stack<Integer> stack = new Stack<Integer>();
stack.push(v);
visited[v] = true;
System.out.print(v + " ");

while(!stack.isEmpty()) {

int top = stack.peek();
// check if the top element has any unvisited nodes
int child = getNextUnvisitedChild(top, visited);
if(child == -1) {
// no more unvisited childs hence pop it
stack.pop();
} else {
stack.push(child);
visited[child] = true;
System.out.print(child + " ");
}
}
System.out.println();
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
class Main{
public static void main(String[] args)throws Exception{

Graph g=new Graph(5);
g.addEdge(1,2);g.addEdge(2,5);g.addEdge(4,3);g.addEdge(5,1);
g.DFSIterative(1);

}
}
