/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic;

/**
 *
 * @author lenovo-pc
 */
public class yokoLane extends lane{
    
    public yokoLane(int x,int y,int w,int h){
        super();
        posX = x;
        posY = y;
        width = w;
        height = h;
        cross = true;
    }
    
    public void AddCar() {
        car c = new car(posX-100,posY+25,60,30);
        cars.add(c);
    }
    
    public void MoveCar() {
        //onDraw = true;
        for (int i = 0; i < cars.size(); i++) {
            //System.out.println(cars.size());
            //if(!cars.get(i).onMove){
            //cars.get(i).onMove = true;
            //cars.get(i).speed = 2;
            cars.get(i).move(cross);
            //}
        }
    }
    
    public void StopCar() {
        //onDraw = false;
        for (int i = 0; i < cars.size(); i++) {
            //cars.get(i).speed = 1;
            if (!stopOrNot(i)) {
                cars.get(i).move(cross);
            }
        }
    }
     
    public boolean stopOrNot(int pos) {
        
        
        if (pos == 0) {
            return false;
        } else if (cars.get(0).x < 480) {
            return false;
        } else if (cars.get(pos).x > 480 || (cars.get(pos).x < 480 && cars.get(pos - 1).x - cars.get(pos).x > 100)) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean addOrNot(){
        if(cars.get(cars.size() - 1).x < 50){
            return false;
        }else{
            return true;
        }
    }
}
