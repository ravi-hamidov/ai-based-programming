import java.util.Scanner;

public class VulkanikAdadanQacis {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int enerji = 100;
        int xal = 0;

        System.out.println("Vulkanik Adadan Qacis");
        System.out.println("Bir gun gizli adada oyanirsiniz... amma nese cox yanlisdir.");
        System.out.print("Adinizi daxil edin: ");
        String ad = input.nextLine();

        System.out.println("\nXos geldin, " + ad + "! Macera baslayir!");
        System.out.println("Hazir olun... Vulkan puskure biler!\n");

        // ZONA 1: Riyaziyyat Kanyonu
        System.out.println("ZONA 1: Riyaziyyat Kanyonu");
        System.out.print("Sual: 12 * 8 nece edir? ➤ ");
        int cavab1 = input.nextInt();
        if (cavab1 == 96) {
            System.out.println("Duzgun cavab! Xal +10");
            xal += 10;
        } else {
            System.out.println("Sehv cavab! Enerji -10");
            enerji -= 10;
        }

        // ZONA 2: Qaranliq Magara
        System.out.println("\nZONA 2: Qaranliq Magara");
        System.out.println("Magarani kecmek ucun 5 addim atmalisan...");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Addim " + i + "...");
            enerji -= 2;
        }
        xal += 5;
        System.out.println("Magarani kecdin! Enerji -10, Xal +5");

        // ZONA 3: Qiriq Korpu
        System.out.println("\nZONA 3: Qiriq Korpu");
        System.out.print("Iki yol var: [S]ol ve [S]ag. Hansini secirsin? ➤ ");
        char yol = input.next().toUpperCase().charAt(0);

        if (yol == 'S') {
            System.out.println("Tehlukesiz yol! Xal +10");
            xal += 10;
        } else {
            System.out.println("Teleye dustun! Enerji -20");
            enerji -= 20;
        }

        // ZONA 4: Vulkan Qapilari
        System.out.println("\nZONA 4: Vulkan Qapilari");
        int qapi;
        do {
            System.out.print("3 qapi var. 1, 2 ve 3. Dogru qapini tap! ➤ ");
            qapi = input.nextInt();

            switch (qapi) {
                case 1:
                    System.out.println("Qapi 1: Bos bir otaq. Enerji -5");
                    enerji -= 5;
                    break;
                case 2:
                    System.out.println("Qapi 2: Lava axini! Enerji -15");
                    enerji -= 15;
                    break;
                case 3:
                    System.out.println("Qapi 3: Tecili yardim helikopteri!");
                    xal += 15;
                    break;
                default:
                    System.out.println("Yanlis secim! Qapi yoxdur.");
                    enerji -= 5;
            }
        } while (qapi != 3);

        // NETICE
        System.out.println("\nOyun Sonu – " + ad);
        System.out.println("Enerji: " + enerji);
        System.out.println("Xal: " + xal);

        if (enerji > 50 && xal >= 30) {
            System.out.println("MOHTESEM QACIS! Qehreman kimi xilas oldun!");
        } else if (enerji > 0) {
            System.out.println("Zeyif qacis. Amma sag qaldin!");
        } else {
            System.out.println("Teessuf ki, vulkan seni uddu...");
        }

        System.out.println("\nTeshekkurler oynadigin ucun, " + ad + "!");

        input.close();
    }
}
