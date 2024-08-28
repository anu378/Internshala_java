public class Main {
    public static void main (String s[]){
        Dog dog1 =new Dog();
        dog1.setBreed("German Sephered ");
        dog1.setHeight(50);
        dog1.setColour("Black");
        System.out.println(dog1.getBreed());
        System.out.println(dog1.getHeight(50));
        System.out.println(dog1.getColour());
dog1.bark();
dog1.run();
    }
}
