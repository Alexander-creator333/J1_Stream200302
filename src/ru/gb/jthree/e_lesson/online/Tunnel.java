package ru.gb.jthree.e_lesson.online;

public class Tunnel extends Stage {
    private static int mas;
    private static int masInTime=0;
    public Tunnel(int mas, int length) {
        this.length = length;
        this.mas = mas;
        this.description = "Тоннель " + length + " метров " + mas + " шириной";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                try {
                    c.locK.lock();
                    masInTime++;
                    if(masInTime<mas){
                        c.locK.unlock();
                    }
                    System.out.println(c.getName() + " начал этап: " + description);
                    Thread.sleep(length / c.getSpeed() * 1000);
                    masInTime--;
                } finally {
                      c.locK.unlock();
                  }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
