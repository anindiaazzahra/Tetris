package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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