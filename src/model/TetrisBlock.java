package model;

import java.awt.Color;
import java.util.Random;

public class TetrisBlock {
    private int[][] shape;
    private Color color;
    private int x, y;
    private int[][][] shapes;
    private int currentRotation;
    
    public TetrisBlock(int[][] shape) {
       this.shape = shape;
       
       initShapes();
    }
    
    // logika nge rotasi blok
    public void initShapes() {
        shapes = new int[4][][];
        
        for(int i = 0; i < 4; i++) {
            
            // baris jd kolom, kolom jd baris
            int baris = shape[0].length;
            int kolom = shape.length;
            
            shapes[i] = new int[baris][kolom];
            for(int row = 0; row < baris; row++) {
                for(int col = 0; col < kolom; col++) {
                    shapes[i][row][col] = shape[kolom - col -1][row];
                }
            }
            shape = shapes[i];
        }
    }
    
    // fungsi spawn sekalian random rotasi
    public void spawn(int gridKolom) {
        
        Random random = new Random();
                
        currentRotation = random.nextInt(4);
        shape = shapes[currentRotation];
        
        x = (gridKolom - getWidth()) / 2;
        y = -getHeight();
    }
    
    public int[][] getShape() {
        return shape;
    }
    
    public Color getColor() {
        return color;
    }
    
    public int getHeight() {
        return shape.length;
    }
    
    public int getWidth() {
        return shape[0].length;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void moveRight() {
        x++;
    }
    
    public void moveLeft() {
        x--;
    }
    
    public void moveDown() {
        y++;
    }
    
    public void rotate() {
              
        if(currentRotation < 3) {
            currentRotation++;
        } else {
            currentRotation = 0;
        }
        shape = shapes[currentRotation];
    }
    
    public int getBottomEdge() {
        return getY() + getHeight();
    }
    
    public int getRightEdge() {
        return x + getWidth();
    }
    
    public int getLeftEdge() {
        return x;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }        
}
