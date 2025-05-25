import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new credit card object
        CreditCard card = new CreditCard("John Doe", "12/30", 0);

        int choice;

        do {
            System.out.println("\n--- Credit Card Menu ---");
            System.out.println("1. Show Card Details");
            System.out.println("2. Make Purchase");
            System.out.println("3. Make Payment");
            System.out.println("4. Lock Card");
            System.out.println("5. Unlock Card");
            System.out.println("6. Exit");
            System.out.println("------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println("------------------------");
            switch (choice) {
                case 1:
                    card.showCardDetails();
                    break;
                case 2:
                    if (card.isLocked()) {
                        System.out.println("Transaction failed: Card is locked.");
                    } else {
                        System.out.print("Enter purchase amount: ");
                        double purchase = scanner.nextDouble();
                        card.makePurchase(purchase);
                    }
                    break;
                case 3:
                    System.out.print("Enter payment amount: ");
                    double payment = scanner.nextDouble();
                    card.makePayment(payment);
                    break;
                case 4:
                    card.lock();
                    break;
                case 5:
                    card.unlock();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            System.out.println("-----------------------");
        } while (choice != 6);
        
        scanner.close();
        
    }
}