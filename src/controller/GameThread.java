package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.BoardView;
import view.GameView;
import view.InputScoreView;

public class GameThread extends Thread {
    private BoardView boardView;
    private GameView gameView;
//    private InputScoreView inputScoreView;
    private ScoreController scoreController;
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

                    if ((getScore() > 200) || (getScore() > 500) || (getScore() > 1000)) {
                        int timeNow = getTime() - 100;
                        setTime(timeNow);
                    }

                    boardView.moveBlockToBackground();
                    score += boardView.clearLines() * 2;
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
        gameView.startGame();
    }

    public void gameOver() {
        int finalScore = getScore();
        String playerName = JOptionPane.showInputDialog("Game Over!\nPlease enter your name");
        scoreController = new ScoreController(playerName, finalScore);
        scoreController.insertScore();
        resetGame();
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


