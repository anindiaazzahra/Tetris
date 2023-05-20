package model.tetrisblocks;

import model.TetrisBlock;
import java.awt.Color;

public class TShape extends TetrisBlock {
    
    public TShape() {
        super( new int[][]{ {1, 1, 1}, {0, 1, 0} });
        setColor(Color.decode("#A100F0"));
    } 
}