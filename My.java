final class FastReader{
public static final FastReader SYSTEM_READER = new FastReader(System.in);
private final InputStream in;
private final byte[] buffer = new byte[1<<16];
private int pos, count;
public FastReader(InputStream in){
this.in = in;
pos = count = 0;
}
public int nextInt(){
int c;
while ((c = read()) < '0');
int result = c - '0';
while ((c = read() - '0') >= 0)
result = 10*result + c;
return result;
}
public String nextString(){
StringBuilder s = new StringBuilder();
int c;
while ((c = read()) >= 33)
s.append((char)c);
return s.toString();
}
private void fillBuffer(){
try{
count = in.read(buffer, pos = 0, buffer.length);
} catch (Exception e){}
}
public int read(){
if (pos == count)
fillBuffer();
return buffer[pos++];
}
} 