package ru.homework.java_core1.lessons.lesson7;

public class Cat {
    private String name;
    private int appetite;
    boolean satiety;        // сытость

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public void eat(Bowl bowl){
        if(bowl.getFoodAmount() >= appetite) {
            System.out.printf("Cat %s has ate for %d food\n", name, appetite);
            bowl.decreasedFood(appetite);
            this.satiety = true;
        }else {
            System.out.printf("Cat %s hasn't ate\n", name);
        }
    }

    public String getName() {
        return name;
    }
}
