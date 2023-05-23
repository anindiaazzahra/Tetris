package view;

import controller.ButtonKeyListener;
import controller.GameController;
import controller.GameThread;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;

public class PauseScreenView extends JFrame{
    public static final int LEBAR = 300, TINGGI = 360;
    private GameView gameView;
    private GameThread gameThread;
    private BoardView boardView;
    
    JPanel centerPanel = new JPanel();
    
    JLabel titleLabel = new JLabel("PAUSED");
    
    public JButton resumeBtn = new JButton();
    public JButton tutorialBtn = new JButton();
    public JButton quitBtn = new JButton();

    
    public PauseScreenView(GameView gameView, BoardView boardView) {
        
         this.gameView = gameView;
        this.boardView = boardView;
        
        setTitle("T E T R I S");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(LEBAR, TINGGI);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);
        setVisible(true);
        
                
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 12));
        
        int topMargin = 40;
        int leftMargin = 70;
        int bottomMargin = 0;
        int rightMargin = 70;
        
        centerPanel.setBorder(BorderFactory.createEmptyBorder(topMargin, leftMargin, bottomMargin, rightMargin));
        centerPanel.setBackground(new Color(38, 38, 38));
        
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(createStyledButton(resumeBtn, "RESUME"));
        centerPanel.add(createStyledButton(tutorialBtn, "TUTORIAL"));
        centerPanel.add(createStyledButton(quitBtn, "QUIT GAME"));
        centerPanel.add(Box.createVerticalGlue());
        
        resumeBtn.setBackground(new Color(70,173,49));

        getContentPane().add(titleLabel, BorderLayout.NORTH);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        getContentPane().setBackground(new Color(38, 38, 38));  
        
        changeFontType(titleLabel, 24);               
        
        EmptyBorder margin = new EmptyBorder(topMargin, leftMargin, bottomMargin, rightMargin);

        titleLabel.setBorder(margin);
        titleLabel.setForeground(Color.white);
        
       GameController gameController = new GameController(gameView, this, new GameThread(boardView, gameView), boardView);
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
        javax.swing.border.Border lineBorder2 = BorderFactory.createLineBorder(new Color(38, 38, 38), 4);
        javax.swing.border.Border lineBorder3 = BorderFactory.createLineBorder(new Color(63,63,63), 1);
        
        javax.swing.border.Border compoundBorder = BorderFactory.createCompoundBorder(lineBorder1,
                BorderFactory.createCompoundBorder(lineBorder2, lineBorder3));
        
        button.setBorder(compoundBorder);
        
        
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setText(text);
        button.setForeground(Color.WHITE);
        button.setFont(button.getFont().deriveFont(Font.BOLD));
        button.setBackground(new Color(138,138,137));
        
        button.setPreferredSize(new Dimension(180, 50));
        
        changeFontType(button, 16);
        
        return button;
    }
}
