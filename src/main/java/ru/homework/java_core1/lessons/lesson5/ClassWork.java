package ru.homework.java_core1.lessons.lesson5;

public class ClassWork {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.name = "Мурзик";
        cat1.color = "white";
        cat1.age = 4;

        System.out.println(cat1);
        System.out.println(cat1.name);
        System.out.println(cat1.color);
        System.out.println(cat1.age);

        Cat cat2  = new Cat("Барсик", "Черный", 2);
        System.out.println(cat2);
        System.out.println(cat2.name);
        System.out.println(cat2.color);
        System.out.println(cat2.age);

        cat1.run();
        cat2.run();
    }

}
