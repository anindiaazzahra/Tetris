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
import view.ConfirmationView;
import view.TutorialView;

public class TutorialController {
    
    private TutorialView tutorialView;
    private ConfirmationView confirmationView;
    
    public TutorialController(TutorialView tutorialView) {
        this.tutorialView = tutorialView;
       
        tutorialView.backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SplashScreenView splashScreenView = null;
                splashScreenView = new SplashScreenView();
                splashScreenView.setVisible(true);
                tutorialView.dispose();
            }
        });
    }

 
}