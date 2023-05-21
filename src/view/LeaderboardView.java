package view;

import controller.LeaderboardController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeaderboardView extends JFrame {
    
    public static final int LEBAR = 600;
    public static final int TINGGI = 706;
    public JButton backBtn;
    private JLabel titleLabel;
    
    public LeaderboardView() throws FontFormatException, IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setPreferredSize(new Dimension(LEBAR, TINGGI));
        setBackground(new Color(38, 38, 38));

        JPanel leaderboardPanel = new JPanel(new FlowLayout());
        
        ImageIcon backIcon = new ImageIcon(getClass().getResource("/resources/icons/left-arrow.png"));
        ImageIcon originalIcon = backIcon;

        Image image = originalIcon.getImage();

        int newWidth = 50;
        int newHeight = 50;

        Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        backBtn = new JButton(resizedIcon);

        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setFocusPainted(false);
        backBtn.setOpaque(false);
        
        titleLabel = new JLabel("LEADERBOARD");
        
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/resources/fonts/PressStart2P.ttf"));
        Font font = customFont.deriveFont(Font.PLAIN, 28);
        titleLabel.setFont(font);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(0, 100, 210, 50);
        
        backBtn.setBounds(80, 500, 50, 50);
        
        leaderboardPanel.add(backBtn);
        leaderboardPanel.add(titleLabel);
        
        // setContentPane(leaderboardPanel);
        add(leaderboardPanel);
        
        pack();
        setLocationRelativeTo(null);
        
        LeaderboardController leaderboardController = new LeaderboardController(this);
    }
}
