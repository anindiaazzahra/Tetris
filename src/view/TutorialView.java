package view;

import controller.TutorialController;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.LeaderboardData;
import model.LeaderboardModel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class TutorialView extends JFrame {
    
    public static final int LEBAR = 600;
    public static final int TINGGI = 706;
    public JButton backBtn,deleteBtn;
    private JLabel titleLabel;
    private JPanel tutorialPanel;
    private JTable leaderboardTable;
    private DefaultTableModel tableModel;
    
    public TutorialView() throws FontFormatException, IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setPreferredSize(new Dimension(LEBAR, TINGGI));
        setBackground(new Color(38, 38, 38));

        JPanel tutorialPanel = new JPanel(new FlowLayout());
        
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
        
        titleLabel = new JLabel("TUTORIAL");
        
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/resources/fonts/PressStart2P.ttf"));
        Font font = customFont.deriveFont(Font.PLAIN, 28);
        titleLabel.setFont(font);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(0, 100, 210, 50);
        titleLabel.setForeground(Color.WHITE);
        
        backBtn.setBounds(80, 500, 50, 50);
        
        tutorialPanel.add(backBtn);
        tutorialPanel.add(titleLabel);
        tutorialPanel.setBackground(new Color(38, 38, 38));


        
     


        
        // setContentPane(leaderboardPanel);
        add(tutorialPanel);
        
        pack();
        setLocationRelativeTo(null);
        
        TutorialController tutorialController = new TutorialController(this);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JTable getLeaderboardTable() {
        return leaderboardTable;
    }
    
    
    
    
}
