package com.lixii.poket_click;

public class UpgradeClickEvent extends ClickEvent {
    private int cost;
    private double benefit;
    private GamePanel gamePanel;
    
    public UpgradeClickEvent(String name, int cost, double benefit, GamePanel gamePanel) {
        super(name);
        this.cost = cost;
        this.benefit = benefit;
        this.gamePanel = gamePanel;
    }
    
    @Override
    public void start() {
        GameState state = GameState.getInstance();
        int actualCost = cost ;
        
        if (state.getScore() < actualCost) {
            System.out.println("Not enough love! Need " + actualCost + ", have " + (int)state.getScore());
            return;
        }
        
        state.addScore(-actualCost);
        
        double currentLovePerSec = state.getLovePerSecond();
        double newLovePerSec = currentLovePerSec * (1 + benefit);
        state.setLovePerSecond(newLovePerSec);
        
        System.out.println(getName() + " purchased! Cost: " + actualCost + 
                          " | Love/sec: " + String.format("%.2f", currentLovePerSec) + 
                          " \u2192 " + String.format("%.2f", newLovePerSec) +
                          " (+" + (benefit * 100) + "%)");
        
        if (gamePanel != null) {
            gamePanel.repaint();
        }
    }
    
    @Override
    public void stop() {
    }
}
