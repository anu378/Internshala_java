public class SweepNum {
    public static void main(String s[]){
        int a= 24;
        int b= 43;
        System.out.println("Before");
        System.out.println("a: "+a + " "+  "b: "+b);
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("After");
        System.out.println("a: "+a +" "+ "b: "+b);
    }
}
