/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.game.WormGame;

/**
 *
 * @author bellia_2
 */
public class DrawingBoard extends JPanel implements Updatable{
    private WormGame wormGame;
    private int pieceLength;
    
    public DrawingBoard(WormGame wormGame,int pieceLength){
        this.wormGame=wormGame;
        this.pieceLength=pieceLength;
    }
    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
       
       
        g.setColor(Color.red);
        g.fillOval(wormGame.getApple().getX()*pieceLength, wormGame.getApple().getY()*pieceLength, pieceLength, pieceLength);
        wormGame.getWorm().draw(g, pieceLength);
      
    }

    @Override
    public void update() {
        this.repaint();

    }

    
}
