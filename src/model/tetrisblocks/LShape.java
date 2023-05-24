package model.tetrisblocks;

import model.TetrisBlock;
import java.awt.Color;

public class LShape extends TetrisBlock {
    
    public LShape() {
        super( new int[][]{ {1, 0}, 
                            {1, 0}, 
                            {1, 1} });
        setColor(Color.decode("#F0A100")); // orange
    } 
}
