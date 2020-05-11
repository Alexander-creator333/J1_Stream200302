package ru.gb.jthree.a_lesson.online;

import java.util.ArrayList;

public class ChangeMass<T extends Number> {
    public ChangeMass() {

    }

    //1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    public void Run(T[] arr, int i, int j) {
        if(0 <=i && i < arr.length && 0 <=j && j < arr.length){
            T tmp;
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        else
        {
            System.out.println("Out of arr index...");
        }
    }
    //Вывод массива на экран
    public void Print(T[] arr) {
        System.out.print(arr[0].toString());
        for (int i = 1; i < arr.length; i++) {
            System.out.print(", "+arr[i].toString());
        }
        System.out.println();
    }
    //2. Написать метод, который преобразует массив в ArrayList;
    public ArrayList toArraylist(T[] arr){
        ArrayList tmp = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            tmp.add(arr[i]);
        }
        return tmp;
    }
}
