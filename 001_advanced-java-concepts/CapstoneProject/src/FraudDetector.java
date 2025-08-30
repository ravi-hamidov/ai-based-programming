import java.time.Duration;
import java.util.*;

public class FraudDetector {
    private static final double HIGH_AMOUNT_THRESHOLD = 5000.0;
    private static final long SHORT_TIME_MINUTES = 60;

    public List<Transaction> detectFraud(List<Transaction> allTransactions) {
        Set<Transaction> fraudulentTransactions = new HashSet<>();

        for (Transaction transaction : allTransactions) {
            if (transaction.getAmount() > HIGH_AMOUNT_THRESHOLD) {
                fraudulentTransactions.add(transaction);
            }
        }

        Map<String, List<Transaction>> transactionsByUser = groupTransactionsByUser(allTransactions);

        for (List<Transaction> userTransactions : transactionsByUser.values()) {

            userTransactions.sort(Comparator.comparing(Transaction::getTimestamp));

            if (userTransactions.size() > 1) {
                for (int i = 0; i < userTransactions.size() - 1; i++) {
                    Transaction current = userTransactions.get(i);
                    Transaction next = userTransactions.get(i + 1);

                    long minutesBetween = Duration.between(current.getTimestamp(), next.getTimestamp()).toMinutes();
                    boolean isDifferentLocation = !current.getLocation().equals(next.getLocation());

                    if (minutesBetween < SHORT_TIME_MINUTES && isDifferentLocation) {
                        fraudulentTransactions.add(current);
                        fraudulentTransactions.add(next);
                    }
                }
            }
        }

        return new ArrayList<>(fraudulentTransactions);
    }

    private Map<String, List<Transaction>> groupTransactionsByUser(List<Transaction> transactions) {
        Map<String, List<Transaction>> map = new HashMap<>();
        for (Transaction t : transactions) {
            map.computeIfAbsent(t.getUserId(), k -> new ArrayList<>()).add(t);
        }
        return map;
    }
}
