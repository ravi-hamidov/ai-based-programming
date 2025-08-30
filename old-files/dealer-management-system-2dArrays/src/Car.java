public class Car {
    /**
     * Hər yeni Car obyekti üçün unikal ID təmin edən statik sayğac.
     * `static` olduğu üçün bu dəyişən bütün Car obyektləri üçün ortaqdır.
     */
    private static int nextId = 1;
    private int id;
    private String brand;
    private String model;
    private int year;
    private double engineVolume;
    private double price;

    //constructor obyekt yaradilarken ilk ise dusen methoddur
    public Car(String brand,String model, int year,double engineVolume, double price) {
        this.id = nextId++;
        this.brand = brand;
        this.engineVolume = engineVolume;
        this.model = model;
        this.price = price;
        this.year = year;
    }


    // Private fieldlerin dəyərini kənardan oxumağa imkan verir.
    public int getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getEngineVolume() { return engineVolume; }
    public double getPrice() { return price; }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("XƏTA: Qiymət müsbət ədəd olmalıdır!");
        }
    }

    @Override
    public String toString() {
        return "Car ID: " + id +
                " | Marka: " + brand +
                " | Model: " + model +
                " | İl: " + year +
                " | Mühərrik: " + engineVolume + "L" +
                " | Qiymət: $" + price;
    }
}