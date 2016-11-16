/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 205
 */
public class lane {

    ArrayList<car> cars = new ArrayList<car>();
    //Graphics g;
    //boolean onDraw = true;
    boolean greenLight = true;
    int posX = 0;
    int posY = 300;
    int width = 1200;
    int height = 80;
    boolean cross = true;
    int id = 0;

    public lane() {  
    }

    public void DrawLane(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(posX, posY, width, height);
        //g.setColor(Color.BLACK);
        //g.fillRect(0, 295, 1200, 5);
        //g.fillRect(0, 380, 1200, 5);
        //g.fillRect(540, 0, 80, 1200);
    }

 

    public void DrawCar(Graphics g) {
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).Cpaint(g);
            }
    }

    



}


