/* package joney_001 */
import java.util.*;
import java.lang.*;
import java.io.*;
        import java.math.*;
class Main {

  public static void main(String[] args)throws Exception    {


       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
       String[] ss=br.readLine().split(" ");
       int n=Integer.parseInt(ss[0]);  int m=Integer.parseInt(ss[1]);
       int num[][]=new int[21][20001];
       for(int i=1;i<=m;i++){

                String[] s=br.readLine().split(" ");
                int n1=Integer.parseInt(s[0]);
                for(int j=1;j<=n1;j++){


                        int x=Integer.parseInt(s[j]);
                        num[i][x]=1;
                }

       }
       boolean check[][]=new boolean[21][21];
      for(int i=1;i<=m;i++){

        for(int j=1;j<=m;j++){

                if(i==j)continue;
                boolean ch=false;
                for(int k=1;k<=20000;k++){
                 if(num[i][k]==num[j][k]&&num[i][k]==1){ch=true;break;}
                 }
                check[i][j]=ch;check[j][i]=ch;
         }
                                                                                                                                                     
        }
      /*  for(int i=1;i<=m;i++){

        for(int j=1;j<=m;j++){
        	System.out.print(" "+check[i][j]);
        }
        System.out.println();
        }*/
        String s="";
        for(int i=1;i<=m;i++){
        s+=(""+i);
        }
//System.out.println(s);
                //String set="123";
                int nn=s.length();

// iterate over all the subsets
int max=-1;
for (int i=0; i < (1<<nn); i++)
{
    // generate the i-th subset
    Vector subset=new Vector();
    for (int k=0; k < nn; k++)
    {
        if ((i&(1<<k)) > 0)
            subset.add(s.charAt(k));
    }
    int[] arr=new int[21];
    // perform an action over the subset, here just print it
   //System.out.print("Subset "+i+":");
    int d=subset.size();
     for (int k=0; k<subset.size(); k++){
        arr[k+1]=Integer.parseInt(""+subset.get(k)+"");
     //   System.out.print(" "+arr[k+1]);
        }
    boolean c=false;
    for(int g=1;g<=d;g++){
        for(int h=1;h<=d;h++){
                if(g==h)continue;
                if(check[arr[g]][arr[h]]==true){c=true;break;}

        
        }
        if(c==true)break;
        
            }
            if(c==false){if(d>max)max=d; //System.out.print(" $"+max+"\n");
        }
  }
  if(max<=0)max=0;
out.write("\n"+max);out.flush();

   }

 }

                                                       

