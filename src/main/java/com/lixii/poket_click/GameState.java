package com.lixii.poket_click;

public class GameState {
    private static GameState instance;
    
    private double score;
    private double lovePerSecond;
    
    private GameState() {
        this.score = 0.0;
        this.lovePerSecond =0.1;
    }
    
    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }
    
    public void addScore(double amount) {
        score += amount;
    }
    
    public double getScore() {
        return score;
    }
    
    public int getScoreAsInt() {
        return (int) score;
    }
    
    public double getLovePerSecond() {
        return lovePerSecond;
    }
    
    public void setLovePerSecond(double lovePerSecond) {
        this.lovePerSecond = lovePerSecond;
    }
    
    public void setScore(double score) {
        this.score = score;
    }
    
    public void resetScore() {
        this.score = 0.0;
    }
    
    public void addLovePerSecond(double amount) {
        lovePerSecond += amount;
    }
}
