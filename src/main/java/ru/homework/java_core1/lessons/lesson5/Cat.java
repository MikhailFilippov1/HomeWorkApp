package ru.homework.java_core1.lessons.lesson5;

public class Cat {
     String name;
     String color;
     int age;

    public Cat(){
        System.out.println("New CAT!!!");
    }

    public Cat(String color){
        this();
        this.color = color;
    }

    public Cat(String name, String color, int age){
        this(color);
        this.name = name;
       // this.color = color;
        this.age = age;
    }

    public void run(){
        System.out.printf("%s %s-colored run\n", this.name, this.color);
    }

    @Override
    public String toString(){
        return  String.format("Cat %s", color);
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

}
