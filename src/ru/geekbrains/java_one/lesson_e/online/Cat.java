package ru.geekbrains.java_one.lesson_e.online;

public class Cat extends Animal {
    public Cat(){
        super();
        this.maxHeight = (float)0.2*this.maxHeight + (float)0.2;
        this.maxWidth = (float)0.0;
        this.maxLength = (float)2.0*this.maxHeight + (float)2.0;
    }

}
