package ru.gb.jthree.a_lesson.online.Ashan;

public class Orange extends Fruit {
    private String type;
    public Orange(String type){
        this.type = type;
        this.fWeight = 1.5f;
        this.fName = "Orange";
    }
    public String getType(){
        return this.type;
    }
}
