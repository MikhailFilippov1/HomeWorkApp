package ru.homework.java_core1.lessons.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class GameApp extends JPanel {

    private static int[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    static final int DOT_HUMAN = 1;
    static final int DOT_AI = 2;
    static final int DOT_EMPTY = 0;

    private int stateGameOver;
    private int winLength;
    private int cellWidth;
    private int cellHeight;
    private boolean isGameOver;
    private boolean isInitialized;
    private int gameMode;
    private int playerNumTurn;

    public GameApp() {
        isInitialized = false;
        int[][] field = new int[3][3];

        /*addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });*/

    }


    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!isCellValid(cellY, cellX) || !isCellEmpty(cellY, cellX)) {
            return;
        }
        field[cellY][cellX] = DOT_HUMAN;
        repaint();
        return;

        /*if (isGameOver || !isInitialized) {
            return;
        }
        if (!playerTurn(e)) {
            return;
        }
        if (gameCheck(DOT_HUMAN, STATE_WIN_HUMAN)) {
            return;
        }
        aiTurn();
        repaint();
        if (gameCheck(DOT_AI, STATE_WIN_AI)) {
            return;
        }*/
    }

    private boolean playerTurn(MouseEvent event) {

        int cellX = event.getX() / cellWidth;
        int cellY = event.getY() / cellHeight;



      if (!isCellValid(cellY, cellX) || !isCellEmpty(cellY, cellX)) {
            return false;
        }

        field[cellY][cellX] = DOT_HUMAN;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("|| %d ",field[i][j]);
            }
            System.out.println();
        }
        repaint();
        return true;
    }


    private boolean isCellValid(int y, int x) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private boolean isCellEmpty(int y, int x) {
        return field[y][x] == DOT_EMPTY;
    }

    public void startNewGame(int gameMode, int fieldSize, int winLength) {
        this.gameMode = gameMode;
        fieldSizeX = fieldSize;
        fieldSizeY = fieldSize;
        this.winLength = winLength;
        playerNumTurn = 1;
        field = new int[fieldSizeY][fieldSizeX];
        isInitialized = true;
        isGameOver = false;
        repaint();
    }
}
