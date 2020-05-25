package ru.gb.jthree.d_lesson.online;

public class ThreadsDemo {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        ThreadDemo w = new ThreadDemo();
        Thread t1 = new Thread(() -> {
            w.printABC('A','B');
        });
        Thread t2 = new Thread(() -> {
            w.printABC('B','C');
        });
        Thread t3 = new Thread(() -> {
            w.printABC('C','A');
        });

        t1.start();
        t2.start();
        t3.start();
    }

    public void printABC(char cC, char nC) {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != cC) {
                        mon.wait();
                    }
                    System.out.print(cC);
                    currentLetter = nC;
                    mon.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

