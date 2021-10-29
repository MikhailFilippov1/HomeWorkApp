package ru.homework.java_core1.lessons.lesson3;

import java.util.Arrays;

public class ClassWork {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(arr);

     //   MyArrayUtil.printArray(arr);
        int[][] arr1 = new int[3][];
        arr1[0] = new int[3];
        arr1[1] = new int[30];
        arr1[2] = new int[10];

        arr1[1][15] = 99;
        MyArrayUtil.printArray1(arr1);

      //  Arrays.deepEquals()
        int[] arr3 = MyArrayUtil.makeArrayWithRandomValues(15);
        MyArrayUtil.printArray(arr3);
    }
}
