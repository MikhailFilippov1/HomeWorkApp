package ru.homework.java_core1.lessons.lesson4;

import java.util.Scanner;

public class TicTacToeGame {

    static char DOT_X = 'X';
    static char DOT_O = 'O';
    static char DOT_EMPTY = '.';
    private static char dotHuman;
    private static char dotAi;
    private static final Scanner scanner = new Scanner(System.in);
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int scoreHuman;
    private static int scoreAi;
    private static int roundCounter;
    private static int winLength;

    public static void main(String[] args) {
        play();
    }

    private static void play(){
        while (true) {
            chooseTheDot();
            playRound();
            System.out.printf("ТЕКУЩИЙ СЧЁТ: Человек    Компьютер\n" +
                    "                 %d          %d\n", scoreHuman, scoreAi);
            if (!exitCondition()) {
                System.out.print("ИГРА ЗАКОНЧЕНА! До следующих встреч!");
                break;
            }
        }
    }

    private static void playRound(){
        System.out.printf("РАУНД %d НАЧИНАЕТСЯ!\n", ++roundCounter);
        initField(3, 3);
        printField();
        if(dotHuman == DOT_X)humanFirstTurn();
        else aiFirstTurn();
    }

    private static void humanFirstTurn(){
        while (true) {
            humanTurn();
            printField();
            if(checkGame(dotHuman)) break;
            aiTurn();
            printField();
            if(checkWin(dotAi)) break;
        }
    }

    private static void aiFirstTurn(){
        while (true) {
            aiTurn();
            printField();
            if(checkGame(dotAi)) break;
            humanTurn();
            printField();
            if(checkGame(dotHuman)) break;

        }
    }

    private static void chooseTheDot(){
        System.out.print("ХОЧЕШЬ ХОДИТЬ ПЕРВЫМ? НАЖМИ Х >>>");
        if(scanner.next().toLowerCase().equals("x")){
            dotHuman = DOT_X;
            dotAi = DOT_O;
        }else{
            dotHuman = DOT_O;
            dotAi = DOT_X;
        }
    }

    private static boolean checkGame(char dot) {
        if (checkWin(dot)){
            if (dot == dotHuman) {
                System.out.println("Победа человеческого разума!");
                scoreHuman++;
            } else {
                System.out.println("Поражение человеческого разума!");
                scoreAi++;
            }
        return true;
    }
        if(checkDraw()) return true;
        return false;
    }

    private static void humanTurn(){
         int x;
         int y;

         do {
             System.out.print("Введите координаты своего хода x и y через пробел >>>");
             x = scanner.nextInt() - 1;
             y = scanner.nextInt() - 1;
         }while (!isCellValid(y, x) || !isCellEmpty(y, x));

        field[y][x] = dotHuman;
    }

    private static void aiTurn(){
        int x;
        int y;
        winLength = 0;

        if(isCellEmpty(fieldSizeX%2, fieldSizeY%2)){      // Проверка центра
            field[fieldSizeX%2][fieldSizeY%2] = dotAi;
            return;
        }
        for (int i = 0; i < fieldSizeY; i++) { // проверка горизонталей на 2 своих фишки
            for (int j = 0; j < fieldSizeX; j++) {
                if(field[i][j] == dotAi)winLength++;

                if(winLength == 2) {
                    for (int k = 0; k < fieldSizeX; k++) {
                        if(isCellEmpty(i, k)) {
                            field[i][k] = dotAi;
                            return;
                        }
                    }
                }
            }
            winLength = 0;
        }
        winLength = 0;
        for (int i = 0; i < fieldSizeX; i++) {  // проверка вертикалей на 2 своих фишки
            for (int j = 0; j < fieldSizeY; j++) {
                if(field[j][i] == dotAi)winLength++;
                    if(winLength == 2) {
                        for (int k = 0; k < fieldSizeY; k++) {
                            if(isCellEmpty(k, i)) {
                                field[k][i] = dotAi;
                                return;
                            }
                        }
                    }
            }
            winLength = 0;
        }
        winLength = 0;
        for (int i = 0; i < fieldSizeY; i++) { // Проверка горизонталей на 2 фишки человека
            for (int j = 0; j < fieldSizeX; j++) {
                if(field[i][j] == dotHuman) winLength++;
            }
            if(winLength == 2){                 // В i-ой линии две фишки человека
                for (int j = 0; j < fieldSizeX; j++) {
                    if(field[i][j] == DOT_EMPTY) {
                        field[i][j] = dotAi;        // ставим третью фишку компьютера
                       return;
                    }
                }
            }
            winLength = 0;
        }
        winLength = 0;
        for (int i = 0; i < fieldSizeX; i++) { // Проверка вертикалей на 2 фишки человека
            for (int j = 0; j < fieldSizeY; j++) {
                if(field[j][i] == dotHuman) winLength++;
            }
            if(winLength == 2){                 // В i-ой линии две фишки человека
                for (int j = 0; j < fieldSizeY; j++) {
                    if(field[j][i] == DOT_EMPTY){
                        field[j][i] = dotAi;        // ставим третью фишку компьютера
                       return;
                    }
                }
            }
            winLength = 0;
        }
        if(isCellEmpty(0, 0)){          // Проверка углов и заполнение одного из них
            field[0][0] = dotAi;
            return;
        }
            else if (isCellEmpty(0,fieldSizeX - 1)){    // Правый верхний угол
                field[0][fieldSizeX - 1] = dotAi;
                return;
            }
                else if(isCellEmpty(fieldSizeY - 1,0)){     // Левый нижний угол
                    field[fieldSizeY - 1][0] = dotAi;
                    return;
                }
                    else if(isCellEmpty(fieldSizeY - 1, fieldSizeX - 1)){   // Правый нижний угол
                        field[fieldSizeY - 1][fieldSizeX - 1] = dotAi;
                        return;
                    }

        for (int i = 0; i < fieldSizeY; i++) { // Заполнение первого попавшегося пустого поля
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == DOT_EMPTY) {
                    field[i][j] = dotAi;
                    return;
                }
            }
        }
    }

    private static boolean checkWin(char dot){
       winLength = 0;
        for (int i = 0; i < fieldSizeY; i++) {      // Проверка горизонталей
            for (int j = 0; j < fieldSizeX; j++) {
                if(field[i][j] == dot)winLength++;
                if(winLength == fieldSizeX)return true;
            }
            winLength = 0;
        }
        winLength = 0;
        for (int i = 0; i < fieldSizeX; i++) {      // Проверка вертикалей
            for (int j = 0; j < fieldSizeY; j++) {
                if(field[j][i] == dot)winLength++;
                if(winLength == fieldSizeY)return true;
            }
            winLength = 0;
        }
        winLength = 0;
        for (int i = 0; i < fieldSizeY; i++) {     // Проверка диагоналей
            for (int j = 0; j < fieldSizeX; j++) {
                if(i == j && field[i][j] == dot)winLength++;
            }
            if(winLength == fieldSizeX)return true;
        }
        winLength = 0;
        for (int i = 0; i < fieldSizeY; i++) {     // Проверка диагоналей
            for (int j = 0; j < fieldSizeX; j++) {
                if(i + j + 1 == fieldSizeX && field[i][j] == dot)winLength++;
            }
            if(winLength == fieldSizeX)return true;
        }

        /*if(field[0][0] == dot && field[0][1] == dot && field[0][2] == dot) return true;
        if(field[1][0] == dot && field[1][1] == dot && field[1][2] == dot) return true;
        if(field[2][0] == dot && field[2][1] == dot && field[2][2] == dot) return true;

        if(field[0][0] == dot && field[1][0] == dot && field[2][0] == dot) return true;
        if(field[0][1] == dot && field[1][1] == dot && field[2][1] == dot) return true;
        if(field[0][2] == dot && field[1][2] == dot && field[2][2] == dot) return true;

        if(field[0][0] == dot && field[1][1] == dot && field[2][2] == dot) return true;
        if(field[0][2] == dot && field[1][1] == dot && field[2][0] == dot) return true;*/
        return false;
        }

    private static boolean checkDraw(){
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if(isCellEmpty(i, j))return false;
            }
        }
        System.out.println("Ничья!");
        return true;
    }

    private static boolean isCellValid(int y, int x){
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private static boolean isCellEmpty(int y, int x){
        return field[y][x] == DOT_EMPTY;
    }

    private static void initField(int sizeY, int sizeX){
        fieldSizeX = sizeX;
        fieldSizeY = sizeY;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }

        }
    }

    private static void printField(){
        System.out.print('+');
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1);
        }
            System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
           /* for (int j = 0; j < fieldSizeX * 2 + 1; j++) {
                System.out.print("-");
            }
            System.out.println();*/
        }

    public static boolean exitCondition(){
        Scanner scanner = new Scanner(System.in);
        String s;
        char a;
        for(;;){
            System.out.print("Продолжить? [y/n]:");
            s = scanner.nextLine();
            a = s.charAt(0);
            if(a == 'y')return true;
            else if(a == 'n')return false;
            System.out.print('\r');
        }
    }
}


