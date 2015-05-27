	/* package joney_000 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
	
 class Pair implements Comparable<Pair>{
	int x=0;
	int y=0;
	int f=0;
	public Pair(int x,int y, int f){
		this.x=x;
		this.y=y;
		this.f=f;
	}
	public int compareTo(Pair p){
	
		if(this.x==p.x)return this.y-p.y;
		return this.x-p.x;
	}
 }

 class Main

 {		
  public static void main(String[] args)throws Exception

    {                 

       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    
       // int tests=Integer.parseInt(br.readLine());
       // for(int t=0;t<tests;t++){
        	
        String[] s=br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);int m = Integer.parseInt(s[1]);int p = Integer.parseInt(s[2]);
        Pair[] pair=new Pair[p];Pair[] pair1=new Pair[p];
		for(int i=0;i<p;i++){
		
			 s=br.readLine().split(" ");
			pair[i] = new Pair(Integer.parseInt(s[0]),Integer.parseInt(s[1]),1);
				
		}
		Arrays.sort(pair);
		for(int i=0;i<p;i++){
			
				for(int j=i+1;j<p;j++){
					
					if(pair[i].x==pair[j].x && pair[i].y==pair[j].y && pair[i].f!=0){
								
									pair[i].f+=1;
									pair[j].f=0;
					}else{break;}				
				}
				
		}
		int next=0;
		for(int i=0;i<p;i++){if(pair[i].f>0){pair1[next]=pair[i];pair1[next].f=pair1[next].f+pair1[next].y;next++;}}
		p=next;
		//for(int i=0;i< p;i++){out.write("\n+"+pair1[i].x+" "+pair1[i].y+" "+pair1[i].f);out.flush();}
		
	int start=0;
		for(int i=1;i<=n;i++){
			int cost=(m-1);
	        int a=0,l=0;
	        if(m==1)cost=0;
			boolean check=true;
			for(int j=start;j<p;j++){
				
				if(i==pair1[j].x){
							start=findStart(pair1[j].x,pair1,start,p);//out.write("start=(i="+i+")="+start+"\n");
							if(pair1[j].y==1)a=pair1[j].f-pair1[j].y;
							if(pair1[j].y==m)l=pair1[j].f-pair1[j].y;
						//	out.write("a(i="+i+")="+a+"l=="+l+"\n");
							if(j<p-1 && pair1[j].x==pair1[j+1].x && pair1[j].f>pair1[j+1].f){check=false;cost=-1;break;}
							if(j<p-1 && pair1[j].x==pair1[j+1].x && pair1[j].y+1!=pair1[j+1].y){
														if(pair1[j].f>pair1[j].y+1){check=false;cost=-1;break;}
							}else if(j<p-1 && pair1[j].x!=pair1[j+1].x&&pair1[j].y<m && pair1[j].f>pair1[j].y+1){check=false;cost=-1;break;
							}else if(j==p-1 && pair1[j].y<m && pair1[j].f>pair1[j].y+1){check=false;cost=-1;break;
							}
				
				}else { break;}
				
			
			}
		if(check==true)cost=cost+l-a;
		if(m==1)cost=0;
		out.write(""+cost+"\n");out.flush();
			
		}	
		
	        
        //}
        }
		public static int findStart(int x,Pair[] pair1,int start,int p)throws Exception{
		
		for(int i=start;i<p;i++){
			if(pair1[i].x>x)return i;
			}
		return p-1;
		}
    }   
        
		