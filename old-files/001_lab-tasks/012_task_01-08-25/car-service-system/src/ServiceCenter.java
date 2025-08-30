
public class ServiceCenter {

    public void registerService(Serviceable vehicle) {
        System.out.println("--- Servis Qeydi ---");
        vehicle.performInspection();
        System.out.println("Servis Qiymeti: " + vehicle.calculateServiceCost() + " AZN.");
        System.out.println();
    }

    public double calculateTotalServiceCost(Serviceable[] vehicles) {
        double total = 0;
        for (Serviceable v : vehicles) {
            total += v.calculateServiceCost();
        }
        return total;
    }
}
