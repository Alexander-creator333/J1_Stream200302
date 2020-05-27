import ru.gb.jthree.e_lesson.online.Car;
import ru.gb.jthree.e_lesson.online.Race;
import ru.gb.jthree.e_lesson.online.Road;
import ru.gb.jthree.e_lesson.online.Tunnel;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(80,2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        CyclicBarrier cB = new CyclicBarrier(CARS_COUNT);
        CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
        Lock locK = new ReentrantLock();
        for (int i = 0; i < cars.length; i++) {
            cars[i].SetCB(cB);
            cars[i].SetCDL(cdl);
            cars[i].SetLock(locK);
            new Thread(cars[i]).start();
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}

