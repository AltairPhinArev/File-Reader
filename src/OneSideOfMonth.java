import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class OneSideOfMonth {
    HashMap<String, ArrayList<MonthlyRepRec>> monthlyReport  = new HashMap<>();

    void strLineMonth() {
        List<String> line = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            line = readFileContents("resources/m.20210" + i + ".csv");
            ArrayList<MonthlyRepRec> moNth = new ArrayList<>();
            for (int j = 1; j < line.size(); j++ ) {
                String[] lineContecst = line.get(j).split(",");
                MonthlyRepRec monthlyRepRec = new MonthlyRepRec(lineContecst);
                moNth.add(monthlyRepRec);
            }
            monthlyReport.put("resources/m.20210" + i + ".csv" , moNth);
        }
    }

    List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();

        }
    }

}
