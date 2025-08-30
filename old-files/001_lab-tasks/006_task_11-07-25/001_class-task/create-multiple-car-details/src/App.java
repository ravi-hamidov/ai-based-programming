
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[3];

        for (int i = 0; i < cars.length; i++) {
            System.out.println("Car " + (i + 1) + ":");
            System.out.print("Enter brand: ");
            String brand = scanner.nextLine();

            System.out.print("Enter model: ");
            String model = scanner.nextLine();

            System.out.print("Enter year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            cars[i] = new Car(brand, model, year);
        }

        System.out.println("\n--- Car List ---");
        for (Car car : cars) {
            car.showDetails();
        }

        scanner.close();
    }
}
