package ru.homework.java_core1.lessons.lesson8;

import javax.imageio.ImageIO;

public class TicTacToeGuiApp {

   // private static Image drop;
    //drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));

    public static void main(String[] args) {
        new GameWindow(3, 3);
    }
}
