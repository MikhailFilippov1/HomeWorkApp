package ru.homework.java_core1.lessons.lesson8_TicTacToeGUI;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.MouseAdapter;
        import java.awt.event.MouseEvent;
        import java.util.Random;

public class TicTacToeGameApp extends JPanel {
    public static final int MODE_VS_AI = 0;
    public static final int MODE_VS_HUMAN = 1;
    public static final Random RANDOM = new Random();
    private static final int DOT_HUMAN = 1;
    private static final int DOT_AI = 2;
    private static final int DOT_EMPTY = 0;
    private static final int DOT_PADDING = 7;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private int stateGameOver;
    private int[][] field;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private int cellWidth;
    private int cellHeight;
    private boolean isGameOver;
    private boolean isInitialized;
    private int gameMode;
    private int playerNumTurn;


    public TicTacToeGameApp() {
        isInitialized = false;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
    }

    private void update(MouseEvent e) {
        if (isGameOver || !isInitialized) {
            return;
        }
        if (!playerTurn(e)) {
            return;
        }
        if (gameCheck(DOT_HUMAN, STATE_WIN_HUMAN)) {
            return;
        }
        if (gameMode == MODE_VS_AI) {
            aiTurn();
            repaint();
            if (gameCheck(DOT_AI, STATE_WIN_AI)) {
                return;
            }
        } else {
            playerTurn(e);
            if (gameCheck(DOT_AI, STATE_WIN_HUMAN)) {
                return;
            }
        }

    }

    private boolean playerTurn(MouseEvent event) {
        int cellX = event.getX() / cellWidth;
        int cellY = event.getY() / cellHeight;
        if (!isCellValid(cellY, cellX) || !isCellEmpty(cellY, cellX)) {
            return false;
        }
        if(gameMode == MODE_VS_AI){
            field[cellY][cellX] = DOT_HUMAN;
        } else if (gameMode == MODE_VS_HUMAN && playerNumTurn == 1) {
            field[cellY][cellX] = DOT_HUMAN;
            playerNumTurn = 2;
        }
            else {
            field[cellY][cellX] = DOT_AI;
            playerNumTurn = 1;
            }

        repaint();
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInitialized) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        cellWidth = width / fieldSizeX;
        cellHeight = height / fieldSizeY;
        g.setColor(Color.BLACK);

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellHeight;
            g.drawLine(x, 0, x, height);
        }
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) {
                    continue;
                }
                if (field[y][x] == DOT_HUMAN) {
                    //g.setColor(Color.GREEN);
                    g.drawLine(x * cellWidth, y * cellHeight, x * cellWidth + cellWidth, y * cellHeight + cellHeight);
                    g.drawLine(x * cellWidth + cellWidth, y * cellHeight, x * cellWidth , y * cellHeight + cellHeight);
                } else {
                    //g.setColor(Color.RED);
                    g.drawOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                }
            }
        }
        if (isGameOver) {
            showGameOverMessage(g);
        }
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

    private void showGameOverMessage(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, getHeight() / 2 - 60, getWidth(), 120);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Arial", Font.BOLD, 60));
        if(stateGameOver == STATE_WIN_HUMAN && gameMode == 0){
            g.drawString("?????????? ??????????????!", getWidth() / 8, getHeight() / 2);
        }
        else if(stateGameOver == STATE_WIN_HUMAN && playerNumTurn == 1){
            g.drawString("??????????2 ??????????????!", getWidth() / 8, getHeight() / 2);
        }
        else if(stateGameOver == STATE_WIN_HUMAN && playerNumTurn == 2){
            g.drawString("??????????1 ??????????????!", getWidth() / 8, getHeight() / 2);
        }
        else if(stateGameOver == STATE_DRAW){
            g.drawString("??????????", getWidth() / 6, getHeight() / 2);
        }
        else {
            g.drawString("???????? ??????????????!", getWidth() / 8, getHeight() / 2);
        }
    }

    private  boolean gameCheck(int dot, int stateGameOver) {
        if (checkWin(dot, winLength)) {
            this.stateGameOver = stateGameOver;
            isGameOver = true;
            repaint();
            return true;
        }
        if (checkDraw()) {
            this.stateGameOver = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }

        return false;
    }

    private boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) return false;
            }
        }
        return true;
    }


    private void aiTurn() {
        if (scanField(DOT_AI, winLength)) return;        // ???????????????? ???????????????? ??????????
        if (scanField(DOT_HUMAN, winLength)) return;    // ???????????????? ???????????????? ???????????? ???? ???????? ????????
        if (scanField(DOT_AI, winLength - 1)) return;
        if (scanField(DOT_HUMAN, winLength - 1)) return;
        if (scanField(DOT_AI, winLength - 2)) return;
        if (scanField(DOT_HUMAN, winLength - 2)) return;
        aiTurnEasy();
    }

    private void aiTurnEasy() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
        field[y][x] = DOT_AI;
    }

    private boolean scanField(int dot, int length) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) {                // ???????????????? ?????????? ?? ???????????? ???????????? ???????? ???? ??????????????
                    field[y][x] = dot;
                    if (checkWin(dot, length)) {
                        if (dot == DOT_AI) return true;    // ???????? ???????? ????????????????????, ???? ??????????????????
                        if (dot == DOT_HUMAN) {
                            field[y][x] = DOT_AI;            // ???????? ???????????????????? ?????????? ???????????? ???????? 0
                            return true;
                        }
                    }
                    field[y][x] = DOT_EMPTY;            // ???????? ?????????? ????????????, ???? ???????????????????? ?????? ????????
                }
            }
        }
        return false;
    }


    private boolean checkWin(int dot, int length) {
        for (int y = 0; y < fieldSizeY; y++) {            // ?????????????????? ?????? ????????
            for (int x = 0; x < fieldSizeX; x++) {
                if (checkLine(x, y, 1, 0, length, dot)) return true;    // ????????????????  ???? +??
                if (checkLine(x, y, 1, 1, length, dot)) return true;    // ???????????????? ???? ?????????????????? +?? +??
                if (checkLine(x, y, 0, 1, length, dot)) return true;    // ???????????????? ?????????? ???? +??
                if (checkLine(x, y, 1, -1, length, dot)) return true;    // ???????????????? ???? ?????????????????? +?? -??
            }
        }
        return false;
    }

    // ???????????????? ??????????
    private boolean checkLine(int x, int y, int incrementX, int incrementY, int len, int dot) {
        int endXLine = x + (len - 1) * incrementX;            // ?????????? ?????????? ???? ??
        int endYLine = y + (len - 1) * incrementY;            // ?????????? ???? ??
        if (!isCellValid(endYLine, endXLine)) return false;    // ?????????? ?????????? ???? ??????????????
        for (int i = 0; i < len; i++) {                    // ???????? ???? ??????????
            if (field[y + i * incrementY][x + i * incrementX] != dot) return false;    // ?????????????? ?????????????????????
        }
        return true;
    }

    private boolean isCellValid(int y, int x) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private boolean isCellEmpty(int y, int x) {
        return field[y][x] == DOT_EMPTY;
    }

}