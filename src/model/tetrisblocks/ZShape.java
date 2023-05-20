package model.tetrisblocks;

import model.TetrisBlock;
import java.awt.Color;

public class ZShape extends TetrisBlock {
    
    public ZShape() {
        super( new int[][]{ {1, 1, 0}, {0, 1, 1} });
        setColor(Color.decode("#F00000"));
    } 
}