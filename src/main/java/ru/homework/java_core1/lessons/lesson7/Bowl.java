package ru.homework.java_core1.lessons.lesson7;

public class Bowl {
    private int foodAmount;

    public void putFood(int amount){
        this.foodAmount += amount;
        System.out.printf("Food increased by %d pts, there is now %d\n", amount, foodAmount);
    }

    public void decreasedFood(int amount){
        this.foodAmount -= amount;
        System.out.printf("Food decreased by %d pts, there is now %d\n", amount, foodAmount);
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
