package model.tetrisblocks;

import model.TetrisBlock;
import java.awt.Color;


public class IShape extends TetrisBlock {
    
    public IShape() {
        super( new int[][]{ {1, 1, 1, 1} });
        setColor(Color.decode("#00F0F0"));
    } 
    
    @Override
    public void rotate() {
    
        super.rotate();
        
        if(this.getWidth() == 1) {
            this.setX(this.getX() + 1); // kanan
            this.setY(this.getY() - 1); // naik
        } else {
           this.setX(this.getX() - 1); // left
           this.setY(this.getY() + 1); // bawah
        }
    }
}