package ru.homework.java_core1.lessons.lesson3;

public class HomeWorkApp3 {
    public static void main(String[] args){

        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }

        int[] arr1 = new int[100];

        for (int i = 0; i < 100; i++) {
            arr1[i] = i + 1;
        }

        int[] arr2 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        for (int i = 0; i < arr2.length; i++) {
            if(arr2[i] < 6)arr2[i] *=2;
        }

        int[][] arr3 = new int[7][7]; // заполнение диагоналей 1-ками

        for (int i = 0; i < arr3.length; i++) {

            for (int j = 0; j < arr3[i].length; j++) {
                if(i == j)arr3[i][j] = 1;
                arr3[i][arr3[j].length - i - 1] = 1;
                }
            }

        int len = 10;
        int initialValue = 88;
        int arr5[] = new int[len];

        arr5 = someArray(len, initialValue);

        int arr6[] = {2, 9, 9, 6, -2, 22, -99, 31, 99, 7}; // вычисление максимума и минимума
        int arr6Max = arr6[0];
        int arr6Min = arr6[0];

        for(int i = 0; i < arr6.length; i++){
            if(arr6[i] > arr6Max)arr6Max = arr6[i];
            if(arr6[i] < arr6Min)arr6Min = arr6[i];
        }

        int arr7[] = {2, 2, -2, 1, 2, 2, 10, 3, 7, -5, 12};
        // int arr7[] = {2, 2};
        System.out.println(checkBalance(arr7));    // Вызов метода проверки баланса массива

        int arr8[] = {1, 2, 3, 4, 5};
        int m = 3;                  // Параметр на сколько сдвигать. Если -, то влево
        for (int i = 0; i < arr8.length; i++) {
            System.out.print(arr8[i] + " ");    //Печать исходного массива

        }System.out.println();

        arr8 = shiftArray(arr8, m);         // Вызов метода сдвига массива на m

        for (int i = 0; i < arr8.length; i++) {
            System.out.print(arr8[i] + " ");        //Печать массива со сдвинутыми ячейками
        }
    }




    public static int[] someArray(int arrayLength, int arrayValue){ //метод заполнения массива длиной Length значением Value
        int arr4[] = new int[arrayLength];
        for(int i = 0; i < arrayLength; i++)arr4[i] = arrayValue;
        return arr4;
    }

    public static boolean checkBalance(int array[]){ // метод,  сравнивающий суммы чмсел слева и справа
        int sumLeft = array[0];
        int sumRight = array[array.length - 1];
        int indexRight = array.length - 1;
        int indexLeft = 0;

        if(array.length == 1)return false;
        for (int i = 0; i < array.length; i++) {
            if(sumLeft == sumRight && (indexRight - indexLeft) <= 1 )return true;
                else if(sumLeft != sumRight && (indexRight - indexLeft) <= 1)return false; // выход с false для  массивов arr[2]
            if(sumLeft > sumRight) {
                sumRight += array[indexRight - 1];
                indexRight--;
            }
                else {
                sumLeft += array[indexLeft+1];
                indexLeft++;
            }
        }
        return false;
    }

    public static int[] shiftArray(int array[], int shift){ // Метод, сдвигающий на shift
        int popCell;
        if (shift > 0) {
            for (int j = 0; j < shift; j++) {
                popCell = array[array.length - 1];
                for (int i = array.length - 1; i > 0; i--) {
                    array[i] = array[i - 1];
                }
                array[0] = popCell;
            }
        }else {
            for (int j = 0; j < Math.abs(shift); j++) {
                popCell = array[0];
                for (int i = 0; i < array.length - 1; i++) {
                    array[i] = array[i + 1];
                }
                array[array.length - 1] = popCell;
            }
        }
        return array;
    }

}

