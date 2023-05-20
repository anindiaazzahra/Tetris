package model.tetrisblocks;

import model.TetrisBlock;
import java.awt.Color;

public class JShape extends TetrisBlock {
    
    public JShape() {
        super( new int[][]{ {0, 1}, {0, 1}, {1, 1} });
        setColor(Color.decode("#0000F0"));
    } 
}
