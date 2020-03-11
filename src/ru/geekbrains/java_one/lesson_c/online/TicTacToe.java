package ru.geekbrains.java_one.lesson_c.online;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '_';

    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int lineLength;
    private static char[][] field;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static void initField() {
        //fieldSizeY = 3;
        //fieldSizeX = 3;

        //запрашиваем размер игрового поля
        int x1=0,y1=0;
        do {
            System.out.print("Введите размеры поля (не менее 3х3), через пробел>>> ");
            y1 = SCANNER.nextInt();
            x1 = SCANNER.nextInt();
        } while (y1 < 3 || x1 < 3);
        fieldSizeY = y1;
        fieldSizeX = x1;

        if(fieldSizeX<fieldSizeY) lineLength=fieldSizeX;
            else lineLength=fieldSizeY;

        //...длину выигрышной линии
        int l=0;
        do {
            System.out.print("Введите длинну выигрышной полосы (не менее " + lineLength + " ) >>> ");
            l = SCANNER.nextInt();
        } while (l > fieldSizeY || l > fieldSizeX);
        lineLength = l;

        //System.out.println(fieldSizeX+" "+fieldSizeY+" "+lineLength);

        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.println("------");
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >=0 && y < fieldSizeY;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода X (от 1 до " + fieldSizeX +") и Y (от 1 до " + fieldSizeY +") через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    //метод ищет где противнику осталось сделать один ход к победе и возвращает истину если такой есть. Кооринаты хода пишет в массив что в параметрах.
    //параметр лен задаёт длинну выигрышной последовательности, можно было использовать lineLength, но он нужен для поиска менее выигрышных позиций.
    private static boolean whereIsMyProblem(int[] xy,char c, int len){
                //ищем без одного выигрышные вертикали в поле
                for (int y = 0; y < fieldSizeY-len+1; y++) {
                    for (int x = 0; x < fieldSizeX; x++) {
                        if(checkPsetWinY(y,x,c,len)==len-1) { //проверяем что выигрышнаябез одного
                            for (int i = 0; i < len; i++) { //ищем пустую клетку
                                if(field[y+i][x]==DOT_EMPTY){ //если нашли, то передаём координаты и возвращаем истину
                                    xy[0] = x;
                                    xy[1] = y+i;
                                    return true;
                                }
                            }
                        }
                    }
                }
                //... горизонтали в поле
                for (int y = 0; y < fieldSizeY; y++) {
                    for (int x = 0; x < fieldSizeX-len+1; x++) {
                        if(checkPsetWinX(y,x,c,len)==len-1) {
                            for (int i = 0; i < len; i++) {
                                if(field[y][x+i]==DOT_EMPTY){
                                    xy[0] = x+i;
                                    xy[1] = y;
                                    return true;
                                }
                            }
                        }
                    }
                }
                //...диагонали
                for (int y = 0; y < fieldSizeY-len+1; y++) {
                    for (int x = 0; x < fieldSizeX-len+1; x++) {
                        if(checkPsetWinZ(y,x,c,len)==len-1) {
                            for (int i = 0; i < len; i++) {
                                if(field[y+i][x+i]==DOT_EMPTY){
                                    xy[0] = x+i;
                                    xy[1] = y+i;
                                    return true;
                                }
                            }
                        }
                    }
                }
                //...обратные диагонали
                for (int y = 0; y < fieldSizeY-len+1; y++) {
                    for (int x = fieldSizeX-1; x >= len  ; x--) {
                        if(checkPsetWinR(y,x,c,len)==len-1) {
                            for (int i = 0; i < len; i++) {
                                if(field[y+i][x-i]==DOT_EMPTY){
                                    xy[0] = x-i;
                                    xy[1] = y+i;
                                    return true;
                                }
                            }
                        }
                    }
                }

        return false;
    }
    //вспомогательный метод хода ai? если он не срабатывет. то фi [одит рандомом
    private static boolean aiCrossFireTurn(int[] xy)
    {
        //ищем где противник готов победить за один ход и перекрываем ему путь к победе
        if(whereIsMyProblem(xy,DOT_HUMAN,lineLength)){
            return true;
        }
        //ищем где у нас максимум фишек в ряд и добиваем ещё одну
        for (int i = lineLength-1; i > 1; i--) {
           if(whereIsMyProblem(xy,DOT_AI,i)){//если тут поменять на DOT_HUMAN и оставить только этот цикл, то ai будет пытаться перекрывать нам всевозможные ходы. Тоже интереснаямодель поведения, кстати.
                return true;
            }
        }
        return false;//без разницы куда ходить, будем использовать рандом
    }

    private static void aiTurn() {
        int x;
        int y;
        int[] xy = {0, 0};
        if (aiCrossFireTurn(xy))    //ищем выгодные позиции для хода...
        {
            x=xy[0];
            y=xy[1];
        } else{                     //...если их нет, то ходим рандомно
            do {
                x = RANDOM.nextInt(fieldSizeX);
                y = RANDOM.nextInt(fieldSizeY);
            } while (!isEmptyCell(x, y));
        }
        field[y][x] = DOT_AI;

    }

    private static boolean isFieldFull() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    //проверяет выигрышная ли горизонталь в этой точке
    private static int checkPsetWinX(int y, int x, char c, int l) {
        int b=0;
        for (int i = 0; i < l; i++) {
            if(field[y][x+i] == c) b++;
        }
        return b;
    }
    //проверяет выигрышная ли вертикаль в этой точке
    private static int checkPsetWinY(int y, int x, char c, int l) {
      //  System.out.println("x:" + x +" y:" + y +" c:" + c +" l:"+l);
        int b=0;
        for (int i = 0; i < l; i++) {
            //System.out.println("y:" + y +" x:" + x +" i:"+i);
            if(field[y+i][x] == c) b++;
        }
        return b;
    }

    //проверяет выигрышная ли диагональ в этой точке
    private static int checkPsetWinZ(int y, int x, char c, int l) {
        int b=0;
        for (int i = 0; i < l; i++) {
            //System.out.println("y:" + y +" x:" + x +" i:"+i);
            if(field[y+i][x+i] == c) b++;
        }
        return b;
    }

    //проверяет выигрышная ли обратная диагональ в этой точке
    private static int checkPsetWinR(int y, int x, char c, int l) {
        int b=0;
        for (int i = 0; i < l; i++) {
            //System.out.println("y:" + y +" x:" + x +" i:"+i);
            if(field[y+i][x-i] == c) b++;
        }
        return b;
    }

    //Git-Hubb 333 444

    private static boolean checkWin(char c, int l) {
        //ищем выигрышные вертикали в поле
        for (int y = 0; y < fieldSizeY-l+1; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(checkPsetWinY(y,x,c,l)==l) return true;
            }
        }
        //... горизонтали в поле
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX-l+1; x++) {
                if(checkPsetWinX(y,x,c,l)==l) return true;
            }
        }
        //...диагонали
        for (int y = 0; y < fieldSizeY-l+1; y++) {
            for (int x = 0; x < fieldSizeX-l+1; x++) {
                if(checkPsetWinZ(y,x,c,l)==l) return true;
            }
        }
        //...обратные диагонали
        for (int y = 0; y < fieldSizeY-l; y++) {
            for (int x = fieldSizeX-1; x >= l  ; x--) {
                System.out.println("x, y"+ x+" "+y);
                if(checkPsetWinR(y,x,c,l)==l) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        while (true) {
        playOneRound();
            System.out.println("Play again? yes/no");
            if (SCANNER.next().equals("no"))
                break;
        }
    }

    private static void playOneRound() {
        initField();
        printField();
        while (true) {
            humanTurn();
            printField();
            if (checkWin(DOT_HUMAN, lineLength)) {
                System.out.println("Игрок победил!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printField();
            if (checkWin(DOT_AI,lineLength)) {
                System.out.println("Компьютер победил!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

}