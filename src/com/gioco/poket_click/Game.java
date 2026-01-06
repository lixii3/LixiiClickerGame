package com.gioco.poket_click;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

/**
 * Classe centrale per la logica e l'inizializzazione del gioco.
 * Gestisce la creazione degli oggetti di gioco e la gestione dello stato del gioco.
 */
public class Game {
    private GamePanel gamePanel;
    private GameState gameState;
    private Timer gameTimer;
    
    // Costanti di layout
    private static final int UPGRADE_PANEL_X = 500;  // Lato destro dell'area di gioco
    private static final int UPGRADE_PANEL_WIDTH = 200;
    private static final int UPGRADE_BUTTON_HEIGHT = 80;
    private static final int UPGRADE_BUTTON_SPACING = 10;
    
    public Game(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.gameState = GameState.getInstance();
        initializeGame();
    }
    
    private void initializeGame() {
        // Aggiunge il display del punteggio
        ScoreDisplay scoreDisplay = new ScoreDisplay();
        scoreDisplay.setPosition(80, 50);
        scoreDisplay.setColor(Color.WHITE);
        scoreDisplay.setFont(new Font("Arial", Font.BOLD, 24));
        gamePanel.addObject(scoreDisplay);
        
        // Aggiunge il display dell'amore al secondo
        LovePerSecondDisplay lovePerSecDisplay = new LovePerSecondDisplay();
        lovePerSecDisplay.setPosition(80, 80);
        lovePerSecDisplay.setColor(Color.YELLOW);  // Colore diverso per distinguerlo
        lovePerSecDisplay.setFont(new Font("Arial", Font.PLAIN, 18));
        gamePanel.addObject(lovePerSecDisplay);
        
        // Crea il Pokemon principale cliccabile
        createMainPokemon();
        
        // Crea i pulsanti di upgrade con benefici moltiplicativi
        // benefit = aumento percentuale (0.1 = +10%, 0.5 = +50%, 1.0 = +100%, ecc.)
        createUpgradeButtons(
            new UpgradeConfig("+ 10% love\sec", 10, 0.1),    // +10% love/sec
            new UpgradeConfig("+ 25% love\\sec", 50, 0.25),   // +25% love/sec
            new UpgradeConfig("+ 50% love\\sec", 200, 0.5),   // +50% love/sec
            new UpgradeConfig("double love\\sec", 1000, 1.0) // +100% (doppio) love/sec
        );
        
        createResetButton();
        
        startGameLoop();
    }
    
    private void createResetButton() {
    	 ImageIcon buttonIcon = new ImageIcon(
    	            Game.class.getResource("/images/button.png"));
    	 Image buttonImage = buttonIcon.getImage();
    	 ClickEvent reset = new ClickEvent("reset") {
			
			@Override
			public void stop() {
			}
			
			@Override
			public void start() {
				GameState.getInstance().setLovePerSecond(0.1);
				GameState.getInstance().setScore(0);
			}
		};
		ButtonObject resetbutton = new ButtonObject(buttonImage, "RESET", reset);
        resetbutton.setPosition(200, 650);
        
        // Personalizza l'aspetto del testo
        resetbutton.setTextColor(Color.WHITE);
        resetbutton.setFont(new Font("Arial", Font.BOLD, 18));
        
        // Aggiunge al pannello di gioco
	    gamePanel.addObject(resetbutton);
	}

	private void createMainPokemon() {
        ImageIcon celebiIcon = new ImageIcon(
            Game.class.getResource("/images/baylees.png"));
        // Crea prima l'oggetto Pokemon
        ClickableObject celebi = new ClickableObject(300, 300, celebiIcon.getImage());
        
        // Posizionalo dopo la creazione
        celebi.setPosition(100, 150);
        
        // Collega l'evento di click
        celebi.setClickEvent(new PokeClickEvent());
        
        gamePanel.addObject(celebi);
    }
    
    /**
     * Crea multipli pulsanti di upgrade usando varargs.
     * Passa quanti oggetti UpgradeConfig vuoi!
     * 
     * Esempio:
     *   createUpgradeButtons(
     *       new UpgradeConfig("UPGRADE 1", 10, 0.1),   // +10% moltiplicatore
     *       new UpgradeConfig("UPGRADE 2", 50, 0.5)    // +50% moltiplicatore
     *   );
     */
    private void createUpgradeButtons(UpgradeConfig... upgrades) {
        // Carica l'immagine del pulsante una sola volta
        ImageIcon buttonIcon = new ImageIcon(
            Game.class.getResource("/images/button.png"));
        Image buttonImage = buttonIcon.getImage();
        
        // Crea un pulsante per ogni configurazione di upgrade
        for (int i = 0; i < upgrades.length; i++) {
            UpgradeConfig config = upgrades[i];
            createUpgradeButton(
                buttonImage,
                config.getText(),
                i,  // Indice per il posizionamento
                config.getCost(),
                config.getBenefit()
            );
        }
    }
    
    private void createUpgradeButton(Image buttonImage, String text, int index, int cost, double benefit) {
        // Calcola la posizione Y basata sull'indice
        int yPosition = UPGRADE_BUTTON_SPACING + index * (UPGRADE_BUTTON_HEIGHT + UPGRADE_BUTTON_SPACING);
        
        // Crea l'evento di click per questo upgrade
        UpgradeClickEvent upgradeEvent = new UpgradeClickEvent(
            text, 
            cost, 
            benefit, 
            gamePanel
        );
        
        // Crea l'oggetto pulsante
        ButtonObject upgradeButton = new ButtonObject(
            UPGRADE_PANEL_WIDTH - 20,  // Larghezza (con un po' di margine)
            UPGRADE_BUTTON_HEIGHT,
            buttonImage,
            text,
            upgradeEvent
        );
        
        // Posiziona il pulsante sul lato destro
        upgradeButton.setPosition(UPGRADE_PANEL_X + 10, yPosition);
        
        // Personalizza l'aspetto del testo
        upgradeButton.setTextColor(Color.WHITE);
        upgradeButton.setFont(new Font("Arial", Font.BOLD, 18));
        
        // Aggiunge al pannello di gioco
        gamePanel.addObject(upgradeButton);
    }
    
    private void startGameLoop() {
        // Aggiorna ogni 100ms (10 volte al secondo)
        gameTimer = new Timer(100, e -> {
            double lovePerSec = gameState.getLovePerSecond();
            
            if (lovePerSec > 0) {
                // Aggiunge 1/10 dell'amore al secondo (poiché stiamo aggiornando 10 volte al secondo)
                gameState.addScore(lovePerSec / 10.0);  // Ora gestisce i double correttamente!
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
