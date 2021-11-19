package ru.homework.java_core1.lessons.lesson6.zoo;

public class Cat extends Animal{
    final int maxDistanceForRun = 20;
    final int maxDistanceForSwim = 1;

    public Cat(String name){
        super(name);
    }

    public void run(int distance) {
        if (distance < maxDistanceForRun) {
            System.out.printf("%s run succesfully %d meters!\n", name, distance);
        } else {
            System.out.printf("%s too tired and can't run %d meters. Sorry.\n", name, distance);
        }
    }

    public void swim(int distance){
        if (distance < maxDistanceForSwim) {
            System.out.printf("%s swim succesfully %d meters!\n", name, distance);
        } else {
            System.out.printf("%s can't swim %d meters and drowned.\n", name, distance);
        }
    }

}
