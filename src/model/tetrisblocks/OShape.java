package model.tetrisblocks;

import model.TetrisBlock;
import java.awt.Color;

public class OShape extends TetrisBlock {
    
    public OShape() {
        super( new int[][]{ {1, 1}, 
                            {1, 1}});
        setColor(Color.decode("#F0F000")); // kuning
    } 
}