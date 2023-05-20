package view;

import controller.GameThread;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.border.Border;
import view.BoardView;

public class GameView extends JFrame {

    public static final int LEBAR = 500, TINGGI = 706;
    private JLabel scoreLabel;
    private BoardView board;

    public GameView() {
        super("T E T R I S");

        scoreLabel = new JLabel("Score: 0");

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

        board = new BoardView();
        board.setPreferredSize(new Dimension(301, 600));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0; 
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;

        gridPanel.add(board, constraints);

        add(gridPanel);
        add(scoreLabel);

        pack();

        setLocationRelativeTo(null);

        startGame();
    }

    public void startGame() {
        new GameThread(board, this).start();
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }
}
