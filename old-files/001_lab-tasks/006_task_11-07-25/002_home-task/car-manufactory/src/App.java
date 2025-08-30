
public class App {

    public static void main(String[] args) {
        Manufacturer toyota = new Manufacturer("Toyota", 1937, "Japan");
        Manufacturer bmw = new Manufacturer("BMW", 1916, "Germany");

        Car car1 = new Car("Corolla", toyota, 2020, 1.8, "Petrol", 23.5);
        Car car2 = new Car("Camry", toyota, 2022, 2.5, "Hybrid", 31.7);
        Car car3 = new Car("X5", bmw, 2023, 3.0, "Diesel", 55.9);

        Car[] cars = {car1, car2, car3};

        System.out.println("=== Manufacturer Info ===");
        System.out.println(toyota);
        System.out.println(bmw);

        System.out.println("\n=== Car Catalog ===");
        for (Car car : cars) {
            System.out.println(car);
        }

        System.out.println("\n=== Diesel Cars ===");
        for (Car car : cars) {
            if (car.getFuelType().equalsIgnoreCase("Diesel")) {
                System.out.println(car);
            }
        }

        System.out.println("\n=== German Manufacturer Cars ===");
        for (Car car : cars) {
            if (car.getManufacturer().getCountry().equalsIgnoreCase("Germany")) {
                System.out.println(car);
            }
        }

        System.out.println("\n=== Luxury Cars (Price > $40K) ===");
        for (Car car : cars) {
            if (car.isLuxury()) {
                System.out.println(car);
            }
        }

        System.out.println("\n=== Most Expensive Car ===");
        Car mostExpensive = cars[0];
        for (Car car : cars) {
            if (car.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = car;
            }
        }
        System.out.println(mostExpensive);
    }
}
