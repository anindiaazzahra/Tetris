package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.BoardView;
import view.GameView;
import view.InputScoreView;
import view.SplashScreenView;

public class GameThread extends Thread {

    private BoardView boardView;
    private GameView gameView;
    private SplashScreenView splashScreenView;
    private InputScoreView inputScoreView;
    private ScoreController scoreController;
    private int level = 1;
    private int score;
    private int time;
    private volatile boolean paused;
    private volatile boolean blockFrozen;
    private volatile boolean blockMoving;

    public GameThread(BoardView boardView, GameView gameView) {
        this.boardView = boardView;
        this.gameView = gameView;
    }

    @Override
    public void run() {
        // infinite loop
        setTime(800);

        while (true) {
            while (paused) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (!blockFrozen) {
                if (!blockMoving) {
                    boardView.SpawnBlock();
                    blockMoving = true;
                    score += 5;
                }

                if (boardView.moveBlockDown()) {
                    try {
                        Thread.sleep(getTime());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (boardView.isBlockOutOfBounds()) {
                        gameOver();
                        break;
                    }

                    /*
                    if ((getScore() > 100)) {
                        setTime(500);
                    } else if(getScore() > 400){
                        setTime(300);
                    }else if (getScore() > 1000){
                        setTime(100);
                    }*/
                    
                    if(level % 2 == 0) {
                        
                    }

                    boardView.moveBlockToBackground();
                    score += boardView.clearLines() * 10;
                    if((score % 100 == 0) && score != 0) {
                        level++;
                    }
                    gameView.updateLevel(level);
                    gameView.updateScore(score);
                    blockMoving = false; 
                }
            }            
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    public int getScore() {
        return score;
    }

    public void resetScore() {
        gameView.updateScore(0);
    }
    
     public void resetGame() {
        boardView.resetBackground();
        setTime(800);
        resetScore();
        startGame();
    }
     
    public void startGame() {
        //new GameThread(boardView, this).start();
        start();
    }
   
    
    public void gameOver() {
        int finalScore = getScore();
        inputScoreView = new InputScoreView(finalScore);
        inputScoreView.setVisible(true);
        inputScoreView.getInputButton().addActionListener(e -> {
            String playerName = inputScoreView.getInputPlayerName().getText();
            scoreController = new ScoreController(playerName, finalScore);
            scoreController.insertScore();
            //resetGame();
            gameView.dispose();
            splashScreenView = new SplashScreenView();
            splashScreenView.setVisible(true);
            inputScoreView.dispose();
        });
    }
    
    public void pauseGame() {
        paused = true;
        blockFrozen = true;
        blockMoving = false;
    }

    public void resumeGame() {
        paused = false;
        blockFrozen = false;
        blockMoving = true;
    }
}