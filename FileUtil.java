import java.io.*;
import java.util.*;

public class FileUtil {

    private static final String FILE_NAME = "expenses.txt";

    public static void saveExpenses(List<Expense> expenses) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                pw.println(e);
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses.");
        }
    }

    public static List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return expenses;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                expenses.add(new Expense(
                        Integer.parseInt(data[0]),
                        data[1],
                        Double.parseDouble(data[2]),
                        data[3],
                        data[4]
                ));
            }
        } catch (Exception e) {
            System.out.println("Error loading expenses.");
        }
        return expenses;
    }
}
