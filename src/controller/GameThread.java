package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.BoardView;
import view.GameView;

public class GameThread extends Thread {

    private BoardView board;
    private GameView frame;
    private int score;

    public GameThread(BoardView board, GameView frame) {
        this.board = board;
        this.frame = frame;
    }

    @Override
    public void run() {
        // infinite loop
        while (true) {
            board.SpawnBlock();

            while (board.moveBlockDown() == true) {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if(board.isBlockOutOfBounds()) {
                System.out.println("Game Over");
                break;
            }

            board.moveBlockToBackground();
            score += board.clearLines();
            frame.updateScore(score);
        }
    }
}