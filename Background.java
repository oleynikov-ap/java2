package ru.gb.jtwo.alesson.online;

import javax.swing.*;
import java.awt.*;

public class Background extends GameCanvas {
    private Color color;
    private float rgb[] = new float[3];
    private int fx[] = {1, 1, 1};


    Background(MainCircles controller) {
        super(controller);
        color = new Color (
                (int)(Math.random() * 255), //r
                (int)(Math.random() * 255), //g
                (int)(Math.random() * 255)  //b
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        update(this, deltaTime);
        render(this);
        lastFrameTime = currentTime;
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }
    public void update(Background bg, float deltaTime) {
        this.color.getColorComponents(rgb);

        for (int i = 0; i < rgb.length; i++) {
            rgb[i] += fx[i] * deltaTime;
            if (rgb[i] < 0) {
                rgb[i] = 0;
                fx[i] = - fx[i];
            } else if (rgb[i] > 1) {
                rgb[i] = 1 ;
                fx[i] = - fx[i];
            }
        }
        this.color = new Color(rgb[0], rgb[1], rgb[2]);
    }

    public void render(Background bg) {
        bg.setBackground(this.color);
    }
}
