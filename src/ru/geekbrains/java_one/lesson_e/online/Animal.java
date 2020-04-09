package ru.geekbrains.java_one.lesson_e.online;
import java.util.Random;

public class Animal {
    protected float maxLength;
    protected float maxWidth;
    protected float maxHeight;
    //protected String cName;
    private static final Random RANDOM = new Random();

    public Animal(/*String cName*/) {//формируем разброс не более чем на треть от максимального параметра, который получим в дочернем конструкторе.
        //this.cName = cName;
        this.maxLength = RANDOM.nextInt(30)/(float)100.0;
        this.maxWidth = RANDOM.nextInt(30)/(float)100.0;
        this.maxHeight = RANDOM.nextInt(30)/(float)100.0;
    }

    protected boolean run(float length){
        if(length<=maxLength && length>=0){
            return true;
        } else {
            return false;
        }
    }

    protected boolean swim(float width){
        if(width<=maxWidth && width>=0){
            return true;
        } else {
            return false;
        }
    }

    protected boolean jump(float hight){
        if(hight<=maxHeight && hight>=0){
            return true;
        } else {
            return false;
        }
    }

}
