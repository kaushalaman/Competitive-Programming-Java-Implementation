public static Boolean funct(double[] arr) {
Integer count =0;
for(int i=0;i<arr.length; i++){
if(arr[i] < 2 ){
count++;
for(int j=i+1;j<arr.length; j++){
if(arr[j] < 2 && arr[i]+arr[j]< 2.0){
count++;
for(int x=j+1;x<arr.length; x++){
if(arr[i] < 2 ){
if(arr[i]+arr[j] + arr[x] <2.0 && arr[i]+arr[j] + arr[x] >= 1.0&& count ==2 ){
System.out.println(arr[i]);
System.out.println(arr[j]);
System.out.println(arr[x]);
x=arr.length;
return true;
}
}
}
j=arr.length;
}
}
i=arr.length;

}
}
return false;
}

//***************TEST EXAMPLE********************
public static void main(String[] args) {
double[] x={1,1.1,0.3,3,2,1,1,2,0.2,0.2,6,7};
Boolean b;
b=funct(x);
if(b == false)
System.out.println("Unable to find the sum of the triplet is in the range (1, 2)");

}
}
