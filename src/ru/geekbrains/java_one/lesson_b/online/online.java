package ru.geekbrains.java_one.lesson_b.online;

import java.util.Arrays;

public class online {

    /* 1 Задать целочисленный массив, состоящий из элементов 0 и 1.
     *   Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     *   Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
     */
    private static void first(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            arr[i] = arr[i] == 1 ? 0 : 1;
            //System.out.print(arr[i]+" ");
        }
    }

    /* 2 Задать пустой целочисленный массив размером 8. Написать метод,
     *   который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
     */
    private static void second(int[] arr) {
        int j=1;
        for (int i=0;i<arr.length;i++) {
            arr[i] = j;
            j+=3;
            //System.out.print(arr[i]+" ");
        }
    }

    /* 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,
     *   принимающий на вход массив и умножающий числа меньше 6 на 2;
     */
    private static void thirt(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            arr[i] = arr[i] < 6 ? arr[i]*2 : arr[i];
            //System.out.print(arr[i]+" ");
        }
    }

    /*4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
     *
     */
    private static int fouth_min(int[] arr) {
        int min=2147483647;
        for (int i=0;i<arr.length;i++) {
            min = arr[i] < min ? arr[i] : min;
        }
        return min;
    }
    private static int fouth_max(int[] arr) {
        int max=-2147483648;
        for (int i=0;i<arr.length;i++) {
            max = arr[i] > max ? arr[i] : max;
        }
        return max;
    }

    /*5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
     *  заполнить его диагональные элементы единицами, используя цикл(ы);
     */
    private static void fifth(int[][] arr) {
        for (int i=0;i<arr.length;i++) {
            arr[i][i] = 1;
            arr[i][arr.length-i-1] = 1;
        }
        /*for (int i=0;i<arr.length;i++) {
            System.out.println(Arrays.toString(arr[i]) );
        }*/
    }

    /*6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
     *     метод должен вернуть true если в массиве есть место, в котором сумма левой
     *     и правой части массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true,
     *     checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 1, 2, 3, 4]) → true.
     *     Абстрактная граница показана символами ||, эти символы в массив не входят.
     */
    private static boolean sixth(int[] arr) {
        boolean result=false;
        int left = arr[0];
        int right = 0;
        for (int j = 1; j <arr.length ; j++) {
            right += arr[j];
        }
        for (int i=1;i<arr.length-1;i++) {
            left = left + arr[i];
            right = right - arr[i];
            //System.out.println(left + " " + right);
            result = right == left ? true : false;
            if(result) break;
        }
        return result;
    }

    /*7 *** Написать метод, которому на вход подаётся одномерный массив и число n
     *      (может быть положительным, или отрицательным), при этом метод должен циклически
     *      сместить все элементы массива на n позиций.
     */
    private static void finth(int[] arr, int n) {
        if(n==0){
            //return;
        } else if(n>0){
            for (int j = 0; j < n; j++) {
                int tmp = arr[arr.length - 1];
                for (int i = arr.length - 2; i >= 0; i--) {
                    arr[i + 1] = arr[i];
                }
                arr[0] = tmp;
            }
        } else {
            for (int j = n; j < 0; j++) {
                int tmp = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    arr[i - 1] = arr[i];
                }
                arr[arr.length-1] = tmp;
            }
        }
        //System.out.println(Arrays.toString(arr));
    }

    // main - main2-3
    public static void main(String[] args) {
        int[] first_arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        first(first_arr);
        int[] second_arr = new int[8];
        second(second_arr);
        int[] thirt_arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        thirt(thirt_arr);
        int[] fouth_arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1, 5, 6, 9, 13, 55, 143};
        //System.out.println(fouth_min(fouth_arr));
        //System.out.println(fouth_max(fouth_arr));
        int[][] fifth_arr = new int[8][8];
        fifth(fifth_arr);
        //if(sixth(fouth_arr)) System.out.println("yes"); else System.out.println("no");
        finth(fouth_arr,-2);
    }
}
