import java.io.*;
import java.lang.*;
import java.util.*;

class Pair {
	public int s,l;
	public Pair(){s=0;l=0;}
	public Pair(int s , int l){
		this.s=s;
		this.l=l;
	}

	public static void main(String[] args)throws Exception{
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out),5000);
	int sort[] =new int[1000001];
	int tests = Integer.parseInt(br.readLine());
	int arr[][]=new int[1001][1001];
	int p[] = new int[1001];
	boolean[] isVisited = new boolean[1001]; 
	LinkedList[] ll = new LinkedList[1001];
	Pair [] pair = new Pair[1001];
	for(int i=0;i<=1000;i++){
		pair[i]=new Pair();
		ll[i]=new LinkedList<Integer>();
		
	}
	int mul[][]=new int[1001][1001];
	for(int i=1;i<=1000;i++){
	
	for(int j=1;j<=1000;j++){
		mul[i][j]=i*j;
	}
	}
	for(int t=0;t<tests;t++){
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);int m = Integer.parseInt(s[1]);
		
		
		
		s = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			p[Integer.parseInt(s[i])]=i;
			isVisited[i]=false;
		}
		//checking validity
		if(n<=2||m<=2){
			if(t!=tests-1){out.write("No Solution\n");out.flush();}else{out.write("No Solution");out.flush();}
			continue;
		}
		//checking loops;
		int st=0;
		boolean ch = true;
		for(int i=0;i<n;i++){
			int cnt=1;
			if(isVisited[i])continue;
			
			isVisited[i]=true;
			st = i;
			//isVisited[st]=true;
			while(i!=p[st]){
				st = p[st];
				cnt++;
				isVisited[st]=true;
			}
			if(cnt<=2){
			ch=false;
			break;
			}
		}
		if(!ch){
			if(t!=tests-1){out.write("No Solution\n");out.flush();}else{out.write("No Solution");out.flush();}
			continue;
		}	
		for(int i=0;i<n;i++){
			isVisited[i]=false;
		}
		for(int i=0;i<=1000000;i++)sort[i]=-1;
		int goal = ((m*m)/2)+1;
		int a=1,b=1;
		int min=100000000;
		for(int i=1;i<=m;i++){
			for(int j=1;j<=m;j++){
			if(mul[i][j]<goal)continue;
			if(mul[i][j]-goal<min){min=mul[i][j]-goal; if(i<j){a=i;b=j;}else{a=j;b=i;}}
			}
		}
		//out.write("a="+a+"b="+b);out.flush();
		//out.write("goal="+goal);out.flush();
		
		//start gready
		LinkedList<Integer> temp1 = new LinkedList();
		LinkedList<Integer> temp2 = new LinkedList();
		int count[] = new int[n];
		int start = 1; int end = n*m;int temp3=0;
		st=0;
		for(int i=0;i<n;i++){
			
			if(isVisited[i])continue;
			isVisited[i]=true;
			temp1.add(i);
			st = i;
			pair[i].s=m-a;
			pair[i].l=a;
			
			//isVisited[st]=true;
			while(i!=p[st]){
				int remain = goal-m*pair[st].s;
				if(remain>0){
					int x=0;
					int y=0;
					while(remain>y){
						
						y = pair[st].l*x;
						x++;
					}
					
					pair[p[st]].l =x-1;
					
				}else pair[p[st]].l=0;
				
				pair[p[st]].s=m-pair[p[st]].l;
				
				st = p[st];
				isVisited[st]=true;
				temp1.add(st);
			}
			temp3 = start+(m*temp1.size())-1; 
			while(!temp1.isEmpty()){
					
				int pos = (int)temp1.poll();
				//out.write("\n pos"+pos);out.flush();
				temp2.add(pos);
				for(int j=1;j<=pair[pos].s;j++){
					
					ll[pos].add(start);
					//out.write("\nstart="+start);out.flush();
					start++;
				}
			
			}
			
		//	out.write("asdasd");out.flush();
			start = temp3+1;
			while(!temp2.isEmpty()){
					
				int pos = temp2.pollLast();
				
				for(int j=1;j<=pair[pos].l;j++){
					
					ll[pos].add(temp3);
					temp3--;
				}
			
			}
			
			
			
		}
		//for(int i=0;i<n;i++){
		//	out.write("\ns="+pair[i].s+" l="+pair[i].l);out.flush();
		//}
		for(int i=0;i<n;i++){
			for(int j=1;j<=m ;j++){ sort[(int)ll[i].poll()]=i;
			  //if(j!=m){out.write(""++" ");out.flush();}else{out.write(""+ll[i].poll()+"");out.flush();}
			}
			//out.write("\n");out.flush();
		}
		
		for(int i=1;i<=m*n;i++){
			if(sort[i]!=-1){arr[sort[i]][count[sort[i]]]=i;count[sort[i]]++;}
		}
		
		for(int i=0;i<n;i++){
			for(int j=1;j<=m ;j++){
			  if(j!=m){out.write(""+arr[i][j-1]+" ");}else{out.write(""+arr[i][j-1]+"");}
			}
			out.write("\n");
		}
		out.flush();
	}
	}
}