import  java.util.ArrayList;

/*
    @author Andrey Panasiuk
    Git @AltairPhinArev
 */

public class ReportEngine {
    OneSideOfMonth oneSideOfMonth = new OneSideOfMonth();
    OneSideOfYear oneSideOfYear = new OneSideOfYear();
    int profitByAllMothes = 0;
    int midProfit;
    int midExpense;
    public void readYear() {
        oneSideOfYear.strLineYear();
    }

    public void infoYear() {
        int profByExp = 0;
        int allYearProfit = 0;
        int Profit = 0;
        int sumExpense = 0;
        System.out.println("Год 2021");
        for (int k = 0; k < oneSideOfYear.NumMonth.size(); k++) {
            Profit = oneSideOfYear.Profit.get(k) - oneSideOfYear.Expenses.get(k);
            allYearProfit = oneSideOfYear.Profit.get(k) + allYearProfit;
            sumExpense = sumExpense + oneSideOfYear.Expenses.get(k);
            System.out.println("Прибыль за месяц " + oneSideOfYear.NumMonth.get(k) + " составила - " + Profit);
        }
        profByExp = allYearProfit - sumExpense;
        midProfit = allYearProfit / oneSideOfYear.NumMonth.size();
        midExpense = sumExpense / oneSideOfYear.NumMonth.size();
        System.out.println("Общегодовая прибыль" + " - " + profByExp);
        System.out.println("Средний доход в году составил - " + midProfit);
        System.out.println("Средний расход в году составил - " + midExpense);
    }


    public void readMonth() {
        oneSideOfMonth.strLineMonth();
    }

    public void infoMonth() {
        for (int i = 1; i <= 3; i++) {
            String isExpItem = null;
            String isProfItem = null;
            int maxProfitItem = 0;
            int maxExpnseItem = 0;
            int sumProfit = 0;
            int sumExpnses = 0;
            int allMonthProfit = 0;
            ArrayList<MonthlyRepRec> monthlyData = (oneSideOfMonth.monthlyReport.get("resources/m.20210" + i + ".csv"));
            for (MonthlyRepRec dateMoth : monthlyData) {
                if (dateMoth.isExpenses) {
                    if (maxExpnseItem < (dateMoth.suMofOne * dateMoth.quantitity)) {
                        maxExpnseItem = dateMoth.quantitity * dateMoth.suMofOne;
                        isExpItem = dateMoth.itemName;
                    }
                    sumExpnses = sumExpnses + (dateMoth.suMofOne * dateMoth.quantitity);

                } else {
                    sumProfit = sumProfit + (dateMoth.quantitity * dateMoth.suMofOne);

                    if (maxProfitItem < (dateMoth.suMofOne * dateMoth.quantitity)) {
                        maxProfitItem = dateMoth.quantitity * dateMoth.suMofOne;
                        isProfItem = dateMoth.itemName;
                    }
                }

            }
            allMonthProfit = sumProfit - sumExpnses;
            profitByAllMothes = profitByAllMothes + allMonthProfit;
            System.out.println();
            System.out.println("Месяц - " + i);
            System.out.println(allMonthProfit + " - общая прыбыль за месяц ");
            System.out.println("Самая большая трата за месяц - " + isExpItem + ":" + maxExpnseItem);
            System.out.println("Самый прибыльный товар за месяц - " + isProfItem + ":" + maxProfitItem);
        }
        System.out.println(profitByAllMothes + " - прыбыль за три месяца");
    }

    public void compareMothToYear() {
        int sumExp = 0;
        int sumProf = 0;
        int monthSum;
        for (int i = 1; i <= 3; i++) {
            ArrayList<MonthlyRepRec> monthlyData = (oneSideOfMonth.monthlyReport.get("resources/m.20210" + i + ".csv"));
            for (MonthlyRepRec dateMoth : monthlyData) {
                if(dateMoth.isExpenses){
                    sumExp = sumExp + (dateMoth.suMofOne * dateMoth.quantitity);
                }else {
                    sumProf = sumProf + (dateMoth.suMofOne * dateMoth.quantitity);
                }
            }
            monthSum = sumProf - sumExp;
        }
        monthSum = sumProf - sumExp;
        int profByExpT = 0;
        int allYearProfit = 0;
        int Profit = 0;
        int sumExpense = 0;
        for (int k = 0; k < oneSideOfYear.NumMonth.size(); k++) {
            allYearProfit = oneSideOfYear.Profit.get(k) + allYearProfit;
            sumExpense = sumExpense + oneSideOfYear.Expenses.get(k);
        }
        profByExpT = allYearProfit - sumExpense;
        if (monthSum == profByExpT){
            System.out.println("Отчеты все сошлись , все траты верны");
            System.out.println(monthSum);
            System.out.println(profByExpT);
        }else{
            System.out.println("Отчеты не сошлись , ошибка в месеце ");
            System.out.println(monthSum);
            System.out.println(profByExpT);
        }
    }
}
