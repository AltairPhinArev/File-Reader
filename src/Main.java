import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
// Поехали!
public class Main {
    public static void main(String[] args) {

        ReportEngine repEn = new ReportEngine();
        Scanner sc = new Scanner(System.in);
        boolean checkMonButton = false;
        boolean checkYearButton = false;
        while (true) {
            printMenu();
            int i = sc.nextInt();
            if (i == 1) {
                repEn.readMonth();
                checkMonButton = true;
                System.out.println("Файл за месяц был успешно считан");
            } else if (i == 2) {
                repEn.readYear();
                checkYearButton = true;
                System.out.println("Файл был за год успешно считан");
            } else if (i == 3){
                    if (checkMonButton == true && checkYearButton == true){

                        repEn.compareMothToYear();
                    }else{
                        System.out.println("Для сверки отчетов нужно считать сразу два фвйла");
                    }
            } else if (i == 4) {
              if(checkMonButton == true) {
                  repEn.infoMonth();
                  System.out.println();

              }else {
                  System.out.println("Вы не считали месячные отчеты");
              }
            } else if (i == 5) {
                    if(checkYearButton == true){
                        repEn.infoYear();
                    }else {
                        System.out.println("Вы не считали годовой отчёт");
                    }
            } else if (i == 6) {
                System.out.println("Пока!");
                sc.close();
                return;
            } else {
                System.out.println("Извините такой команды нет");
            }
        }
    }

    static void printMenu() {
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("6 - Выход");
    }

}


