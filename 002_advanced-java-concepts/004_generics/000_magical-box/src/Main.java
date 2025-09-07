public class Main {

    public static void main(String[] args) {

        System.out.println("--- MagicBox<String> Testi ---");
        MagicBox<String> stringBox = new MagicBox<>();
        stringBox.store("Salam, Generics!");
        String retrievedString = stringBox.retrieve();
        System.out.println("Qutudan goturulen String: " + retrievedString);
        System.out.println();

        System.out.println("--- MagicBox<Integer> Testi ---");
        MagicBox<Integer> integerBox = new MagicBox<>();
        integerBox.store(123);
        int retrievedInt = integerBox.retrieve();
        System.out.println("Qutudan goturulen Integer: " + retrievedInt);
        System.out.println();

        System.out.println("--- MagicBox<Double> Testi ---");
        MagicBox<Double> doubleBox = new MagicBox<>();
        doubleBox.store(45.67);
        double retrievedDouble = doubleBox.retrieve();
        System.out.println("Qutudan goturulen Double: " + retrievedDouble);
        System.out.println();


        System.out.println("--- MagicBox<Boolean> Testi ---");
        MagicBox<Boolean> booleanBox = new MagicBox<>();
        booleanBox.store(false);
        boolean retrievedBoolean = booleanBox.retrieve();
        System.out.println("Qutudan goturulen Boolean: " + retrievedBoolean);
        System.out.println();

        System.out.println("--- Bonus: Icazesiz Tip Testi ---");
        System.out.println("String qutusuna Boolean yerlesdirmeye calisiriq...");
        // stringBox.store(true); // Xeta

        System.out.println("Compiler, String qutusuna Boolean yerlesdirmeyin qarsisini aldi!");
    }
}
