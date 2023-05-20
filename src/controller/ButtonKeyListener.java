package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.GameView;
import view.SplashScreenView;

public class ButtonKeyListener {
    
    private SplashScreenView splashScreenView;
    
    public ButtonKeyListener(SplashScreenView splashScreenView) {
        this.splashScreenView = splashScreenView;
        
        splashScreenView.playBtn.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
                
                GameView gameView = new GameView();
                gameView.setVisible(true);
                splashScreenView.dispose();
            }
        });
    }   
}

