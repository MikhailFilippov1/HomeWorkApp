package ru.homework.java_core1.lessons.lesson6.zoo;

public abstract class Animal{
    final String name;

    public Animal(String name){
        this.name = name;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
