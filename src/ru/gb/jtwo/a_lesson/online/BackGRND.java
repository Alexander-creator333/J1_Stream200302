package ru.gb.jtwo.a_lesson.online;

import java.awt.*;

public abstract class BackGRND {
/*Делал фон через рисование...
    public static void setBackGRND(Graphics g, int wW, int wH) {
        Color clr = new Color (
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255)
        );
        g.setColor(clr);
        g.set
        g.fillRect(0,0,wW,wH);
    }
*/

//Тут сделал фон через параметр канвы
public static void setBackGRND(GameCanvas can) {
    Color clr = new Color (
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255)
    );
    can.setBackground(clr);
}

}
