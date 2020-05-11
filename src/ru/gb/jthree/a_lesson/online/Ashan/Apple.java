package ru.gb.jthree.a_lesson.online.Ashan;

public class Apple extends Fruit {
    private String color;
    public Apple(String color){
        this.color = color;
        this.fWeight = 1.0f;
        this.fName = "Apple";
    }
    public String getColor(){
        return color;
    }
}
