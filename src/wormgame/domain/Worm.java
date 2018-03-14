/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;


import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import wormgame.Direction;

/**
 *
 * @author feihua
 */
public class Worm {
    public int x;
    public int y;
    public Direction direction;
    public List<Piece> body;
    public Piece onePiece;
    public int size=1;
    
    public Worm(int originalX, int originalY, Direction originalDirection){
        this.x=originalX;
        this.y=originalY;
        this.direction=originalDirection;
        body= new ArrayList<Piece>();
        onePiece=new Piece(originalX,originalY);
        body.add(onePiece);
        
    }
    
    public Direction getDirection(){
        return this.direction;
    }
    
    public void serDirection(Direction dir){
        this.direction=dir;
    }
    
    public int getLength(){
        return body.size();
    }
    
    public List<Piece> getPieces(){
        
            Collections.reverse(body);
            return body;
    }
    
    public void move(){
        //later to do it
        
        if(direction==Direction.UP)
           onePiece= new Piece(x,y+1);
            if(body.size()<4)
                body.add(onePiece);
            else 
                body.add(onePiece);
                
            
    }
    
    public void grow(){
        //do it later
    }
    
    public boolean runsInto(Piece piece){
        for(Piece pi:getPieces()){
            if(pi.getX()==piece.getX() && pi.getY()==piece.getY())
                return true;
            
        }
        return false;
            
    }
    
    public boolean runsIntoItself(){
        Piece pi = getPieces().get(0);
        List<Piece> list=getPieces();
        if(list.size()>=2){
            for(int i=1; i<list.size();i++){
                if(pi.getX()==list.get(i).getX() && pi.getY()==list.get(i).getY())
                    return true;

            }
        }
        return false;
            
    }
}
