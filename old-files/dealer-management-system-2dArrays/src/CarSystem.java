
import java.util.Scanner;
public class CarSystem {

    private static Scanner scanner = new Scanner(System.in);
    private static CarDealership dealership = new CarDealership(10);

    public static void main(String[] args) {
        addInitialCars();
        while (true) {
            displayMenu(); // Menyunu ekrana çıxarırıq.
            System.out.print("Seçiminizi daxil edin: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // VACİB: nextInt()-dən sonra qalan "Enter" simvolunu təmizləmək üçün.

            // İstifadəçinin seçiminə uyğun əməliyyatı yerinə yetiririk.
            switch (choice) {
                case 1:
                    addNewCar();
                    break;
                case 2:
                    dealership.getAllCars();
                    break;
                case 3:
                    updatePrice();
                    break;
                case 4:
                    deleteCar();
                    break;
                case 5:
                    getCar();
                    break;
                case 0:
                    System.out.println("Sistemdən çıxılır... Sağ olun!");
                    scanner.close(); // Resurs sızmasının qarşısını almaq üçün scanner-i bağlayırıq.
                    return; // Proqramı sonlandırır.
                default:
                    System.out.println("XƏTA: Yanlış seçim etdiniz! Zəhmət olmasa, 0-4 arası bir rəqəm daxil edin.");
                    break;
            }
            System.out.println("\n----------------------------------\n");
        }
    }

    private static void displayMenu() {
        System.out.println("### AVTOSALON MENYUSU ###");
        System.out.println("1. Yeni maşın əlavə et");
        System.out.println("2. Bütün maşınları göstər");
        System.out.println("3. Maşının qiymətini yenilə");
        System.out.println("4. Maşını satışdan sil");
        System.out.println("5. Id ye gore axtaris");
        System.out.println("0. Çıxış");
    }
    private static void getCar(){
        System.out.println("Getirmek istewdiyiniz masinin id sini daxil edin:");
        int id = scanner.nextInt();
        Car car = dealership.findById(id);
        System.out.println((car==null) ? "Tapilmadi bele masin yoxdu" : "Tapildi  "+car.getModel()+" "+car.getBrand());

    }

    private static void addNewCar() {
        System.out.println("\n--- Yeni Maşın Əlavə Etmə ---");
        System.out.print("Marka: ");
        String brand = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("İstehsal ili: ");
        int year = scanner.nextInt();

        System.out.print("Mühərrik həcmi (məs: 2.5): ");
        double engine = scanner.nextDouble();

        System.out.print("Qiymət ($): ");
        double price = scanner.nextDouble();
        Car newCar = new Car(brand, model, year, engine, price);
        dealership.addCar(newCar);
    }

    private static void updatePrice() {
        System.out.println("\n--- Qiymət Yeniləmə ---");
        System.out.print("Qiymətini dəyişmək istədiyiniz maşının ID-sini daxil edin: ");
        int id = scanner.nextInt();

        System.out.print("Yeni qiyməti daxil edin ($): ");
        double newPrice = scanner.nextDouble();
        dealership.updateCarPrice(id, newPrice);
    }

    private static void deleteCar() {
        System.out.println("\n--- Maşını Silmə ---");
        System.out.print("Silmək istədiyiniz maşının ID-sini daxil edin: ");
        int id = scanner.nextInt();
        dealership.deleteCar(id);
    }

    private static void addInitialCars() {
        System.out.println("Test üçün ilkin maşınlar əlavə olunur...");
        dealership.addCar(new Car("Mercedes-Benz", "G-Class", 2024, 4.0, 250000));
        dealership.addCar(new Car("Toyota", "Prius", 2022, 1.8, 32000));
        dealership.addCar(new Car("BMW", "X5", 2023, 3.0, 95000));
        System.out.println("----------------------------------\n");
    }
}