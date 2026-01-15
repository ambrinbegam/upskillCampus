import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        while (true) {
            System.out.println("\n--- EXPENSE TRACKER ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Filter by Category");
            System.out.println("4. Monthly Report");
            System.out.println("5. Delete Expense");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Category: ");
                    String category = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    manager.addExpense(date, amount, category, desc);
                    break;

                case 2:
                    manager.viewExpenses();
                    break;

                case 3:
                    System.out.print("Enter Category: ");
                    manager.filterByCategory(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter Month (YYYY-MM): ");
                    manager.monthlyReport(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Expense ID: ");
                    manager.deleteExpense(sc.nextInt());
                    break;

                case 6:
                    System.out.println("Thank you for using Expense Tracker!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
