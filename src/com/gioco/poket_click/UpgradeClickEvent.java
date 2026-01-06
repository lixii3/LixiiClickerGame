package com.gioco.poket_click;

/**
 * Evento di click per i pulsanti di upgrade.
 * Gestisce la logica dell'acquisto degli upgrade.
 */
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
        
        // Verifica se il giocatore può permetterselo
        if (state.getScore() < actualCost) {
            System.out.println("Not enough love! Need " + actualCost + ", have " + (int)state.getScore());
            return;
        }
        
        // Deduce il costo
        state.addScore(-actualCost);
        
        // Applica l'upgrade moltiplicativo all'amore al secondo
        // benefit è trattato come un moltiplicatore (es. 0.1 = aumento del 10%, quindi moltiplica per 1.1)
        double currentLovePerSec = state.getLovePerSecond();
        double newLovePerSec = currentLovePerSec * (1 + benefit);
        state.setLovePerSecond(newLovePerSec);
        
        System.out.println(getName() + " purchased! Cost: " + actualCost + 
                          " | Love/sec: " + String.format("%.2f", currentLovePerSec) + 
                          " → " + String.format("%.2f", newLovePerSec) + 
                          " (+" + (benefit * 100) + "%)");
        
        // Aggiorna il display
        if (gamePanel != null) {
            gamePanel.repaint();
        }
    }
    
    @Override
    public void stop() {
        // Non usato per gli upgrade
    }
}
