
public class App extends FindCustomer {
    public static void main(String[] args) {

        // 1.) String array ilə işləmək və dövrlərdən istifadə.
        // Verilmiş String massivindəki hər bir sətirin uzunluğunu tapın və bütün bu
        // uzunluqların cəmini hesablayıb ekrana çap edin.
        String[] words = { "Java", "programlashdirma", "dili", "arraylar" };
        System.out.println("Izah: " + "Java " + words[0].length() + ", " +
                "programlashdirma " + words[1].length() + ", " +
                "dili " + words[2].length() + ", " +
                "arraylar " + words[3].length() + ", " +
                "Massivdeki butun setirlerin uzunluqlari cemi: " + (words[0].length() + words[1].length() +
                        words[2].length() + words[3].length()));

        // 2. Bir Ölçülü Array Tapşırığı: Tərs Sıralama və Tək Ədədlərin Cəmi
        int[] numbers = { 5, 10, 15, 20, 25, 30 };
        System.out.println("\nOrjinal siralama: ");
        for (int elem : numbers) {
            System.out.print(elem + " ");
        }
        System.out.println("\nTers siralama: ");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\nTek ededlerin cemi: ");
        int pinset = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                pinset += numbers[i];
            }
        }
        System.out.println(pinset);

        // 3. 2D Massivdə Maksimum və Minimum Elementlərin Tapılması
        int[][] bachok = {
                { 15, 8, 22 },
                { 5, 31, 10 },
                { 40, 1, 18 }
        };

        int min = bachok[0][0];
        int max = bachok[0][0];
        for (int i = 0; i < bachok.length; i++) {
            for (int j = 0; j < bachok[i].length; j++) {
                if (bachok[i][j] < min) {
                    min = bachok[i][j];
                }
                if (bachok[i][j] > max) {
                    max = bachok[i][j];
                }
            }
        }
        System.out.println("Massivdeki minimum element: " + min);
        System.out.println("Massivdeki maksimum element: " + max);
    }
}
