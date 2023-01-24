import  java.util.ArrayList;

public class ReportEngine {
    OneSideOfMonth oneSideOfMonth = new OneSideOfMonth();
    OneSideOfYear oneSideOfYear = new OneSideOfYear();
    int profitByAllMothes = 0;
    int profitYear;

    public void readYear(){
        oneSideOfYear.strLineYear();
    }
    public void infoYear() {
        int SumProfit = 0;
        int SumExpense = 0;
        for (int i = 0; i < oneSideOfYear.Expenses.size(); i++) {
            SumProfit = SumProfit + oneSideOfYear.Expenses.get(i);
        }
        System.out.println(SumProfit + " - " + " Сумма рассходов за год");
        for (int i = 0; i < oneSideOfYear.Profit.size(); i++) {
            SumExpense = SumExpense + oneSideOfYear.Profit.get(i);
        }
        profitYear = SumExpense - SumProfit;
        System.out.println(SumExpense + " - " + "Сумма доходов за год");
        System.out.println("Общегодовая прибыль составила - " + profitYear);
    }

    public void readMonth() {
        oneSideOfMonth.strLineMonth();
    }
    public void infoMonth() {
        for (int i = 1; i <= 3; i++) {
            int sumProfit = 0;
            int sumExpnses = 0;
            int allMonthProfit = 0;
            ArrayList<MonthlyRepRec> monthlyData = (oneSideOfMonth.monthlyReport.get("resources/m.20210" + i + ".csv"));
            for (MonthlyRepRec dateMoth : monthlyData) {
                if (dateMoth.isExpenses) {
                    sumExpnses = sumExpnses + (dateMoth.suMofOne * dateMoth.quantitity);
                    System.out.println(dateMoth.itemName + " - расход");
                    System.out.println("колличество - "+dateMoth.quantitity );
                } else {
                    sumProfit = sumProfit + (dateMoth.quantitity * dateMoth.suMofOne);
                    System.out.println(dateMoth.itemName + " - доход");
                    System.out.println("колличество - "+dateMoth.quantitity );
                }

            }
            allMonthProfit = sumProfit - sumExpnses;
            profitByAllMothes = profitByAllMothes + allMonthProfit;
            System.out.println(sumExpnses + " - расход");
            System.out.println(sumProfit + " - доход");
            System.out.println(allMonthProfit + " - общая прыбыль за месяц " + " - "+ i);
            System.out.println();
        }
        System.out.println(profitByAllMothes + " - прыбыль за три месяца");
    }
    public void itemReport() {
        for (int i = 1; i <= 3; i++) {
            ArrayList<MonthlyRepRec> monthlyData = (oneSideOfMonth.monthlyReport.get("resources/m.20210" + i + ".csv"));
            for (MonthlyRepRec dateMoth : monthlyData) {
                if (dateMoth.isExpenses) {
                    System.out.println(dateMoth.itemName + " - расход");
                    System.out.println("колличество - "+dateMoth.quantitity );
                } else {
                    System.out.println(dateMoth.itemName + " - доход");
                    System.out.println("колличество - "+dateMoth.quantitity );
                }
            }
                System.out.println();
        }
    }
    public void compareMothToYear(){
        if (profitByAllMothes == profitYear){
                System.out.println("Общая сумма месячных отчетов и отчета за год сошлась");
                System.out.println(profitByAllMothes);
                System.out.println(profitYear);
            }else{
                System.out.println("Отчет не сошелся есть ошибки");
                System.out.println(profitByAllMothes);
                System.out.println(profitYear);
            }
    }
}

