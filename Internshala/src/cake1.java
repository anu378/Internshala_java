public class cake1 {
    String name;
    float price;

    public String getName(String chocolate) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    void display(){
        System.out.println(name+":" +"INR"+ price + "per pound" );
    }
}
