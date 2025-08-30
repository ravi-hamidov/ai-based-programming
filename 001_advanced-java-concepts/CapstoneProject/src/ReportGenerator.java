import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportGenerator {
    public void generateReport(List<Transaction> fraudulentTransactions, String outputPath) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String reportTime = LocalDateTime.now().format(formatter);
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath))) {
            writer.write("========================================\n");
            writer.write("       FIRILDAQCILIQ HESABATI\n");
            writer.write("========================================\n");
            writer.write("Hesabat Tarixi: " + reportTime + "\n");
            writer.write("Askarlanan Subheli Emeliyyatlarin Sayi: " + fraudulentTransactions.size() + "\n");
            writer.write("----------------------------------------\n\n");

            if (fraudulentTransactions.isEmpty()) {
                writer.write("Hec bir subheli emeliyyat askarlanmadi.\n");
            } else {
                int count = 1;
                for (Transaction t : fraudulentTransactions) {
                    writer.write("Emeliyyat #" + count++ + ":\n");
                    writer.write("  - Transaction ID: " + t.getTransactionId() + "\n");
                    writer.write("  - User ID: " + t.getUserId() + "\n");
                    // Meblegi 2 onluq reqemle formatlayiriq (meselen, 5000.00)
                    writer.write("  - Mebleg: " + String.format("%.2f", t.getAmount()) + " AZN\n");
                    writer.write("  - Zaman: " + t.getTimestamp().format(formatter) + "\n");
                    writer.write("  - Mekan: " + t.getLocation() + "\n\n");
                }
            }

            writer.write("========================================\n");
            writer.write("           HESABATIN SONU\n");
            writer.write("========================================\n");

            System.out.println("Hesabat ugurla yaradildi: " + outputPath);

        } catch (IOException e) {
            System.err.println("XETA: Hesabat faylini yazarken problem yarandi: " + e.getMessage());
        }
    }
}
