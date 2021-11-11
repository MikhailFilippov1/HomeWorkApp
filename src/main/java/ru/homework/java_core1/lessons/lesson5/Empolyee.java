package ru.homework.java_core1.lessons.lesson5;

public class Empolyee {

    private String name;
    private String position;
    private String mail;
    private String phone;
    private int salary;
    private int age;

    public Empolyee(String name, String position, String mail, String phone, int salary, int age){
        this.name = name;
        this.position = position;
        this.mail = mail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

    }
    public void personDataPrint(){
        System.out.printf("Name: %s is %s with e-mail: %s phone number: %s. Salary: %d Age: %d\n",name, position,mail,phone,salary,age);
    }

    public int getAge(){
        return this.age;
    }


}


