package view;

import controller.TutorialController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TutorialView extends JFrame {
    
    public static final int LEBAR = 600;
    public static final int TINGGI = 706;
    public JButton backBtn, deleteBtn;
    private JLabel titleLabel, arrowKeyLabel, spaceKeyLabel;
    private JPanel tutorialPanel;
    private JTable leaderboardTable;
    private DefaultTableModel tableModel;
    
    public TutorialView() throws FontFormatException, IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setPreferredSize(new Dimension(LEBAR, TINGGI));
        setBackground(new Color(38, 38, 38));

        tutorialPanel = new JPanel();
        
        ImageIcon backIcon = new ImageIcon(getClass().getResource("/resources/icons/arrow.png"));
        ImageIcon originalIcon = backIcon;

        Image image = originalIcon.getImage();

        int newWidth = 34;
        int newHeight = 30;

        Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        backBtn = new JButton(resizedIcon);

        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setFocusPainted(false);
        backBtn.setOpaque(false);
        
        titleLabel = new JLabel("TUTORIAL");
        
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/resources/fonts/PressStart2P.ttf"));
        Font font = customFont.deriveFont(Font.PLAIN, 28);
        titleLabel.setFont(font);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        
        
        tutorialPanel.add(backBtn);
        tutorialPanel.add(titleLabel);
        tutorialPanel.setBackground(new Color(38, 38, 38));
        tutorialPanel.setLayout(null);
        
        backBtn.setBounds(20, 20, 40, 40);
        titleLabel.setBounds(100, 80, 400, 50);
        
        // set label w icon
        ImageIcon arrowKey = new ImageIcon(getClass().getResource("/resources/icons/arrow-key-img.jpg"));
        Image arrowKeyImage = arrowKey.getImage();
        
        newWidth = 212; 
        newHeight = 222; 
        
        resizedImage = arrowKeyImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(resizedImage);
        
        arrowKeyLabel = new JLabel(resizedIcon);
        
        
        ImageIcon spaceKey = new ImageIcon(getClass().getResource("/resources/icons/space-img.jpg"));
        Image spaceKeyImage = spaceKey.getImage();

        newWidth = 262; 
        newHeight = 110; 

        resizedImage = spaceKeyImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(resizedImage);

        spaceKeyLabel = new JLabel(resizedIcon);
        

        tutorialPanel.add(arrowKeyLabel);
        arrowKeyLabel.setBounds(180, 180, 212, 222);
        tutorialPanel.add(spaceKeyLabel);
        spaceKeyLabel.setBounds(160, 460, 262, 110);
        add(tutorialPanel);
        
        pack();
        setLocationRelativeTo(null);
        
        TutorialController tutorialController = new TutorialController(this);
    }        
}
