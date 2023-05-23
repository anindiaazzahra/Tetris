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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.LeaderboardData;
import model.LeaderboardModel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class LeaderboardView extends JFrame {
    
    public static final int LEBAR = 600;
    public static final int TINGGI = 706;
    public JButton backBtn,deleteBtn;
    private JLabel titleLabel;
    private JPanel leaderboardPanel;
    private JTable leaderboardTable;
    private DefaultTableModel tableModel;
    
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
        
        // create leaderboard table
        String[] columnNames = {"Rank", "Player Name", "Score"};
        LeaderboardModel leaderboardModel = new LeaderboardModel();
        LeaderboardData leaderboardData = leaderboardModel.readLeaderboard();
        String[][] data = leaderboardData.getData().toArray(new String[0][0]);
        tableModel = new DefaultTableModel(data, columnNames);
        leaderboardTable = new JTable(tableModel);
        leaderboardTable.setBounds(240, 230, 360, 200);
        Font customFontLB = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/resources/fonts/PressStart2P.ttf"));
        Font fontLB = customFontLB.deriveFont(Font.PLAIN, 12);
        leaderboardTable.getTableHeader().setFont(fontLB);
        leaderboardTable.setRowHeight(25);
        leaderboardTable.setFont(fontLB);
        leaderboardTable.setEnabled(false);
        
        JScrollPane scrollPane = new JScrollPane(leaderboardTable);
        scrollPane.setBounds(240, 230, 360, 200);
        leaderboardPanel.add(scrollPane);
        
        // Membuat tombol penghapusan data
        deleteBtn = new JButton("RESET SCORE");
        deleteBtn.setPreferredSize(new Dimension(200, 50));
        deleteBtn.setBackground(Color.RED);
        deleteBtn.setForeground(Color.WHITE);
        
        // Mengatur tampilan tombol
        Font buttonFont = fontLB.deriveFont(Font.BOLD, 14);
        deleteBtn.setFont(buttonFont);
        Border buttonBorder = BorderFactory.createEmptyBorder(5, 10, 5, 10);
        deleteBtn.setBorder(buttonBorder);

        
     

        // Menambahkan tombol penghapusan di bawah tabel leaderboard
        leaderboardPanel.add(deleteBtn);
        
        // setContentPane(leaderboardPanel);
        add(leaderboardPanel);
        
        pack();
        setLocationRelativeTo(null);
        
        LeaderboardController leaderboardController = new LeaderboardController(this);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JTable getLeaderboardTable() {
        return leaderboardTable;
    }
    
    
    
    
}
