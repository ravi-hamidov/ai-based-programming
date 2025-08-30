
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        int[] nums = new int[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 5 numbers:");

        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        for (int j = 0; j < nums.length; j++) {
            System.out.println("Number at index " + j + " is: " + nums[j]);
        }

        int sum = 0;
        for (int k = 0; k < nums.length; k++) {
            sum += nums[k];
            int average = sum / nums.length;
            System.out.println("average of numbers is " + average);
        }

        int min = nums[0];
        int max = nums[0];
        for (int l = 1; l < nums.length; l++) {
            if (nums[l] < min) {
                min = nums[l];
            }
            if (nums[l] > max) {
                max = nums[l];
            }

        }

        System.out.println("Minimum number is: " + min);
        System.out.println("Maximum number is: " + max);

        scanner.close();

    }
}
