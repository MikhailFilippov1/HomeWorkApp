package ru.homework.java_core1.lessons.lesson8_TicTacToeGUI;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 300;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Размер поля: ";
    private static final String WIN_LENGTH_PREFIX = "Длина победной строки: ";

    private JRadioButton humanVsAi;
    private JRadioButton humanVsHuman;
    private JSlider sliderWinLength;
    private JSlider sliderFieldSize;
    private GameWindow gameWindow;

    public SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(gameWindow);
        setResizable(false);
        setTitle("Установки новой игры");
        setLayout(new GridLayout(10, 1));
        addGameMode();
        addFieldSize();
        JButton btnStart = new JButton("Старт новой игры");
        btnStart.addActionListener(e -> submitSettings(gameWindow));
        add(btnStart);
    }

    private void addFieldSize() {
        JLabel labelFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel labelWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderWinLength = new JSlider(MIN_WIN_LENGTH, MAX_FIELD_SIZE, MIN_WIN_LENGTH);
        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = sliderFieldSize.getValue();
                labelFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                sliderWinLength.setMaximum(currentValue);
            }
        });
        sliderWinLength.addChangeListener(
                e -> labelWinLength.setText(WIN_LENGTH_PREFIX + sliderWinLength.getValue())
        );
        add(new JLabel("Выберите размер поля"));
        add(labelFieldSize);
        add(sliderFieldSize);
        add(new JLabel("Выберите длину победы"));
        add(labelWinLength);
        add(sliderWinLength);
    }

    private void addGameMode() {
        add(new JLabel("Выберите игру:"));
        humanVsAi = new JRadioButton("Игрок - Комп", true);
        humanVsHuman = new JRadioButton("Игрок1 - Игрок2");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humanVsAi);
        gameMode.add(humanVsHuman);
        add(humanVsAi);
        add(humanVsHuman);
    }

    private void submitSettings(GameWindow gameWindow) {
        int gameMode;
        if (humanVsAi.isSelected()) {
            gameMode = TicTacToeGameApp.MODE_VS_AI;
        } else {
            gameMode = TicTacToeGameApp.MODE_VS_HUMAN;
        }
        int fieldSize = sliderFieldSize.getValue();
        int winLength = sliderWinLength.getValue();
        gameWindow.startGame(gameMode, fieldSize, winLength);
        setVisible(false);
    }

}