package ru.geekbrains.java_one.lesson_e.online;

public class Dog extends Animal {
    public Dog(){
        super();
        this.maxHeight = (float)0.5*this.maxHeight + (float)0.5;
        this.maxWidth = (float)10.0*this.maxHeight + (float)10.0;
        this.maxLength = (float)500.0*this.maxHeight + (float)500.0;
    }
}
