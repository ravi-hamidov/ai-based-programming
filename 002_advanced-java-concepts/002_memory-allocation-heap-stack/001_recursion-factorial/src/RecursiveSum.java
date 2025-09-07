import java.util.Scanner;

public class RecursiveSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zehmet olmasa bir eded daxil et: ");
        int number = scanner.nextInt();
        if (number < 1) {
            System.out.println("Zehmet olmasa, 1 ve ya daha boyuk reqem daxil edin !");
        } else {
            int sum = calculateSum(number);
            System.out.println("1-den " + number + "-e qeder olan ededlerin cemi: " + sum);
        }
        scanner.close();
    }

    public static int calculateSum(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num + calculateSum(num - 1);
        }
    }
}
