package ru.gb.jtwo.b_lesson.online;

public class BadFormat extends IllegalStateException {
    public BadFormat(){
        super("Array out of 4x4 format!");
    }
}

