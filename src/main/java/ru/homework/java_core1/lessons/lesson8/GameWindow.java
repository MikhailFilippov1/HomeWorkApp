package ru.homework.java_core1.lessons.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.TypeVariable;
import java.util.EventObject;

public class GameWindow extends JFrame {
    private GameApp gameApp;
    static String buttonChar = "X";

    public GameWindow(int x, int y){
        setSize(300, 300);
        setTitle("Крестики Нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setLayout(new GridLayout(x, y));

        for (int i = 0; i < x * y; i++) {
            JButton button = new JButton(/*(String.valueOf(i + 1))*/);
            add(button);
            //add(new JButton((String.valueOf(i + 1))));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                   if( ((JButton)actionEvent.getSource()).getText().equals("")) {
                        button.setFont(new Font("Arial", Font.BOLD, 60));
                        button.setText(buttonChar);
                        if(buttonChar == "O") buttonChar = "X";
                            else buttonChar = "O";
                    }
                }
            });
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

