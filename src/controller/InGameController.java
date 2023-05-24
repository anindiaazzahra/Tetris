package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BoardView;
import view.GameView;
import view.PauseScreenView;
import view.SplashScreenView;

public class InGameController {
    
    private GameView gameView;
    private PauseScreenView pauseScreenView;
    private GameThread gameThread;
    private BoardView boardView;
    private SplashScreenView splashScreenView;
    
    public InGameController(GameView gameView, GameThread gameThread, BoardView boardView) {
        this.gameView = gameView;
        this.gameThread = gameThread;
        // this.boardView = boardView;
        
        gameView.pauseBtn.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
                gameView.pauseGame();  
                pauseScreenView = new PauseScreenView(gameView, boardView);
                pauseScreenView.setVisible(true);
                boardView.unregisterKeyListener();
            }
        });
    }   
    
    public InGameController(GameView gameView, PauseScreenView pauseScreenView,  GameThread gameThread, BoardView boardView) {
        this.gameView = gameView;
        this.pauseScreenView = pauseScreenView;
        this.gameThread = gameThread;
        
        pauseScreenView.resumeBtn.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
                gameView.resumeGame();
                pauseScreenView.dispose();
                
                // Register the keyboard listener
                boardView.registerKeyListener();            
                // Request focus on the board view
                boardView.requestFocusInWindow();
            }
        });
        
        pauseScreenView.mainMenuBtn.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
                SplashScreenView splashScreenView = null;
                splashScreenView = new SplashScreenView();
                
                splashScreenView.setVisible(true);
                gameView.dispose();
                pauseScreenView.dispose();
                
                
                // Register the keyboard listener
                boardView.registerKeyListener();            
                // Request focus on the board view
                boardView.requestFocusInWindow();
                
            }
        });
        
        pauseScreenView.quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }   
}