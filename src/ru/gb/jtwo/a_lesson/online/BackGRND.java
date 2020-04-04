package ru.gb.jtwo.a_lesson.online;

import java.awt.*;

public abstract class BackGRND {

    public static void setBackGRND(Graphics g, float delta, int wW, int wH) {
        Color clr = new Color (
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255)
        );
        g.setColor(clr);
        g.fillRect(0,0,wW,wH);
    }

}
