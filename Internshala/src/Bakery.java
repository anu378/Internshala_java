
import java.util.ArrayList;
import java.util.List;
public class Bakery {
 public static void main(String s[]){
  cake1 c1 = new cake1();
  cake1 c2 = new cake1();
  c1.setName("Chocolate Brownie ");
  c1.setPrice(250);
  c2.setName("Chocolate Maple ");
  c2.setPrice(300);
  Pastry p1=new Pastry();
  Pastry p2=new Pastry();
  p1.setName("Black Forest");
  p1.setPrice(35);
  p2.setName("Choco Truffle ");
  p2.setPrice(40);
  List<cake1>cake1List=new ArrayList<cake1>();
  cake1List.add(c1);
  cake1List.add(c2);
  List<Pastry> PastryList = new ArrayList();
  PastryList.add(p1);
  PastryList.add(p2);

  System.out.println("       Today's Special Menu ");
  System.out.println("------------------------------------------");
  System.out.println("Special Cake");
  System.out.println("------------------------------------------");
  for (cake1 cak:cake1List)
       { cak.display();

  }
  System.out.println("------------------------------------------");
  System.out.println("Special Pastries");
  System.out.println("------------------------------------------");
  for (Pastry pastri:PastryList)
       { pastri.display();

  }


 }
}
