/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author 205
 */
public class car {

    public int x = -100;
    public int y = 325;
    private int width = 60;
    private int height = 30;
    public int speed = 2;
    public boolean onMove = false;
    //public boolean onIdle = true;
    private Color color;
    //private Random rand  = new Random();

    public car(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        color = randomColor();
    }

    public void Cpaint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        //System.out.println("drawing");
    }

    public Color randomColor() {
        Random rand = new Random();
        int r = (int) (rand.nextDouble() * 256);
        int g = (int) (rand.nextDouble() * 256);
        int b = (int) (rand.nextDouble() * 256);
        Color c = new Color(r, g, b);
        return c;
    }

    public void move(boolean c) {
        if (c) {
            this.x += speed;
        } else {
            this.y += speed;
        }
        //System.out.println(this.x);

    }

}
