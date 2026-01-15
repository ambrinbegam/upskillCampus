import java.util.*;

public class ExpenseManager {

    private List<Expense> expenses;
    private int idCounter = 1;

    public ExpenseManager() {
        expenses = FileUtil.loadExpenses();
        if (!expenses.isEmpty()) {
            idCounter = expenses.get(expenses.size() - 1).getId() + 1;
        }
    }

    public void addExpense(String date, double amount, String category, String description) {
        Expense e = new Expense(idCounter++, date, amount, category, description);
        expenses.add(e);
        FileUtil.saveExpenses(expenses);
        System.out.println("Expense added successfully.");
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }
        for (Expense e : expenses) {
            System.out.println(e.getId() + " | " + e.getDate() + " | ₹" +
                    e.getAmount() + " | " + e.getCategory() + " | " + e.getDescription());
        }
    }

    public void filterByCategory(String category) {
        boolean found = false;
        for (Expense e : expenses) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                System.out.println(e.getId() + " | " + e.getDate() + " | ₹" + e.getAmount());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expenses found for this category.");
        }
    }

    public void monthlyReport(String month) {
        double total = 0;
        for (Expense e : expenses) {
            if (e.getDate().startsWith(month)) {
                total += e.getAmount();
            }
        }
        System.out.println("Total expense for " + month + " : ₹" + total);
    }

    public void deleteExpense(int id) {
        Iterator<Expense> it = expenses.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                FileUtil.saveExpenses(expenses);
                System.out.println("Expense deleted successfully.");
                return;
            }
        }
        System.out.println("Expense ID not found.");
    }
}
