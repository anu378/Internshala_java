import java.util.List;
import java.util.ArrayList;
public class Arraylist {
    public static void  main(String s[]){
        List<String> nameList=new ArrayList();
         //ArrayList<String> nameList =new ArrayList();
        nameList.add("Sum");
        nameList.add("Anuj ");
        nameList.add("Ayush");
        nameList.add("Rahul");
        //System.out.println(nameList.get(2));
        nameList.add(1,"Aditya");
        System.out.println(nameList.size());
        System.out.println(nameList.contains("Rahul"));
        System.out.println("STring name form last "+nameList.lastIndexOf("Ayush"));
       Object[] b= nameList.toArray();//use to convert in Array
        for (Object name:b) {
            System.out.println(name);
        }
        System.out.println(b.length);
        for (String name:nameList) {
            System.out.println(name);
        }
        Employee e1=new Employee("Albert");
        Employee e2=new Employee("Prel");
        Employee e3 =new Employee("KAmal");
        List<Employee> employeeList =new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);

        for (Employee employ:employeeList) {
            System.out.println(employ.name);

        }
    }
}
class Employee{
    String name;
    public Employee(String name){
        this.name =name;

    }
}