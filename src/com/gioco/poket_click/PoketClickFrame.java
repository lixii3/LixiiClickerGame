package com.gioco.poket_click;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/* @liixii3
 * Finestra principale del gioco. Responsabile solo della configurazione della finestra e del layout.
 * La logica di gioco è delegata alla classe Game.
 */
public class PoketClickFrame extends JFrame {
    private static final int WIDTH = 720;
    private static final int HEIGHT = 820;
    private static final String TITLE = "Poket Click - by Liixii3";
    
    private Game game;
    
    public PoketClickFrame() {
        super(TITLE);
        setupWindow();
        initializeComponents();
    }
    
    private void setupWindow() {
        Image windowIcon = new ImageIcon(
            PoketClickFrame.class.getResource("/images/window_icon.jpg")).getImage();
        
        setIconImage(windowIcon);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }
    
    private void initializeComponents() {
        // Crea il pannello di gioco che riempie l'intera finestra
        GamePanel gamePanel = new GamePanel();
        gamePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        gamePanel.setBackground(Color.PINK); // Imposta un bel colore di sfondo
        
        // Inizializza il gioco (questo gestisce la creazione di tutti gli oggetti di gioco inclusi i pulsanti di upgrade)
        game = new Game(gamePanel);
        
        // Aggiunge il pannello di gioco per riempire l'intero frame
        add(gamePanel, BorderLayout.CENTER);
        
        // Finalizza la finestra
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        // sicurezza per i thread
        javax.swing.SwingUtilities.invokeLater(() -> {
            new PoketClickFrame();
        });
    }
}
