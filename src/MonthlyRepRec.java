import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MonthlyRepRec {

    String itemName;
    Integer quantitity;
    Boolean isExpenses;
    Integer suMofOne;
    public MonthlyRepRec(String[] lineContecst){
        itemName = lineContecst[0];
        isExpenses =Boolean.parseBoolean( lineContecst[1]);
        quantitity = Integer.parseInt(lineContecst[2]);
        suMofOne = Integer.parseInt(lineContecst[3]);
    }
}


