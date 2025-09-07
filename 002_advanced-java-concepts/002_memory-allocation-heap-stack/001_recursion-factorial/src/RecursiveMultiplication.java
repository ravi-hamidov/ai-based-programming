import java.util.Scanner;

public class RecursiveMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zehmet olmasa eded daxil edin: ");
        int number = scanner.nextInt();
        long output = calculateMultiplication(number);

        if (output == -1) {
            System.out.println("Faktorial yalniz menfi olmayan ededler uchun hesablanir.");
        } else {
            System.out.println(number + "! = " + output);
        }
        scanner.close();
    }

    public static long calculateMultiplication(int num) {
        if (num < 0) {
            return -1;
        }

        if (num <= 1) {
            return 1;
        } else {
            return (long)num * calculateMultiplication(num - 1);
        }
    }
}
