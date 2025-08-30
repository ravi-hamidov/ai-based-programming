public class App {
    public static void main(String[] args) throws Exception {
        // Task 001 - Write a loop that prints numbers from 1 to 20, each on a new line
        for (int i = 0; i <= 20; i++) {
            System.out.println(i);
        }
        // Task 002 - Create a loop that prints all even numbers between 1 and 50.
        for (int j = 0; j <= 50; j++) {
            if (j % 2 != 0) {
                System.out.println(j);
            } else {
                continue;
            }
        }
        // Task 003 - Write a loop that prints the message “I am learning Java” 10 time
        for (int k = 0; k <= 10; k++) {
            System.out.println("I am learning Java");
        }
        // Task 004 - Generate a random number between 0 and 9 and print it.
        int randomNumber = (int) (Math.random() * 10);
        System.out.println("Random number is: " + randomNumber);
        // Task 005 - Use a loop to generate 10 random numbers between 1 and 100. Print each one.
        for (int i = 0; i < 10; i++) {
            int randomNum = (int) (Math.random() * 100) + 1;
            System.out.println("Random number " + (i + 1) + ": " + randomNum);
        }
        
    }
}
