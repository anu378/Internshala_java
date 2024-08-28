import java.util.Scanner;
public class StudentId {
    public static void main(String s[]) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int age = scan.nextInt();
        String bloodGroup = scan.next();
        System.out.println("---------------------------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("---------------------------------------------------");
        if (age >= 20) {
            System.out.println("Your group is RED");
        } else if (age >= 15 && age < 20) {
            System.out.println("Your group is BLUE");
        } else if (age >= 10 && age < 15) {
            System.out.println("Your group is Yellow ");

        } else {
            System.out.println("NA ");

        }
        System.out.println("---------------------------------------------------");
        scan.close();
    }
}