/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author lenovo-pc
 */
public class trafficLight {
    int posX;
    int posY;
    int radius;
    Color color;
    
    public trafficLight(int x,int y,int r){
        this.posX = x;
        this.posY = y;
        this.radius = r;
    }
    
    public void draw(Graphics g,Color c){
        this.color = c;
        g.setColor(color);
        g.fillOval(posX, posY, radius, radius);
    }
}
