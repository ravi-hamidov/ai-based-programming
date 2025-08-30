public class Technology extends Product {
    private int warrantyPeriod;

    public Technology(String name, double price, int warrantyPeriod) {
        super(name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void displayInfo() {
        System.out.println("Texnologiya Mehsulu: " + name);
        System.out.println("Zemanet Muddeti: " + warrantyPeriod + " il");
        System.out.println("Qiymet: $" + price);
    }
}
