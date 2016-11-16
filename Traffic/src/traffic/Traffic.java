/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author 205
 */
public class Traffic extends JPanel {

    //car c = new car();
    //boolean greenLight = true;
    boolean onAddYoko = true;
    boolean onAddTate = true;
    ArrayList<yokoLane> yokoLaneList = new ArrayList<yokoLane>();
    ArrayList<tateLane> tateLaneList = new ArrayList<tateLane>();
    trafficLight light = new trafficLight(0,0,50);
    Color lightColor = Color.red;
    //lane lane1 = new lane(0,300,1200,80);

    int i = 1;

    public Traffic() {
        yokoLaneList.add(new yokoLane(0, 300, 1200, 80));
        yokoLaneList.add(new yokoLane(0, 380, 1200, 80));
        tateLaneList.add(new tateLane(540, 0, 80, 600));
        tateLaneList.add(new tateLane(600, 0, 80, 600));
        Timer timer1 = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (onAddYoko) {
                    for (int i = 0; i < yokoLaneList.size(); i++) {
                        yokoLaneList.get(i).AddCar();
                    }                   
                }
                if(onAddTate){
                    for (int i = 0; i < tateLaneList.size(); i++) {
                        tateLaneList.get(i).AddCar();
                    }
                }

                //System.out.println("sb");
            }
        });
        Timer timer2 = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                i++;
                if (i % 4 == 0) {
                    lightColor = Color.red;
                } else if (i % 4 == 1){
                    lightColor = Color.yellow;
                }else if (i % 4 == 2){
                    lightColor = Color.green;
                }else if (i % 4 == 3){
                    lightColor = Color.yellow;
                }
                //System.out.println("sb");
            }
        });
        timer1.start();
        timer2.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        light.draw(g, lightColor);
        for (int i = 0; i < yokoLaneList.size(); i++) {
            yokoLaneList.get(i).DrawLane(g);
        }
        for (int i = 0; i < tateLaneList.size(); i++) {
            tateLaneList.get(i).DrawLane(g);
        }
        //g.setColor(Color.red);
        //g.fillRect(200, 200, 200, 200);
        for (int i = 0; i < yokoLaneList.size(); i++) {
            yokoLaneList.get(i).DrawCar(g);
        }
        for (int i = 0; i < tateLaneList.size(); i++) {
            tateLaneList.get(i).DrawCar(g);
        }
        if (lightColor == Color.red) {
            for (int i = 0; i < yokoLaneList.size(); i++) {
                yokoLaneList.get(i).MoveCar();
            }
            for (int i = 0; i < tateLaneList.size(); i++) {
                tateLaneList.get(i).StopCar();
            }
            onAddYoko = true;
        } else if (lightColor == Color.green){
            for (int i = 0; i < yokoLaneList.size(); i++) {
                yokoLaneList.get(i).StopCar();
            }
            for (int i = 0; i < tateLaneList.size(); i++) {
                tateLaneList.get(i).MoveCar();
            }
            onAddYoko = yokoLaneList.get(0).addOrNot();
            onAddTate = tateLaneList.get(0).addOrNot();
        }else if (lightColor == Color.yellow){
             for (int i = 0; i < yokoLaneList.size(); i++) {
                yokoLaneList.get(i).StopCar();
            }
            for (int i = 0; i < tateLaneList.size(); i++) {
                tateLaneList.get(i).StopCar();
            }
        }

        repaint();
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Traffic");
        frame.setSize(1200, 600);
        frame.add(new Traffic());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
