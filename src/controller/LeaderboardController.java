package controller;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.table.DefaultTableModel;
import model.LeaderboardModel;
import model.DeleteDataLeaderboard;
import view.LeaderboardView;
import view.SplashScreenView;

public class LeaderboardController {
    
    private LeaderboardView leaderboardView;
    
    public LeaderboardController(LeaderboardView leaderboardView) {
        this.leaderboardView = leaderboardView;
        
        leaderboardView.backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SplashScreenView splashScreenView = null;
                splashScreenView = new SplashScreenView();
                splashScreenView.setVisible(true);
                leaderboardView.dispose();
            }
        });
        
        // Menambahkan ActionListener pada tombol penghapusan
        leaderboardView.deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAllData();
            }
        });
    }
    
    private void deleteAllData() {
        // Menghapus semua data dari database dan leaderboard
        DeleteDataLeaderboard deleteLeaderboardModel = new DeleteDataLeaderboard();
        deleteLeaderboardModel.deleteAllData();

        // Menghapus semua data dari tabel leaderboard
        DefaultTableModel tableModel1 = (DefaultTableModel) leaderboardView.getLeaderboardTable().getModel();
        tableModel1.setRowCount(0);
    }
    
 
}