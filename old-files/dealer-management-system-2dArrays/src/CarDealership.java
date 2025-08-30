
import java.util.ArrayList;
import java.util.List;

public class CarDealership {

    private Car[] cars;
    private int carCount;

    public CarDealership(int capacity) {
        if (capacity > 0) {
            this.cars = new Car[capacity];
        } else {
            System.out.println("Anbar ölçüsü müsbət olmalıdır! Standart ölçü (10) təyin edildi.");
            this.cars = new Car[10];
        }
        this.carCount = 0;
    }

    public CarDealership() {

        this(10); // Yuxarıdakı konstruktoru capacity=10 parametri ilə çağırır.
    }

    //Id e gore Car obyektini tapir
    public Car findById(int id){
        for(int i = 0 ;i< carCount;i++){
            if(cars[i].getId()==id){
                return cars[i];
            }
        }
        return null;
    }


    // Butun datani print edir
    public void getAllCars() {
        if (carCount == 0) {
            System.out.println("\nMƏLUMAT: Avtosalon hal-hazırda boşdur.");
            return;
        }

        System.out.println("\n--- Avtosalondakı Maşınların Siyahısı ---");
        for (int i = 0; i < carCount; i++) {
            System.out.println(cars[i]);
        }
        System.out.println("-----------------------------------------");
    }

    public void addCar(Car car){
        if(carCount >= cars.length){
            System.out.println("Salon doludur");
            return;
        }
        cars[carCount++]=car;
        System.out.println("Masin ugurla elave edildi: " + car.getBrand() + car.getModel());
    }


    public void deleteCar(int id) {
        Car car = findById(id);
        if (car == null) {
            System.out.println("Silmek istediyiniz avtomobil tapilmadi!");
            return;
        }
        Car[] backupCars = new Car[carCount - 1];
        int newIndex = 0;
        for (int i = 0; i < carCount; i++) {
            if (cars[i].getId() != id) {
                backupCars[newIndex] = cars[i];
                newIndex++;
            }
        }
        this.cars = backupCars;
        this.carCount--;

        System.out.println("UĞURLU: " + car.getBrand() + " " + car.getModel() + " (ID=" + id + ") salondan silindi.");
    }

    public void updateCarPrice(int id, double newPrice) {
        Car carToUpdate = findById(id);
        if (carToUpdate != null) {
            carToUpdate.setPrice(newPrice);
            System.out.println("UĞURLU: ID=" + id + " olan maşının qiyməti yeniləndi.");
        } else {
            // Maşın tapılmayıbsa, xəta veririk.
            System.out.println("XƏTA: Qiyməti yeniləmək üçün ID=" + id + " olan maşın tapılmadı.");
        }
    }
}