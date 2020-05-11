package ru.gb.jthree.a_lesson.online.Ashan;
import java.util.ArrayList;

//Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
public class Box<T extends Fruit> {
    //Размер коробки, на будеущее...
    private long Volume;

    //Для хранения фруктов внутри коробки можно использовать ArrayList;
    public ArrayList<T> bFruits;

    public Box(){
        bFruits = new ArrayList<>();
    }
    public Box(T tmp){
        this();
        bFruits.add(tmp);
    }
    public Box(T []tmp){
        this();
        for (int i = 0; i < tmp.length; i++) {
            bFruits.add(tmp[i]);
        }
    }

    //Не забываем про метод добавления фрукта в коробку
    public void addFruit(T tmp){
        this.bFruits.add(tmp);
    }

    //Вывод на экран содержимого коробки
    public void printBox(){
        if(bFruits.size()==0){
            System.out.println("EMPTY..");
        } else {
            T tmp = bFruits.get(0);
            System.out.print(tmp.getName());
            for (int i = 1; i < bFruits.size(); i++) {
                tmp = bFruits.get(i);
                System.out.print(", "+tmp.getName());
            }
            System.out.println();
        }
    }

    //Сделать метод getWeight(), который высчитывает вес коробки. Задать вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
    public int getWeight(){
        T tmp;
        int rWeight=0;
        for (int i = 0; i < bFruits.size(); i++) {
            tmp = bFruits.get(i);
            rWeight += tmp.getWeight();
        }
        return rWeight;
    }

    //Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
    public boolean Compare(Box tmp){
        return this.getWeight() == tmp.getWeight();
    }

    //Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
    public boolean FlushToAnotherBox(Box tmp){
        if ((tmp.bFruits.get(0) instanceof Apple &&  this.bFruits.get(0) instanceof Apple) || (tmp.bFruits.get(0) instanceof Orange &&  this.bFruits.get(0) instanceof Orange)) {
            for (int i = 0; i < this.bFruits.size(); i++) {
                tmp.bFruits.add(this.bFruits.get(i));
            }
            this.bFruits.clear();
            return true;
        }
        return false;
    }
}
