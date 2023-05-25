package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
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
    private int score = 0;
    private int time;
    private volatile boolean paused;
    private volatile boolean blockMoving;

    public GameThread(BoardView boardView, GameView gameView) {
        this.boardView = boardView;
        this.gameView = gameView;
    }

    // running game
    @Override
    public void run() {
        // infinite loop
        setTime(800);
        int miniScore = 200; // batas score untuk naik level
        while (true) {
            if (!paused) {
                // mengecek blok yang sedang jatuh
                if (!blockMoving) {
                    boardView.SpawnBlock();
                    blockMoving = true;
                    score += 10;                  
                }

                
                if (boardView.moveBlockDown()) {
                    try {
                        Thread.sleep(getTime());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    timePerLevel(level);
                } else {
                    if (boardView.isBlockOutOfBounds()) {
                        gameOver();
                        break;
                    }

                    boardView.moveBlockToBackground();
                    score += boardView.clearLines() * 50;
                    timePerLevel(level);
                    
                    System.out.println("Score sekarang = " + score);
                    System.out.println("Level = " + level);
                    System.out.println("Time Sekarang : " + getTime());
                    System.out.println("Score untuk naik level : " + miniScore);
                    System.out.println("-----------------------------------");
                    
                    if((score >= miniScore)){
                        level++;
                        miniScore += 200;
                        System.out.println("NAIK LEVEL");
                    }
                    gameView.updateLevel(level);
                    gameView.updateScore(score);
                    blockMoving = false; 
                }
            }            
        }
    }

    public void timePerLevel(int level){
        switch (level) {
            case 2: 
                setTime(700);
                break;
            case 4:
                setTime(600);
                break;
            case 8:
                setTime(500);
                break;
            case 10:
                setTime(400);
                break;
            case 12:
                setTime(300);
                break;
            case 15:
                setTime(200);
                break;
            case 20:
                setTime(100);
                break;
            case 25:
                setTime(80);
                break;
            default:
                // Tidak ada perubahan waktu untuk level lainnya
                break;
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
            gameView.dispose();
            splashScreenView = new SplashScreenView();
            splashScreenView.setVisible(true);
            inputScoreView.dispose();
        });
    }
    
    public void pauseGame() {
        paused = true;
        blockMoving = false;
    }

    public void resumeGame() {
        paused = false;
        blockMoving = true;
    }
}