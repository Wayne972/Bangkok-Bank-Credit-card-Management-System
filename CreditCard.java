import java.util.Random;
import java.util.*;

public class CreditCard {
    private String cardHolderName;
    private String cardNumber;
    private String expiryDate;
    private int cvv;
    private double balance;
    private static double MAX_CREDIT_LIMIT = 50000;
    private boolean isLocked;

    // Default constructor
    public CreditCard() {
        this.cardHolderName = "Unknown";
        this.cardNumber = generateCardNumber(); // need to check repetition
        this.expiryDate = "12/30";
        this.cvv = generateCVV();
        this.balance = 0.0;
        this.isLocked=true;
    }

    // Overloaded constructor
    public CreditCard(String cardHolderName, String expiryDate, double balance) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = generateCardNumber();
        this.expiryDate = expiryDate;
        this.cvv = generateCVV();
        this.balance = balance;
    }

    // Method to generate random 16-digit card number
    private String generateCardNumber() {
        Random rand = new Random();
        List<String> parts = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int block = 1000 + rand.nextInt(9000);
            parts.add(String.valueOf(block));  // Convert int to String
        }

        return String.join("", parts);  // Join parts into one long string (no dashes or spaces)
    }

    // Method to generate 3-digit CVV
    private int generateCVV() {
        Random rand = new Random();
        return 100 + rand.nextInt(900);
    }

    // Getter and setter methods
    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String name) {
        this.cardHolderName = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public int getCVV() {
        return cvv;
    }

    public double getBalance() {
        return balance;
    }
    public void lock() {
        isLocked = true;
        System.out.println("Card is now locked.");
    }

    public void unlock() {
        isLocked = false;
        System.out.println("Card is now unlocked.");
    }

    public boolean isLocked() {
        return isLocked;
    }

    // Make a purchase
    public boolean makePurchase(double amount) {
        if (amount <= 0) return false;
        if (balance + amount > MAX_CREDIT_LIMIT) {
            System.out.println("Transaction declined: Over credit limit.");
            return false;
        }
        balance += amount;
        System.out.println("Purchase successful. New balance: " + balance);
        return true;
    }

    // Make a payment
    public void makePayment(double amount) {
        if (amount > 0) {
            balance -= amount;
            if (balance < 0) balance = 0;
            System.out.println("Payment successful. New balance: " + balance);
        } else {
            System.out.println("Invalid payment amount.");
        }
    }

    // Show card details (excluding sensitive data like CVV)
    public void showCardDetails() {
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Current Balance: " + balance);
    }
}