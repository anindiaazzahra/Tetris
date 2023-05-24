package controller;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.GameView;
import view.LeaderboardView;
import view.SplashScreenView;
import view.InputScoreView;
import view.TutorialView;

public class SplashScreenController {
    
    private SplashScreenView splashScreenView;
    private InputScoreView inputScoreView;
    
    // key listener untuk button di menu awal
    public SplashScreenController(SplashScreenView splashScreenView) {
        this.splashScreenView = splashScreenView;
        
        // key listener jika tombol play di klik
        splashScreenView.playBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
      
                GameView gameView = null;
                // try-catch untuk menangani pengecualian yang terjadi saat membuat objek GameView
                try {
                    gameView = new GameView();
                } catch (FontFormatException ex) {
                    Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
                // membuka frame game view
                gameView.setVisible(true);
                splashScreenView.dispose();
                
                
            }
        }); 
        
        // key listener jika tombol tutorial di klik
        splashScreenView.tutorialBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
      
                TutorialView tutorialView = null;
                try {
                    tutorialView = new TutorialView();
                } catch (FontFormatException ex) {
                    Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tutorialView.setVisible(true);
                splashScreenView.dispose();  
            }
        });
        
        // key listener jika tombol leaderboard di klik
        splashScreenView.leaderboardBtn.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
   
                LeaderboardView leaderboardView = null;
                try {
                    leaderboardView = new LeaderboardView();
                } catch (FontFormatException ex) {
                    Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
                leaderboardView.setVisible(true);
                splashScreenView.dispose();
                
            }
        }); 
        
        // key listener jika tombol quit di klik
        splashScreenView.quitBtn.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
   
                System.exit(0);
                
            }
        });     
    }  
}  

