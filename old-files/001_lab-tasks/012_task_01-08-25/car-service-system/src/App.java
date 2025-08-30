
public class App {

    public static void main(String[] args) {
        // Avtomobil obyektleri
        Sedan sedan = new Sedan("Toyota", "Camry", 2020, 4);
        SUV suv = new SUV("Land Rover", "Discovery", 2022, true);
        Car ford = new Car("Ford", "Focus", 2018);

        System.out.println("--- Avtomobil Yaratma ve Melumat Gosterme ---");
        sedan.displayInfo();
        suv.displayInfo();
        ford.displayInfo();

        System.out.println();
        System.out.println("--- Servis Emeliyyatlari ---");
        ServiceCenter center = new ServiceCenter();
        center.registerService(sedan);
        center.registerService(suv);
        center.registerService(ford);

        Serviceable[] servisAvtomobilleri = {sedan, suv};
        double total = center.calculateTotalServiceCost(servisAvtomobilleri);
        System.out.println("Umumi servis qiymeti: " + total + " AZN.");
        System.out.println();

        // FOR loop ile avtomobil siyahisi
        System.out.println("--- Butun Avtomobillerin Melumati (FOR Dongusu ile Polimorfizm) ---");
        Car[] cars = {sedan, suv, ford};
        for (int i = 0; i < cars.length; i++) {
            cars[i].displayInfo();
        }

        System.out.println();
        System.out.println("--- Teker Tezyiqini Yoxlama (DO-WHILE Dongusu) ---");

        int attempts = 0;
        boolean pressureNormal = false;

        do {
            attempts++;
            System.out.println("Cehd #" + attempts + ": Teker tezyiqi yoxlanilir...");
            if (Math.random() > 0.5) {
                pressureNormal = true;
                System.out.println("Teker tezyiqi normaldir.");
            } else {
                System.out.println("Teker tezyiqi asagidir. Yeniden yoxlanilir...");
            }
        } while (!pressureNormal && attempts < 3);
    }
}
