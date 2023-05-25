package controller;

import model.ScoreModel;

public class ScoreController {
    
    private String playerName;
    private int finalScore;
    private ScoreModel scoreModel;


    public ScoreController(String playerName, int finalScore) {
        this.playerName = playerName;
        this.finalScore = finalScore;
    }

    public void insertScore(){
        scoreModel = new ScoreModel(getPlayerName(),getFinalScore()-10);
    }
    
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }
    
    
    
    
}
