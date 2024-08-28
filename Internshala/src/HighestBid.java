import java.util.Scanner;

public class HighestBid {
   public static void main(String s[]){
 Scanner scan = new  Scanner(System.in);
 System.out.println("Enter first bid ");
 int a = scan.nextInt();
       System.out.println("Enter Second bid ");
       int b = scan.nextInt();
       System.out.println("Enter Third bid ");
       int c = scan.nextInt();
       if (a>b  && a>c){
           System.out.println("Highest Bid "+a);
       }else if(b>c ){
           System.out.println("Highest Bid "+b);
       }
       else{
           System.out.println("Highest Bid "+c);
       }


   }
}
