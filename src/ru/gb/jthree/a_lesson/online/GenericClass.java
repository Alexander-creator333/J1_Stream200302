package ru.gb.jthree.a_lesson.online;

import java.util.ArrayList;

public class GenericClass {
    public static void main(String[] args) {
        //Демонстрация (Метод Run реализован в классе ChangeMass.Run, дополнительно создан метод вывода массива на экран ChangeMass.Print)
        ChangeMass<Integer> chMass1 = new ChangeMass<Integer>();
        ChangeMass<Float> chMass2 = new ChangeMass<Float>();
        Integer[] arr_i = new Integer[] {1,2,3,4,5,6,7,8,9};
        Float[] arr_f = new Float[] {1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f};
        System.out.println("№1 :Before...");
        chMass1.Print(arr_i);
        chMass2.Print(arr_f);

        chMass1.Run(arr_i,3,4);
        chMass2.Run(arr_f,5,6);

        System.out.println("№1 :After...");
        chMass1.Print(arr_i);
        chMass2.Print(arr_f);
        //2. Написать метод, который преобразует массив в ArrayList;
        //Демонстрация. (Метод toArrayList реализован в том же классе)
        ArrayList tmp = chMass1.toArraylist(arr_i);
        System.out.println("№2: Array list is = "+tmp.toString());
    }
}
