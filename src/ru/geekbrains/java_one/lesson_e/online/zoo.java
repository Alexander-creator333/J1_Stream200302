package ru.geekbrains.java_one.lesson_e.online;

public class zoo {
    public static void main(String[] args) {
        Cat cAt = new Cat();
        Dog dOg = new Dog();
        Horse hOrse = new Horse();
        Bird bIrd = new Bird();

        //код для теста
        if (cAt.jump(15) ) {
            System.out.println("Кошечка прыгнула");
        }
        else {
            System.out.println("Кошечка не смогла");
        }

    }
}
