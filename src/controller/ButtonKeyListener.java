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

public class ButtonKeyListener {
    
    private SplashScreenView splashScreenView;
    private InputScoreView inputScoreView;
    
    public ButtonKeyListener(SplashScreenView splashScreenView) {
        this.splashScreenView = splashScreenView;
        
        splashScreenView.playBtn.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
      
                GameView gameView = null;
                try {
                    gameView = new GameView();
                } catch (FontFormatException ex) {
                    Logger.getLogger(ButtonKeyListener.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ButtonKeyListener.class.getName()).log(Level.SEVERE, null, ex);
                }
                gameView.setVisible(true);
                splashScreenView.dispose();
                
                
            }
        }); 
        
        splashScreenView.tutorialBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
      
                TutorialView tutorialView = null;
                try {
                    tutorialView = new TutorialView();
                } catch (FontFormatException ex) {
                    Logger.getLogger(ButtonKeyListener.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ButtonKeyListener.class.getName()).log(Level.SEVERE, null, ex);
                }
                tutorialView.setVisible(true);
                splashScreenView.dispose();  
            }
        });
        
        splashScreenView.leaderboardBtn.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
   
                LeaderboardView leaderboardView = null;
                try {
                    leaderboardView = new LeaderboardView();
                } catch (FontFormatException ex) {
                    Logger.getLogger(ButtonKeyListener.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ButtonKeyListener.class.getName()).log(Level.SEVERE, null, ex);
                }
                leaderboardView.setVisible(true);
                splashScreenView.dispose();
                
            }
        }); 
        
        splashScreenView.quitBtn.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
   
                System.exit(0);
                
            }
        });     
    }  
}  

