package ru.geekbrains.java_one.lesson_d.online;
import ru.geekbrains.java_one.lesson_d.online.Sotrudnik;

import java.sql.SQLOutput;
/*
1.Создать класс "Сотрудник" с полями: Фамилия, зарплата, возраст, должность;
2.Конструктор класса должен заполнять эти поля при создании объекта;
3.Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
4.Вывести при помощи методов из пункта 3 ФИО и должность.
5.Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
*. Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
*. Подсчитать средние арифметические зарплаты и возраста сотрудников из п.5
***. Продумать конструктор таким образом, чтобы при создании каждому сотруднику присваивался личный уникальный идентификационный порядковый номер
*/

public class OK {
    //*. Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
    public static int upZarplata(Sotrudnik[] arr){
        int n=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getAgeSotrudnika()>45){
                arr[i].setZarplataSotrudnika(arr[i].getZarplataSotrudnika()+5000);
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        //5.Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        System.out.println("===================================#5#===================================");
        Sotrudnik[] tabSotr = new Sotrudnik[5];
        tabSotr[0] = new Sotrudnik("Neizhmakov",70000,45, "IT-direktor" );
        tabSotr[1] = new Sotrudnik("Medvedev",40000,38, "IT-ingeneer" );
        tabSotr[2] = new Sotrudnik("Shkrobato",50000,34, "IT-support" );
        tabSotr[3] = new Sotrudnik("Novikov",35000,33, "Programmist" );
        tabSotr[4] = new Sotrudnik("Golubev",50000,46, "IT-specialist" );

        //System.out.println("Зарплата была поднята "+upZarplata(tabSotr)+" сотрудникам");

        for (int i = 0; i < 5; i++) {
            if(tabSotr[i].getAgeSotrudnika()>40){
                System.out.println(tabSotr[i].getTableNumber()+":\t"+tabSotr[i].getFamilySotrudnika()+"\t\t"+tabSotr[i].getDolzhnostSotrudnika()+"\tZP:"+tabSotr[i].getZarplataSotrudnika()+"\tAGE="+tabSotr[i].getAgeSotrudnika());
            }
        }
        System.out.println("===================================#4#===================================");
        //4.Вывести при помощи методов из пункта 3 ФИО и должность.
        for (int i = 0; i < 5; i++) {
            System.out.println(/*tabSotr[i].getTableNumber()+":\t"+*/tabSotr[i].getFamilySotrudnika()+"\t\t"+tabSotr[i].getDolzhnostSotrudnika());
        }
        System.out.println("===================================#7#===================================");
        //*. Подсчитать средние арифметические зарплаты и возраста сотрудников из п.5
        int aGE=0;
        float zP=0;
        for (int i = 0; i < 5; i++) {
            aGE+=tabSotr[i].getAgeSotrudnika();
            zP+=tabSotr[i].getZarplataSotrudnika();
        }
        System.out.println("Средний возраст сотрудника= "+aGE/5+" Средняя зарплата сотрудника= "+zP/5);
    }
}

