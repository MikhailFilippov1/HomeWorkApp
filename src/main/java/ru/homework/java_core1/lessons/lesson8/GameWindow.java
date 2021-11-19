package ru.homework.java_core1.lessons.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.TypeVariable;
import java.util.EventObject;

public class GameWindow extends JFrame {
    private GameApp gameApp;

    public GameWindow(int x, int y){
        setSize(300, 300);
        setTitle("Крестики Нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setLayout(new GridLayout(x, y));
        ActionListener listener = e -> {
            JButton lastButton = (JButton) e.getSource();
        };
        for (int i = 0; i < x * y; i++) {
            JButton button = new JButton();
            button.addActionListener(listener);
            add(button);
            // add(new JButton((String.valueOf(i + 1))));
        }
        gameApp = new GameApp();
        //SettingsWindow settings = new SettingsWindow(this);
        setVisible(true);

    }

    public void startGame(int gameMode, int fieldSize, int winLength) {
        gameApp.startNewGame(gameMode, fieldSize, winLength);
        System.out.printf("Mode: %d, Size: %d length: %d\n", gameMode, fieldSize, winLength);
    }

}

