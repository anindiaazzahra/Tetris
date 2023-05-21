package controller;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
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
    }
    
    public void readLeaderboard(){
        // ini yang akan di kerja besok
    }
}