package ru.homework.java_core1.lessons.lesson2;
import java.util.Scanner;

public class HomeWorkApp2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(excersize1(10,20));

        printArgumentValueIntoConsole(-2);

        System.out.println(excersize2(10));

        printSomethingIntoConsole("Hello", 5);

        int year;
        System.out.println("\nПРОГРАММА ОПРЕДЕЛЕНИЯ ВИСОКОСНОГО ГОДА");


            do {
                System.out.println("Введите год:");
                year = scanner.nextInt();
                if (defineLeapYear(year) == true) System.out.println("Год високосный\n");
                else System.out.println("Год невисокосный\n");
            }while(exitCondition());
    }

    public static boolean excersize1(int a, int b){
        int result = a + b;
        if(result >= 10 && result <= 20)return true;
        else return false;
    }

    public static void printArgumentValueIntoConsole(int a){
        if(a >= 0)System.out.println("Число положительное");
            else System.out.println("Число отрицательное");
    }

    public static boolean excersize2(int a){
        if(a > 0)return false;
        else return true;
    }

    public static void printSomethingIntoConsole(String s, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(s);
        }
    }

    public static boolean defineLeapYear(int year) {
        int x;
        if(year %4 == 0) {
            x = year%100;
            if(year %400 == 0)return true;
                else if(x != 0)return true;
                    else return false;
        }
        else return false;
    }

    public static boolean exitCondition(){
        Scanner scanner = new Scanner(System.in);
        String s;
        char a;
        for(;;){
            System.out.print("Продолжить? [y/n]:");
            s = scanner.nextLine();
            a = s.charAt(0);
            if(a == 'y')return true;
                else if(a == 'n')return false;
            System.out.print('\r');
        }
    }
}
