package Java1.DZ1.Java1.DZ4;

import java.util.Random;
import java.util.Scanner;

public class Cross {
    // 2 Определяем размеры массива
    static int SIZE_Y = 5;
    static int SIZE_X = 5;
    static final int SIZE_WIN =4;

    // 8
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // 1 создаем двумерный массив
    static char[][] field = new char[SIZE_Y][SIZE_X];

    // 3 Обозначения фишек
    static char PLAYER_DOT = 'X';
    static char AI_DOT = '0';
    static char EMPTY_DOT = '.';

    // 4 Заполнить массив
    private static void initField() {
        for(int i = 0; i < SIZE_Y; i++) {
            for(int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    // 5 Выводим массив на печать
    private static void printField() {
        // 6 укаращение
        System.out.println("-------");
        for(int i = 0; i < SIZE_Y; i++) {
            System.out.print("|");
            for(int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("--------");
    }

    // 7 метод который устанавливает символ
    private static void setSym(int y, int x, char sym) {
        field[y][x] = sym;
    }

    //9 Ход игрока

    private static void playerStep() {
        int x, y;
        do {
            System.out.println("Введите координаты вашего хода в диапозоне от 1 до " + SIZE_Y);
            System.out.print ("Координат по строке ");
            y = scanner.nextInt()-1;
            System.out.print ("Координат по столбцу ");
            x = scanner.nextInt()-1;

        } while (!isCellValid(y,x));
        setSym(y, x, PLAYER_DOT);
    }

    // 10 Проверка
    private static boolean isCellValid(int y, int x) {
        if( x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1 ) {
            return false;
        }
        return (field[y][x] == EMPTY_DOT);

    }


    //Ход компьютера

    private static boolean aiStep() {
        int x, y;
        //блокировка ходов человека
        for (int v = 0; v<SIZE_Y; v++) {
            for (int h = 0; h < SIZE_X; h++) {
                //анализ наличие поля для проверки
                if (h+SIZE_WIN<=SIZE_X) {                           //по горизонтале
                    if (checkLineHorisont(v, h, PLAYER_DOT) == SIZE_WIN - 1) {
                        if (MoveAiLineHorisont(v, h, AI_DOT)) return true;
                    }

                    if (v - SIZE_WIN > -2) {                            //вверх по диагонале
                        if (checkDiaUp(v, h, PLAYER_DOT) == SIZE_WIN - 1) {
                            if (MoveAiDiaUp(v, h, AI_DOT)) return  true;
                        }
                    }
                    if (v + SIZE_WIN <= SIZE_Y) {                       //вниз по диагонале
                        if (checkDiaDown(v, h, PLAYER_DOT) == SIZE_WIN - 1) {
                            if (MoveAiDiaDown(v, h, AI_DOT)) return  true;
                        }
                    }
                }
                if (v+SIZE_WIN<=SIZE_Y) {                       //по вертикале
                    if (checkLineVertical(v,h,PLAYER_DOT) ==SIZE_WIN-1) {
                        if(MoveAiLineVertical(v,h,AI_DOT)) return  true;
                    }
                }
            }
        }
        //игра на победу
        for (int v = 0; v<SIZE_Y; v++) {
            for (int h = 0; h < SIZE_X; h++) {
                //анализ наличие поля для проверки
                if (h+SIZE_WIN<=SIZE_X) {                           //по горизонтале
                    if (checkLineHorisont(v,h,AI_DOT) == SIZE_WIN-1) {
                        if (MoveAiLineHorisont(v,h,AI_DOT)) return  true;
                    }

                    if (v-SIZE_WIN>-2) {                            //вверх по диагонале
                        if (checkDiaUp(v, h, AI_DOT) == SIZE_WIN-1) {
                            if (MoveAiDiaUp(v,h,AI_DOT)) return  true;
                        }
                    }
                    if (v+SIZE_WIN<=SIZE_Y) {                       //вниз по диагонале
                        if (checkDiaDown(v, h, AI_DOT) == SIZE_WIN-1) {
                            if (MoveAiDiaDown(v,h,AI_DOT)) return  true;
                        }
                    }

                }
                if (v+SIZE_WIN<=SIZE_Y) {                       //по вертикале
                    if (checkLineVertical(v,h,AI_DOT) ==SIZE_WIN-1) {
                        if(MoveAiLineVertical(v,h,AI_DOT)) return  true;
                    }
                }
            }
        }

        //случайный ход
        do {
            y = random.nextInt(SIZE_Y);
            x = random.nextInt(SIZE_X);
        } while (!isCellValid(y,x));
        setSym(y, x, AI_DOT);

        return false;
    }

    //ход компьютера по горизонтале
    private static boolean MoveAiLineHorisont(int v, int h, char dot) {
        for (int j = h; j < SIZE_WIN; j++) {
            if ((field[v][j] == EMPTY_DOT)) {
                field[v][j] = dot;
                return true;
            }
        }
        return false;
    }
    //ход компьютера по вертикале
    private static boolean MoveAiLineVertical(int v, int h, char dot) {
        for (int i = v; i<SIZE_WIN; i++) {
            if ((field[i][h] == EMPTY_DOT)) {
                field[i][h] = dot;
                return true;
            }
        }
        return false;
    }
    //ход компьютера проверка заполнения всей линии по диагонале вверх

    private static boolean MoveAiDiaUp(int v, int h, char dot) {
        for (int i = 0, j = 0; j < SIZE_WIN; i--, j++) {
            if ((field[v+i][h+j] == EMPTY_DOT)) {
                field[v+i][h+j] = dot;
                return true;
            }
        }
        return false;
    }
    //ход компьютера проверка заполнения всей линии по диагонале вниз

    private static boolean MoveAiDiaDown(int v, int h, char dot) {

        for (int i = 0; i < SIZE_WIN; i++) {
            if ((field[i+v][i+h] == EMPTY_DOT)) {
                field[i+v][i+h] = dot;
                return true;
            }
        }
        return false;
    }


    //проверка заполнения всей линии по диагонале вверх
    private static int checkDiaUp(int v, int h, char dot) {
        int count=0;
        for (int i = 0, j = 0; j < SIZE_WIN; i--, j++) {
            if ((field[v+i][h+j] == dot)) count++;
        }
        return count;
    }
    //проверка заполнения всей линии по диагонале вниз

    private static int checkDiaDown(int v, int h, char dot) {
        int count=0;
        for (int i = 0; i < SIZE_WIN; i++) {
            if ((field[i+v][i+h] == dot)) count++;
        }
        return count;
    }
    //провека заполнения всей линии горизонтале
    private static int checkLineHorisont(int v, int h, char dot) {
        int count=0;
        for (int j = h; j < SIZE_WIN; j++) {
            if ((field[v][j] == dot)) count++;
        }
        return count;
    }
    //проверка заполнения всей линии по вертикале
    private static int checkLineVertical(int v, int h, char dot) {
        int count=0;
        for (int i = v; i<SIZE_WIN; i++) {
            if ((field[i][h] == dot)) count++;
        }
        return count;
    }

    // Проверка победы

    private static boolean checkWin(char sym) {
        for (int v = 0; v<SIZE_Y; v++){
            for (int h= 0; h<SIZE_X; h++) {
                //анализ наличие поля для проверки
                // проверяем сначала возможна ли победа
                if (h + SIZE_WIN <= SIZE_X) {
                    //по горизонтале
                    if (checkLineHorisont(v, h, sym) >= SIZE_WIN) return true;

                    //вверх по диагонале
                    if (v - SIZE_WIN > -2) {
                        if (checkDiaUp(v, h, sym) >= SIZE_WIN) return true;
                    }

                    //вниз по диагонале
                    if (v + SIZE_WIN <= SIZE_Y) {
                        if (checkDiaDown(v, h, sym) >= SIZE_WIN) return true;
                    }
                }
                if (v + SIZE_WIN <= SIZE_Y) {                       //по вертикале
                    if (checkLineVertical(v, h, sym) >= SIZE_WIN) return true;
                }
            }
        }
        return false;
    }

    // проверка полное ли поле?
    private static boolean isFieldFull() {
        for(int i = 0; i < SIZE_Y; i++) {
            for(int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {

        initField();
        printField();

        do {
            playerStep();
            System.out.println("Ваш ход на поле");
            printField();
            if(checkWin(PLAYER_DOT)) {
                System.out.println("Player WIN SkyNet");
                break;
            }
            if(isFieldFull()) {
                System.out.println("DRAW");
                break;
            }

            aiStep();
            System.out.println("Ход Компа на поле");
            printField();
            if(checkWin(AI_DOT)) {
                System.out.println("SkyNet WIN Player");
                break;
            }
            if(isFieldFull()) {
                System.out.println("DRAW");
                break;
            }

        } while (true);
        System.out.println("!Конец игры!");
    }





}