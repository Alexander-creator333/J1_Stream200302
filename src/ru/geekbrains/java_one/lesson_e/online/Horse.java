package ru.geekbrains.java_one.lesson_e.online;

public class Horse extends Animal {
    public Horse(){
        super();
        this.maxHeight = (float)3.0*this.maxHeight + (float)3.0;
        this.maxWidth = (float)100.0*this.maxHeight + (float)100.0;
        this.maxLength = (float)1500.0*this.maxHeight + (float)1500.0;
    }
}
