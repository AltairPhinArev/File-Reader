import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.*;

public class OneSideOfYear {
    ArrayList<Integer> Expenses = new ArrayList<>();
    ArrayList<Integer> Profit = new ArrayList<>();
    ArrayList<Boolean> isExpenses = new ArrayList<>();
    ArrayList<Boolean> isProfit = new ArrayList<>();
    ArrayList<Integer> NumMonth = new ArrayList<>();

    void strLineYear() {
        List<String> lines = readFileContents("resources/y.2021.csv");
        for (String line : lines) {
            String[] lineContecst = line.split(",");
            if(!lineContecst[0].equals("month")) {
                int numMonth =Integer.parseInt(lineContecst[0]);
                int amont  = Integer.parseInt(lineContecst[1]);
                Boolean isExpense = Boolean.parseBoolean(lineContecst[2]);
                if (lineContecst[2].equals("false")) {
                    Profit.add(amont);
                    NumMonth.add(numMonth);
                    isProfit.add(isExpense);
                } else {
                    Expenses.add(amont);
                    isExpenses.add(isExpense);
                }
            }
        }
    }
    List<String> readFileContents (String path){
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }
}

