package ru.homework.java_core1.lessons.lesson5;

public class HomeWorkApp5 {

    public static void main(String[] args) {

        Empolyee[] personArr = new Empolyee[5];

        personArr[0] = new Empolyee("Jon Stainbeck", "writer", "no_mail", "no_phone", 1, 89);
        personArr[1] = new Empolyee("Charlie Chaplin", "actor", "no_mail", "no_phone", 100, 102);
        personArr[2] = new Empolyee("Greta Tunberg", "activist", "Greta@gmail.com", "+81425698824", 10000, 16);
        personArr[3] = new Empolyee("Jeff Bezos", "investor", "JB@yandex.ru", "+78128892345", 100000000, 47);
        personArr[4] = new Empolyee("Vinnie the Pooh", "bear", "vinnie@protonmail.ru", "no_phone", 10, 4);

        for (int i = 0; i < personArr.length; i++) {
            if(personArr[i].getAge() > 40) personArr[i].personDataPrint();
        }
    }
}
