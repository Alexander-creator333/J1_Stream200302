package ru.gb.jtwo.b_lesson.online;

public class BadDigit extends NumberFormatException {
    public BadDigit(){
        super("Find char symbol in array (not digit)!");
    }
}