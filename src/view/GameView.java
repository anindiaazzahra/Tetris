package view;

import controller.GameController;
import controller.GameThread;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class GameView extends JFrame {

    private SplashScreenView splashScreenView;
    private BoardView boardView;
    
    public static final int LEBAR = 600, TINGGI = 706;
    public JButton pauseBtn;
    private JLabel scoreLabel;   

    public GameView() throws FontFormatException, IOException {
        super("T E T R I S");

        scoreLabel = new JLabel("SCORE: 0");

        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setPreferredSize(new Dimension(LEBAR, TINGGI));
        setBackground(new Color(38, 38, 38));

        JPanel gridPanel = new JPanel(new GridBagLayout()) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (int y = 0; y < 22; y++) {
                    for (int x = 0; x < 12; x++) {
                        if (y == 0 || y == 21 || x == 0 || x == 11) {
                            g.setColor(Color.decode("#787878"));
                            g.fillRect(x * 30, y * 30, 30, 30);
                            g.setColor(Color.decode("#9A9A9A"));
                            g.drawRect(x * 30, y * 30, 30, 30);
                        }
                    }
                }
            }
        };
        gridPanel.setPreferredSize(new Dimension(361, 661));

        boardView = new BoardView();
        boardView.setPreferredSize(new Dimension(301, 600));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0; 
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;

        gridPanel.add(boardView, constraints);

        JPanel scorePanel = new JPanel(null);
        scorePanel.setPreferredSize(new Dimension(212, 600));
        //scorePanel.setBounds(0, 0, 800, 661);

        ImageIcon pauseIcon = new ImageIcon(getClass().getResource("/resources/icons/pause.png"));
        ImageIcon originalIcon = pauseIcon;

        Image image = originalIcon.getImage();

        int newWidth = 50;
        int newHeight = 50;

        Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        pauseBtn = new JButton(resizedIcon);

        pauseBtn.setBorderPainted(false);
        pauseBtn.setContentAreaFilled(false);
        pauseBtn.setFocusPainted(false);
        pauseBtn.setOpaque(false);
        
        
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/resources/fonts/PressStart2P.ttf"));
        Font font = customFont.deriveFont(Font.PLAIN, 20);
        scoreLabel.setFont(font);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setBounds(0, 100, 210, 50);
        
        pauseBtn.setBounds(80, 500, 50, 50);
        
        scorePanel.add(scoreLabel);
        scorePanel.add(pauseBtn);

        add(gridPanel);
        add(scorePanel);

        pack();

        setLocationRelativeTo(null);
        
        startGame();

        GameController gameController = new GameController(this);
    }

    public void startGame() {
        new GameThread(boardView, this).start();
    }

    public void updateScore(int score) {
        scoreLabel.setText("SCORE: " + score);
    }
    
    
    // jika pake inputSocreView
//    public void resetScore() {
//        updateScore(0);
//    }
//    
//     public void resetGame() {
//        boardView.resetBackground();
//        resetScore();
//        startGame();
//    }
    
    
    
}

