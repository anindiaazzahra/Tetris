package controller;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.GameView;
import view.SplashScreenView;

public class InGameKeyListener {
    
    private GameView gameView;
    
    public InGameKeyListener(GameView gameView) {
        this.gameView = gameView;
        
        gameView.pauseBtn.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
                
                System.out.println("pressed");
                SplashScreenView splashScreenView = null;
                splashScreenView = new SplashScreenView();
                splashScreenView.setVisible(true);
                gameView.dispose();
            }
        });
    }   
}