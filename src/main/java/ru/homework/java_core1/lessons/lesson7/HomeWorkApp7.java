package ru.homework.java_core1.lessons.lesson7;

public class HomeWorkApp7 {

    public static void main(String[] args) {

        Cat[] cats = {
                new Cat("Barsik", 100, false ),
                new Cat("Vaska", 150, false ),
                new Cat("Murzik", 200, false)
        };

        var bowl = new Bowl();
        bowl.putFood(400);

        for (Cat cat : cats) {
            cat.eat(bowl);
        }
        System.out.println();
        for (Cat cat : cats) {
            if(cat.satiety == true){
                System.out.printf("Cat %s is satiety. Thanks.\n", cat.getName());
            } else {
                System.out.printf("Cat %s angry ang hungry. Sorry.\n", cat.getName());
            }
        }
    }
}
