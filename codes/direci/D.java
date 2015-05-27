class icpc_1{
     static InputStream is;
     private static byte[] inbuf = new byte[1024];
     static int lenbuf = 0, ptrbuf = 0;
     static String INPUT = "";

     public static void main(String args[])
    {

        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        java.io.PrintWriter out = new java.io.PrintWriter(System.out);
         int t=ni();
        while(t-->0)
        {
            //code here
            long s=ln();
            long e=ln();
            int n=ni();
            boolean flag=false;
            for(int i=0;i<n;i++)
            {
                long x=ln();
                long y=ln();
                if(x>s&&y<e)
                {
                    flag=true;
                }
            }
            if(flag)
            {
                out.println("NO");
            }
            else
                {out.println("YES");}

        }


            out.close();

    }

    private static String str()
            {
                char c[];
                    String num="" ;
                    int b;
                    while((b = readByte()) != -1 && !((b >= 'a' && b <= 'z')));
                            while(true){
                            if(b >= 'a' && b <= 'z'){
                                    num=num+(char)b;
                            }else{
                                    return num;
                            }
                            b = readByte();
                    }
            }
     private static int ni()
{
int num = 0, b;
boolean minus = false;
while((b = readByte()) != -1 && !((b >= '0' && b <= '9')|| b == '-'));
                if(b == '-'){
minus = true;
b = readByte();
}
while(true){
if(b >= '0' && b <= '9'){
num = num * 10 + (b - '0');
}else{
return minus ? -num : num;
}
b = readByte();
}
}
      private static long ln()
            {
                    long num = 0, b;
                    boolean minus = false;
                    while((b = readByte()) != -1 && !((b >= '0' && b <= '9')|| b == '-'));
                    if(b == '-'){
                            minus = true;
                            b = readByte();
                    }
                    while(true){
                            if(b >= '0' && b <= '9'){
                                    num = num * 10 + (b - '0');
                            }else{
                                    return minus ? -num : num;
                            }
                            b = readByte();
                    }
            }
     private static int readByte()
{
if(ptrbuf >= lenbuf){
ptrbuf = 0;
try { lenbuf = is.read(inbuf); } catch (IOException e) { }
if(lenbuf <= 0)return -1;
}
return inbuf[ptrbuf++];
}

}