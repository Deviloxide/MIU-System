import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("What would you like to do:");
            System.out.println("1. Generate Theorems (Only Valid if the initial theorem is " +
                    "valid)");
            System.out.println("2. Validate Theorem");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                MIUGenerator.main(args);
            } else if (choice == 2) {
                MIUSolver.main(args);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}