package com.lixii.poket_click;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

public class Game {
    private GamePanel gamePanel;
    private GameState gameState;
    private Timer gameTimer;
    
    private static final int UPGRADE_PANEL_X = 500;
    private static final int UPGRADE_PANEL_WIDTH = 200;
    private static final int UPGRADE_BUTTON_HEIGHT = 80;
    private static final int UPGRADE_BUTTON_SPACING = 10;
    
    public Game(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.gameState = GameState.getInstance();
        initializeGame();
    }
    
    private void initializeGame() {
        ScoreDisplay scoreDisplay = new ScoreDisplay();
        scoreDisplay.setPosition(80, 50);
        scoreDisplay.setColor(Color.WHITE);
        scoreDisplay.setFont(new Font("Arial", Font.BOLD, 24));
        gamePanel.addObject(scoreDisplay);
        
        LovePerSecondDisplay lovePerSecDisplay = new LovePerSecondDisplay();
        lovePerSecDisplay.setPosition(80, 80);
        lovePerSecDisplay.setColor(Color.YELLOW);
        lovePerSecDisplay.setFont(new Font("Arial", Font.PLAIN, 18));
        gamePanel.addObject(lovePerSecDisplay);
        
        createMainPokemon();
        
        createUpgradeButtons(
            new UpgradeConfig("+ 10% love\\sec", 10, 0.1),
            new UpgradeConfig("+ 25% love\\sec", 50, 0.25),
            new UpgradeConfig("+ 50% love\\sec", 200, 0.5),
            new UpgradeConfig("double love\\sec", 1000, 1.0)
        );
        
        createResetButton();
        
        startGameLoop();
    }
    
    private void createResetButton() {
        ImageIcon buttonIcon = new ImageIcon(
            Game.class.getResource("/button.png"));
        Image buttonImage = buttonIcon.getImage();
        ButtonObject resetbutton = new ButtonObject(buttonImage, "RESET", (ClickableObject obj) ->
        {
            GameState.getInstance().setLovePerSecond(0.1);
            GameState.getInstance().setScore(0);
        });
        resetbutton.setPosition(200, 650);
        
        resetbutton.setTextColor(Color.WHITE);
        resetbutton.setFont(new Font("Arial", Font.BOLD, 18));
        
        gamePanel.addObject(resetbutton);
    }

    private void createMainPokemon() {
        ImageIcon celebiIcon = new ImageIcon(
            Game.class.getResource("/baylees.png"));
        ClickableObject celebi = new ClickableObject(300, 300, celebiIcon.getImage());
        celebi.setPosition(100, 150);
        celebi.setClickEvent((ClickableObject obj) -> {GameState.getInstance().addScore(1); obj.wobble();});
        
        gamePanel.addObject(celebi);
    }
    
    private void createUpgradeButtons(UpgradeConfig... upgrades) {
        ImageIcon buttonIcon = new ImageIcon(
            Game.class.getResource("/button.png"));
        Image buttonImage = buttonIcon.getImage();
        
        for (int i = 0; i < upgrades.length; i++) {
            UpgradeConfig config = upgrades[i];
            createUpgradeButton(
                buttonImage,
                config.getText(),
                i,
                config.getCost(),
                config.getBenefit()
            );
        }
    }
    
    private void createUpgradeButton(Image buttonImage, String text, int index, int cost, double benefit) {
        int yPosition = UPGRADE_BUTTON_SPACING + index * (UPGRADE_BUTTON_HEIGHT + UPGRADE_BUTTON_SPACING);
        
        ButtonObject upgradeButton = new ButtonObject(
            UPGRADE_PANEL_WIDTH - 20,
            UPGRADE_BUTTON_HEIGHT,
            buttonImage,
            text,
            (ClickableObject obj) -> {
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

                if (gamePanel != null) {
                    gamePanel.repaint();
                }
            }
        );
        
        upgradeButton.setPosition(UPGRADE_PANEL_X + 10, yPosition);
        
        upgradeButton.setTextColor(Color.WHITE);
        upgradeButton.setFont(new Font("Arial", Font.BOLD, 18));
        
        gamePanel.addObject(upgradeButton);
    }
    
    private void startGameLoop() {
        gameTimer = new Timer(10, e -> {
            double lovePerSec = gameState.getLovePerSecond();
            gamePanel.updateObjects();
            if (lovePerSec > 0) {
                gameState.addScore(lovePerSec / 10.0);
                gamePanel.repaint();
            }
        });
        gameTimer.start();
    }
    
    public GameState getGameState() {
        return gameState;
    }
    
    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
