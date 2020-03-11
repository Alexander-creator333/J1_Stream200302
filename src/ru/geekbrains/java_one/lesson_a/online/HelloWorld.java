package ru.geekbrains.java_one.lesson_a.online;
//привет всем

/*
* весь этот текст игнорится
* */

/*секционный коммент*/

/*
* private
* default, [], package private
* protected
* public*/
public class HelloWorld {

    private static float first(int a, int b, int c, int d) {
         return  a*(b+(c/d));
    }

    private static boolean second(int a, int b) {
        if((a+b<21)&&(a+b>9)) {
            return true;
        } else{
            return false;
        }
    }

    private static boolean thirt(int a) {
        if(a>=0) {
            return true;
        } else{
            return false;
        }
    }

    private static String fouth(String name) {
        //System.out.println("Приветствую!");
        //return "Привет, переданное_имя!";
        System.out.println("Привет,"+name+"!");
        return "Привет,"+name+"!";
    }

    private static boolean fifth(int year) {
        if (year%400==0){
            return true;
        } else if (year%100==0) {
            return false;
        } else if (year%4==0){
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {

        if(thirt(-10)){
            System.out.println("digit >= 0");
        } else {
            System.out.println("digit < 0");
        }

        if(fifth(1604)){
            System.out.println("Год високосный");
        } else {
            System.out.println("Год невисокосный");
        }


    }
}
