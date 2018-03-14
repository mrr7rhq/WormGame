package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.*;
import wormgame.gui.Updatable;
import wormgame.gui.*;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
       
        
        worm= new Worm(width/2,height/2,Direction.DOWN);
        
        
        apple= creatRandomApple();

        addActionListener(this);
        setInitialDelay(2000);
        
        
        

    }
    public Apple creatRandomApple(){
        Random rd = new Random();
        return new Apple(rd.nextInt(width),rd.nextInt(height));
    }
    public Worm getWorm(){
        return worm;
    }
    
    public void setWorm(Worm worm){
        this.worm= worm;
    }
    
    public Apple getApple(){
        return apple;
    }
    
    public void setApple(Apple apple){
        this.apple=apple;
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            worm.move();
            if(worm.runsInto(apple)){
                worm.grow();
                apple=creatRandomApple();
            }
            if(worm.runsIntoItself()){
                continues=false;
            }
            
            updatable.update();//????????????????????????????????????????????????????????????
            this.setDelay(1000/worm.getLength());
                
            
            
        }

    }

}
