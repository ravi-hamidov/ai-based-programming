import java.util.Scanner;

public class FindCustomer {

    static String[] customerIds = { "101", "102", "103", "104", "105" };

    public static int findCustomer(String customerId) {
        for (int i = 0; i < customerIds.length; i++) {
            if (customerIds[i].equals(customerId)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Musteri ID-ni daxil edin: ");
        String id = scanner.nextLine();

        int index = findCustomer(id);

        if (index != -1) {
            System.out.println("Musteri tapildi. Indeks: " + index);
        } else {
            System.out.println("Musteri tapilmadi.");
        }

        scanner.close();
    }
}
