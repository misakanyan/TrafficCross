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
public class tateLane extends lane{
    
    public tateLane(int x,int y,int w,int h){
        super();
        posX = x;
        posY = y;
        width = w;
        height = h; 
        cross = false;
    }
    
    public void AddCar() {
        car c = new car(posX+25,posY-100,30,60);
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
        } else if (cars.get(0).y < 240) {
            return false;
        } else if (cars.get(pos).y > 240 || (cars.get(pos).y < 240 && cars.get(pos - 1).y - cars.get(pos).y > 100)) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean addOrNot(){
        if(cars.get(cars.size() - 1).y < 50){
            return false;
        }else{
            return true;
        }
    }
}
