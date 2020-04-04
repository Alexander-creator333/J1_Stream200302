package ru.gb.jtwo.a_lesson.online;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class GameCanvas extends JPanel {

    MainCircles listener;
    long lastFrameTime;
    BackGRND backFon;

    GameCanvas(MainCircles listener) {
        this.listener = listener;
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //60 frames per second
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        backFon.setBackGRND(g,getRight(),getBottom());
        listener.onCanvasRepainted(this, g, deltaTime);
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}