package ru.gb.jthree.a_lesson.online.Ashan;

public class Ashan {
    public static void main(String[] args) {
        Box<Apple> b1 = new Box();
        Box<Apple> b2 = new Box();
        Box<Orange> b3 = new Box();
        b1.addFruit(new Apple("Red"));
        b1.addFruit(new Apple("Yellow"));
        b1.addFruit(new Apple("Red"));

        b2.addFruit(new Apple("Green"));
        b2.addFruit(new Apple("Green"));
        b2.addFruit(new Apple("Green"));
        b2.addFruit(new Apple("Green"));

        b3.addFruit(new Orange("Large"));
        b3.addFruit(new Orange("Large"));
        b3.addFruit(new Orange("Small"));

        b1.printBox();
        b2.printBox();
        b3.printBox();

        System.out.println("================pour the baskets==================");
        if(b3.FlushToAnotherBox(b2)){
            System.out.println("Flush 3 to 2 success");
        } else{
            System.out.println("Flush 3 to 2 failure");
        }

        if(b2.FlushToAnotherBox(b1)){
            System.out.println("Flush 2 to 1 success");
        } else{
            System.out.println("Flush 2 to 1 failure");
        }



        b1.printBox();
        b2.printBox();
        b3.printBox();

    }
}
