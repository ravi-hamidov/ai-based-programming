import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String userHome = System.getProperty("C:/Users/ZenBook/Documents/GitHub/ai-based-programming/001_advanced-java-concepts/003_input-output-operations-file-handling/001_notepad-app");
        File noteDir = new File(userHome, "MyNotepadApp");

        if (!noteDir.exists()) {
            if (noteDir.mkdir()) {
                System.out.println("Qovluq yaradildi: " + noteDir.getAbsolutePath());
            } else {
                System.out.println("Qovluq yaradila bilmedi.");
                return;
            }
        } else {
            System.out.println("Qovluq artiq movcuddur: " + noteDir.getAbsolutePath());
        }

        LocalDate now = LocalDate.now();
        String fileName = "note_" + now + ".txt";
        File noteFile = new File(noteDir, fileName);

        System.out.println("Qeydler bu fayla yazilacaq: " + noteFile.getAbsolutePath());

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Qeyd daxil edin (cixmaq ucun 'exit'): ");
                String input = scanner.nextLine();

                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                appendToFile(noteFile.getAbsolutePath(), input);
            }
        }

        System.out.println("\n--- Bütün qeydlər ---");
        readAndPrintFile(noteFile.getAbsolutePath());
    }

    private static void appendToFile(String filePath, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(text);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Fayla yazarken xeta bas verdi: " + e.getMessage());
        }
    }

    private static void readAndPrintFile(String filePath) {
        try {
            Path path = Paths.get(filePath);

            if (Files.exists(path)) {
                List<String> allLines = Files.readAllLines(path);
                for (String line : allLines) {
                    System.out.println(line);
                }
            } else {
                System.out.println("Fayl bosdur ve ya tapilmadi.");
            }
        } catch (IOException e) {
            System.err.println("Fayli oxuyarken xeta bas verdi: " + e.getMessage());
        }
    }
}