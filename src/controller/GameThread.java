package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.BoardView;
import view.GameView;
import view.InputScoreView;

public class GameThread extends Thread {

    private BoardView board;
    private GameView frame;
    private InputScoreView inputScoreView;
    private ScoreController scoreController;
    private int score;
    private int time;

    public GameThread(BoardView board, GameView frame) {
        this.board = board;
        this.frame = frame;
    }

    @Override
    public void run() {
        // infinite loop
        setTime(800);
        while (true) {
            board.SpawnBlock();

            while (board.moveBlockDown() == true) {
                try {
                    Thread.sleep(getTime());
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if(board.isBlockOutOfBounds()) {
                
                gameOver();
                break;
            }
            
            // jika true, menambahkan kecepatan blok
            if((getScore() > 200) || (getScore() > 500) || (getScore() > 1000)){
                int timeNow = getTime() - 100;
                setTime(timeNow);
            }

            board.moveBlockToBackground();
            score += board.clearLines() * 2;
            frame.updateScore(score);
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
        frame.updateScore(0);
    }
    
     public void resetGame() {
        board.resetBackground();
        setTime(800);
        resetScore();
        frame.startGame();
    }
   
    
    public void gameOver() {
        int finalScore = getScore();
        inputScoreView = new InputScoreView(finalScore);
        inputScoreView.setVisible(true);
        inputScoreView.getInputButton().addActionListener(e -> {
            String playerName = inputScoreView.getInputPlayerName().getText();
            scoreController = new ScoreController(playerName, finalScore);
            scoreController.insertScore();
            resetGame();
            inputScoreView.dispose();
        });
    }
}