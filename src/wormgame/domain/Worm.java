/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;


import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
//import javafx.scene.paint.Color;
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
    public int wormSize=4;
    
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
    
    public void setDirection(Direction dir){
        this.direction=dir;
    }
    
    public int getLength(){
        return body.size();
    }
    
    public List<Piece> getPieces(){       
            return body;
    }
    
    public void move(){
        //later to do it
        onePiece=null;
        if(direction==Direction.UP){
           onePiece= new Piece(x,y+1);
   
        }else if(direction==Direction.DOWN){
            onePiece= new Piece(x,y-1);
            
        }else if(direction==Direction.LEFT){
            onePiece= new Piece(x-1,y);
            
        }else if(direction==Direction.RIGHT){
            onePiece= new Piece(x+1,y);
            
        }
         x=onePiece.getX();
         y=onePiece.getY();
         body.add(onePiece);
         
         if(body.size()>=wormSize)
                body.remove(0);
            
    }
    
    public void grow(){
        //do it later
        wormSize++;
    }
    
    public boolean runsInto(Piece piece){
        for(Piece pi:getPieces()){
            if(pi.runsInto(piece))
                return true;
            
        }
        return false;
            
    }
    
    public boolean runsIntoItself(){
        Piece pi = body.get(body.size()-1);
        List<Piece> list=body;
        if(list.size()>=2){
            for(int i=0; i<list.size()-1;i++){
                if(pi.runsInto(list.get(i)))
                    return true;

            }
        }
        return false;
            
    }
    
    public void draw(Graphics g, int pieceLength){
        for(Piece piece:body){
            g.setColor(Color.BLACK);
            g.fill3DRect(piece.getX(), piece.getY(), pieceLength, pieceLength, true);
        }
    }
}
