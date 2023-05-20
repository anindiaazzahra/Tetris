package model.tetrisblocks;

import model.TetrisBlock;
import java.awt.Color;

public class SShape extends TetrisBlock {
    
    public SShape() {
        super( new int[][]{ {0, 1, 1}, {1, 1, 0} });
        setColor(Color.decode("#00F000"));
    } 
}