package ru.homework.java_core1.lessons.lesson3;

import java.util.Random;

public class MyArrayUtil {
    public static void printArray(int... arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void printArray1(int[][] arr1){
        for (int y = 0; y < arr1.length; y++){
            for (int x = 0; x < arr1[y].length; x++) {
                System.out.print(arr1[y][x]);
            }
            System.out.println();
        }
    }

    public static int[] makeArrayWithRandomValues(int length){
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();

        }
        return arr;
    }
    }

