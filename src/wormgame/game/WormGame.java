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
    private Piece p;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
       
        
        worm= new Worm(width/2,height/2,Direction.DOWN);
        
       Apple temp;
       while(true){
            temp=creatRandomApple();
            if(temp.getX()==3 && temp.getY()==3){
                
                continue;
            }
            apple = temp;
            break;
       }
       
        
        

        addActionListener(this);
        setInitialDelay(2000);
        
        
        

    }
    public boolean appleOnWorm(Apple apple){
        for(Piece p:worm.getPieces()){
            if(p.runsInto(apple))
                return true;
                break;
        }
        return false;
    }
    public Apple creatRandomApple(){
        Random rd = new Random();
        int x=rd.nextInt(width);
        int y=rd.nextInt(height);
        Apple apple= new Apple(x,y);
        if(appleOnWorm(apple))
            creatRandomApple();
        for(Piece p:worm.getPieces()){
            if(p.runsInto(apple))
                creatRandomApple();
        }
                
                
                    
        
        return apple;
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
            return;
            
        }
            worm.move();
            if(worm.runsInto(apple)){
                worm.grow();
                apple=creatRandomApple();
            }
            if(worm.runsIntoItself()){
                continues=false;
            }
            if(worm.wormHead().getX()<=0 || worm.wormHead().getX()>=this.width)
                continues=false;
            if(worm.wormHead().getY()<=0 || worm.wormHead().getY()>=height)
                continues=false;
            
           
                
            updatable.update();
            this.setDelay(1000/worm.getLength());
         

    }

}
