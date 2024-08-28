public class Dog {
    private String Breed;
    private int height ;
    private String colour;
    public  void bark(){
        System.out.println("Woohh !! Woooh !! ");

    }
    public  void run(){
        System.out.println("My breed"+Breed+ "is running ");
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public int getHeight(int i) {
        return height;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
