package ru.homework.java_core1.lessons.lesson2;

public class ClassWork {
    public static void main(String[] args){
       // printSomethingIntoConsole();
       // printArgumentValueIntoConsole("Hello");
       // calcSomeExp(10.43, 10.57);
       // vendingWithIfs();
       // vendingWithSwitch();

        /* int counter = 1;

        while (counter < 21) {
            counter ++;
            if(counter % 3 == 0)continue;
            System.out.println(counter);
            if(counter == 10) break;
        } */
            int[] arr;
            arr = new int[5];
            arr[0] = 10;
            arr[1] = 20;
            arr[2] = 30;
            arr[3] = 40;
            arr[4] = 50;

            arr[1] = arr[1] + arr[4];

            int[] arr1 = {1,2,3,4,5,6,7,8,9};

        for(int a = 0, b = 10, c = 100; a < 10 && b > 0 && c > 10; a++, b--, c-=10){
            System.out.printf("a = %d, b = %d, c = %d\n ", a, b, c);
        }

    }

    public static void vendingWithSwitch(){

        int choice = 2;

        switch (choice) {
            case 1:
                case 8:
                    case 10:

                System.out.println("Give Lays");
                break;
            case 2, 43: {
                System.out.println("Give Cheetos");
                break;
            }
            case 3:
                System.out.println("Give Cola");
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    public static void vendingWithIfs(){

        int choice = 2;

        if (choice == 1) System.out.println("Give Lays");
            else if (choice == 2) System.out.println("Give Cheetos");
            else if (choice == 3) System.out.println("Give Cola");
            else System.out.println("Error");
    }
    public static void printSomethingIntoConsole() {
        System.out.println("kjhkhh");
    }

    public static void printArgumentValueIntoConsole(String word){
        System.out.printf("Your argument was: %s \n", word);
    }

    public static double calcSomeExp(double a, double b){
        double result = a + b;
      //  System.out.println("First value:" + a +   "; Second value:" + b +   "; result is:" + result);
      //  System.out.printf("First value: %f; Second value: %f; Result is: %f\n",a,b,result);

        String s = String.format("First value: %.02f; Second value: %f; Result is: %f\n",a,b,result);
        System.out.print(s);
        return result;
    }
}
