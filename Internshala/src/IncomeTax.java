import java.util.Scanner;
public class IncomeTax {
public static long calculateTax(long  income){
    long Tax;
    if(income>=300000){
       Tax=(income*20)/100;
       return Tax;
    }else if(income>=100000){
        Tax=(income*10)/100;
        return Tax;
    }else{
        return 0;
    }
}
    public static void main(String s[]){

      System.out.println("Tax Calculator App ");
      System.out.println("----WELCOME---- ");
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter total person count ");
       int n;
               n= sc.nextInt();
      String[] name=new String[n];
      Long[] income =new Long[n];
      for(int counter=0;counter<n;counter++){
          System.out.println("Enter name:  " +(counter+1));
          name[counter]=sc.next();
          System.out.println("Enter " +name[counter]+"'s Annual Income:");
          income[counter]=sc.nextLong();
      }
      sc.close();
        System.out.println("Name with liable taxes ");
        System.out.println("-----------------------");


        for(int counter=0;counter<n;counter++){

            System.out.println(name[counter] +":" + "INR " +" " +calculateTax(income[counter]));
        }






  }
}