package app.ba.bean;
import java.time.LocalDate;
public class Transaction {

    private int transactionId;
    private LocalDate timestamp;
    private String description;
    private double amount;
    public Transaction() {
    }
    public Transaction(int transactionId, LocalDate timestamp, String description, double amount) {
        this.transactionId = transactionId;
        this.timestamp = timestamp;
        this.description = description;
        this.amount = amount;
    }
    public int getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    public LocalDate getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", timestamp=" + timestamp +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
