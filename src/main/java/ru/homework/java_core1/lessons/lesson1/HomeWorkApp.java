package ru.homework.java_core1.lessons.lesson1;

public class HomeWorkApp {

    public static void main(String[] args){
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        // New commit
    }
        public static void printThreeWords(){
            System.out.println("Orange" + '\n' + "Banana" + '\n' + "Apple");
        }

        public static void checkSumSign(){
            int a = -10;
            int b = 2;
            int sum = a + b;
                if(sum >= 0){
                    System.out.println("Сумма положительная");
                } else{
                    System.out.println("Сумма отрицательная");
                }
        }

        public static void printColor(){
            int value = -2;
                if(value <= 0) System.out.println("Красный");
                    else if(value > 0 && value <= 100)System.out.println("Желтый");
                        else System.out.println("Зеленый");
        }

        public static void compareNumbers(){
            int a = 10;
            int b = 11;
                if(a >= b)System.out.println("a >= b");
                    else System.out.println("a < b");
        }
}
