package ru.geekbrains.java_one.lesson_g.online;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel {
    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;

/*    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.red);
        g.drawLine(0, 0, 100, 100);
    }
*/
    FieldPanel() {
        setBackground(Color.BLUE);

    }

    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        //System.out.printf("damn mode: %d\nfield size: %d,\nwin length: %d\n", gameMode, fieldSizeX, winLength);
        Graphics g = getGraphics();
        g.setColor(Color.BLUE);

        Rectangle r = getBounds();
        int maxX = (int) r.getWidth();
        int maxY = (int) r.getHeight();

        g.fillRect(0,0,maxX,maxY);
        g.setColor(Color.red);
        //507 555
        for (int i = 0; i < fieldSizeX; i++) {
            g.drawLine((int)(507/fieldSizeX*i),0,(int)(507/fieldSizeX*i),555);
        }
        for (int j = 0; j < fieldSizeY; j++) {
            g.drawLine(0,(int)(555/fieldSizeY*j),507,(int)(555/fieldSizeY*j));
        }
        //333
    }
}