package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;
import model.TetrisBlock;
import model.tetrisblocks.*;


public class BoardView extends JPanel implements KeyListener {

    // private JPanel GameArea = new JPanel();
            
    private int GRID_KOLOM = 10;
    private int GRID_BARIS = 20;
    private int UKURAN_KOTAK = 30;
    private Color[][] background; // buat block yg udah di bawah
    
    private TetrisBlock block;
    private TetrisBlock[] blocks;
    
    
    public BoardView() {

        this.setLayout(null);
        this.setBounds(0, 0, 301, 601);
        this.setBackground(new Color(38, 38, 38));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setFocusable(true);
        this.addKeyListener(this);
        
        background = new Color[GRID_BARIS][GRID_KOLOM];
        
        blocks = new TetrisBlock[]{ new IShape(),
                                    new JShape(),
                                    new LShape(),
                                    new OShape(),
                                    new SShape(),
                                    new TShape(),
                                    new ZShape() };
        SpawnBlock(); 
    }
   
    public void SpawnBlock() {
        
        Random random = new Random();
        
        block = blocks[ random.nextInt(blocks.length)];
        block.spawn(GRID_KOLOM);
    }
    
    public boolean isBlockOutOfBounds() {
        if(block.getY() < 0) {
            block = null;
            return true;
        }
        return false;
    }
        
    
    public boolean moveBlockDown() {
        if (checkBottom() == false) {
            
            return false;
        }
        
        block.moveDown(); // tambah kebawah kl blm sampe bawah
        repaint(); // gambar ulang blocknya di posisi baru
        
        return true;
    }
    
    public void moveBlockRight() {
        if(block == null) {
            return;
        }
        if(!checkRight()) {
            return;
        }
        block.moveRight();
        repaint();
    }
    
    public void moveBlockLeft() {
        if(block == null) {
            return;
        }
        if(!checkLeft()) {
            return;
        }
        block.moveLeft();
        repaint();
    }
    
    public void blockSpeedUp() {
        if(block == null) {
            return;
        }
        if(!checkBottom()) {
            return;
        }
        block.moveDown();
        repaint();
    }
    
    public void dropBlock() {
        if(block == null) {
            return;
        }
        while(checkBottom()) {
            block.moveDown();
        }       
        repaint();
    }
    
    public void rotateBlock() {
        
        if(block.getLeftEdge() < 0) {
            block.setX(0);
        }
        if(block.getRightEdge() >= GRID_KOLOM) {
            block.setX(GRID_KOLOM - block.getWidth());
        }
        if(block.getBottomEdge() < 0) {
            block.setY(1);
        }
        if(block.getBottomEdge() >= GRID_BARIS) {
            block.setY(GRID_BARIS - block.getHeight());
        }
        
        if(checkRight() && checkLeft() && checkBottom()) {
            block.rotate();
        }
        
        /*
        if(block == null) {
            return;
        }
        block.rotate();
        */               
        
        repaint();
    }
    
    private boolean checkBottom() {
  
        if(block.getBottomEdge() == GRID_BARIS) {
            return false;
        } 
        
        int[][]shape = block.getShape();
        int lebar = block.getWidth();
        int tinggi = block.getHeight();

        for(int kolom = 0; kolom < lebar; kolom++) {
            for(int baris = tinggi - 1; baris >= 0; baris--) {
                if(shape[baris][kolom] != 0) {
                    int x = kolom + block.getX();
                    int y = baris + block.getY() + 1;
                    if(y < 0) break;
                    if(background[y][x] != null) {
                        return false;
                    }
                    break;
                }                   
            }
        }
        return true;
    }
    
    private boolean checkRight() {
        if(block.getRightEdge() == GRID_KOLOM) {
            return false;
        }         int[][]shape = block.getShape();
        int lebar = block.getWidth();
        int tinggi = block.getHeight();
        
        for(int baris = 0; baris < tinggi; baris++) {
            for(int kolom = lebar -1; kolom >= 0; kolom--) {
                if(shape[baris][kolom] != 0) {
                    int x = kolom + block.getX() + 1;
                    int y = baris + block.getY();
                    if(y < 0) break;
                    if(background[y][x] != null) {
                        return false;
                    }
                    break;
                }                   
            }
        }
        return true;
    }
    
        private boolean checkLeft() {
        if(block.getLeftEdge() == 0) {
            return false;
        } 
        int[][]shape = block.getShape();
        int lebar = block.getWidth();
        int tinggi = block.getHeight();
        
        for(int baris = 0; baris < tinggi; baris++) {
            for(int kolom = 0; kolom < lebar; kolom++) {
                if(shape[baris][kolom] != 0) {
                    int x = kolom + block.getX() - 1;
                    int y = baris + block.getY();
                    if(y < 0) break;
                    if(background[y][x] != null) {
                        return false;
                    }
                    break;
                }                   
            }
        }
        return true;
    }
    
    public int clearLines() {
        
        boolean lineFilled;
        int linesCleared = 0;
        
        for(int baris = GRID_BARIS - 1; baris >= 0; baris--) {
            lineFilled = true;            
            for(int kolom = 0; kolom < GRID_KOLOM; kolom++) {
                if(background[baris][kolom] == null) {
                    lineFilled = false;
                    break; // gaperlu ngecek kolom selanjutnya
                }
            }
            
            if (lineFilled) {
                linesCleared++;
                clearLine(baris);
                shiftDown(baris);
                clearLine(0);
                baris++;
                
                repaint();
            }
        }
        return linesCleared;
    }
    
    private void clearLine(int baris) {
         for(int kolom = 0; kolom < GRID_KOLOM; kolom++) {
            background[baris][kolom] = null;
        }
    }
    
    private void shiftDown(int baris) {
        for(int row = baris; row > 0; row--) {
            for(int col = 0; col < GRID_KOLOM; col++) {
                background[row][col] = background[row - 1][col];
            }
        }
    }
        
    public void moveBlockToBackground() {
        int[][] shape = block.getShape();
        int h = block.getHeight();
        int w = block.getWidth();
        int x = block.getX();
        int y = block.getY();
        
        Color color = block.getColor();
        
        for (int baris = 0; baris < h; baris++) {
            for (int kolom = 0; kolom < w; kolom++) {
                
                if(shape[baris][kolom] == 1) {
                    background[y + baris][x + kolom] = color;
                }
            }
        } 
    }
    
    // drawing foreground, block yang lagi jatuh
    private void drawBlock(Graphics g) {
        int h = block.getHeight();
        int w = block.getWidth();
        Color color = block.getColor();
        int[][] shape = block.getShape();
        
        for (int baris = 0; baris < h; baris++) {
            for (int kolom = 0; kolom < w; kolom++) {
                
                // ngegambarnya per kotak
                if(shape[baris][kolom] == 1) {
                    
                            // posisinya    0, 1, 2, ....
                    int x = (block.getX() + kolom) * UKURAN_KOTAK;
                    int y = (block.getY() + baris) * UKURAN_KOTAK;
                    
                    drawGridSquare(g, color, x, y);
                }
            }
        }     
    }
    
    private void drawBackground(Graphics g) {
    
        Color color;
        
        for (int baris = 0; baris < GRID_BARIS; baris++) {
            for (int kolom = 0; kolom < GRID_KOLOM; kolom++) {
                
                color = background[baris][kolom];
                
                // gambar per kotak
                if(color != null) {
                    
                    int x = kolom * UKURAN_KOTAK;
                    int y = baris * UKURAN_KOTAK;
                    
                    drawGridSquare(g, color, x, y);
                }
            }
        }  
    }
    
    private void drawGridSquare(Graphics g, Color color, int x, int y) {
        
        g.setColor(color); // ngewarnain blocknya
        g.fillRect(x, y, UKURAN_KOTAK, UKURAN_KOTAK); // ngegambar blocknya
        g.setColor(new Color(38, 38, 38)); // ngewarnain outline
        g.drawRect(x, y, UKURAN_KOTAK, UKURAN_KOTAK); // mgegambar outline
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);                
        
        drawBackground(g);
        drawBlock(g);
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                moveBlockRight();
                break;
            case KeyEvent.VK_LEFT:
                moveBlockLeft();
                break;
            case KeyEvent.VK_UP:
                rotateBlock();
                break;
            case KeyEvent.VK_DOWN:
                blockSpeedUp();
                break;
            case KeyEvent.VK_SPACE:
                dropBlock();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
