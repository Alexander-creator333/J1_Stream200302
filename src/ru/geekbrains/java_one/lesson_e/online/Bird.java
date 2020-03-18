package ru.geekbrains.java_one.lesson_e.online;

public class Bird extends Animal {

    public Bird(){
        super();
        this.maxHeight = (float)0.2*this.maxHeight + (float)0.2;
        this.maxWidth = (float)0.0;
        this.maxLength = (float)5.0*this.maxHeight + (float)5.0;
    }

}
