package ru.gb.jthree.e_lesson.online;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static int flag=0;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private  CyclicBarrier cB;
    private CountDownLatch cdL;
    public Lock locK;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public void SetCB(CyclicBarrier cB){
        this.cB = cB;
    }
    public void SetCDL(CountDownLatch cdL){
        this.cdL = cdL;
    }
    public void SetLock(Lock locK){
        this.locK = locK;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            flag++;
            if(flag==CARS_COUNT){
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                flag=0;
            }
            cB.await();
            System.out.println(this.name + " поехал");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        System.out.println(this.name+" закончил под номером = "+ String.valueOf(++flag));
        cdL.countDown();
    }
}