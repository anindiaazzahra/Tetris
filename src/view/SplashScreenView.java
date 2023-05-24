package view;

import controller.SplashScreenController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;

public class SplashScreenView extends JFrame {
    
    public static final int LEBAR = 600, TINGGI = 706;
    private GameView gameView;
    private BoardView boardView;
    
    JPanel centerPanel = new JPanel();
    
    JLabel titleLabel = new JLabel("TETRIS");
    
    public JButton playBtn = new JButton();
    public JButton tutorialBtn = new JButton();
    public JButton leaderboardBtn = new JButton();
    public JButton quitBtn = new JButton();
    
    public SplashScreenView() {
        setTitle("T E T R I S");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(LEBAR, TINGGI);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);
        setVisible(true);
        
                
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        
        int topMargin = 100;
        int leftMargin = 100;
        int bottomMargin = 0;
        int rightMargin = 100;
        
        centerPanel.setBorder(BorderFactory.createEmptyBorder(topMargin, leftMargin, bottomMargin, rightMargin));
        centerPanel.setBackground(new Color(38, 38, 38));
        
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(createStyledButton(playBtn, "PLAY"));
        centerPanel.add(createStyledButton(tutorialBtn, "TUTORIAL"));
        centerPanel.add(createStyledButton(leaderboardBtn, "LEADERBOARD"));
        centerPanel.add(createStyledButton(quitBtn, "QUIT GAME"));
        centerPanel.add(Box.createVerticalGlue());
        
        playBtn.setBackground(new Color(70,173,49));

        getContentPane().add(titleLabel, BorderLayout.NORTH);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        getContentPane().setBackground(new Color(38, 38, 38));  
        
        changeFontType(titleLabel, 64);               
        
        EmptyBorder margin = new EmptyBorder(topMargin, leftMargin, bottomMargin, rightMargin);

        titleLabel.setBorder(margin);
        titleLabel.setForeground(Color.white);
        
        
       SplashScreenController buttonKeyListener = new SplashScreenController(this);
    }
    
    public static JComponent changeFontType(JComponent component, int fontSize) {
        try {
            Font tetrisFont = Font.createFont(Font.TRUETYPE_FONT, SplashScreenView.class.getResourceAsStream("/resources/fonts/PressStart2P.ttf"));
            tetrisFont = tetrisFont.deriveFont(Font.PLAIN, fontSize);
            component.setFont(tetrisFont);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return component;
    }
    
    private JButton createStyledButton(JButton button, String text) {
        javax.swing.border.Border lineBorder1 = BorderFactory.createLineBorder(new Color(63,63,63), 1);
        javax.swing.border.Border lineBorder2 = BorderFactory.createLineBorder(new Color(38, 38, 38), 7);
        javax.swing.border.Border lineBorder3 = BorderFactory.createLineBorder(new Color(63,63,63), 1);
        
        javax.swing.border.Border compoundBorder = BorderFactory.createCompoundBorder(lineBorder1,
                BorderFactory.createCompoundBorder(lineBorder2, lineBorder3));
        
        button.setBorder(compoundBorder);
        
        
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setText(text);
        button.setForeground(Color.WHITE);
        button.setFont(button.getFont().deriveFont(Font.BOLD));
        button.setBackground(new Color(138,138,137));
        
        button.setPreferredSize(new Dimension(280, 70));
        
        changeFontType(button, 22);
        
        return button;
    }
}
