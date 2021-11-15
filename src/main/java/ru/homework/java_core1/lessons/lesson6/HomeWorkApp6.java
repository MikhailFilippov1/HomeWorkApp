package ru.homework.java_core1.lessons.lesson6;

import ru.homework.java_core1.lessons.lesson6.zoo.Cat;
import ru.homework.java_core1.lessons.lesson6.zoo.Dog;
import ru.homework.java_core1.lessons.lesson6.zoo.Animal;

import java.util.Random;

public class HomeWorkApp6 {
    public static void main(String[] args) {
        final int numberOfDogs;
        final int numberOfCats;
        int widthOfRiver;
        int lengthOfRoad;

        Random random = new Random();
        numberOfDogs = random.nextInt(4);
        numberOfCats = random.nextInt(4);
        lengthOfRoad = random.nextInt(200);
        widthOfRiver = random.nextInt(50);

        System.out.printf("There are  %d dogs in you'r ZOO\n", numberOfDogs);
        System.out.printf("There are  %d cats in you'r ZOO\n", numberOfCats);
        System.out.println();

        Animal[] dogs = {           // В зоопарке всего 4 вольера для собак
                new Dog("Bobik"),
                new Dog("Tuzik"),
                new Dog("Barbos"),
                new Dog("Lobzik"),
        };
        Animal[] cats = {           // В зоопарке всего 4 вольера для кошек
                new Cat("Barsik"),
                new Cat("Vaska"),
                new Cat("Murzik"),
                new Cat("Murka"),
        };
        for (int i = 0; i < numberOfDogs; i++) {
            dogs[i].run(lengthOfRoad);
            dogs[i].swim(widthOfRiver);
        }

            for (int i = 0; i < numberOfCats; i++) {
                cats[i].run(lengthOfRoad);
                cats[i].swim(widthOfRiver);
            }
    }
}
