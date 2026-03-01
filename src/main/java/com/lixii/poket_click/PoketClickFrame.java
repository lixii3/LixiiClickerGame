package com.lixii.poket_click;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

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
            PoketClickFrame.class.getResource("/window_icon.jpg")).getImage();
        
        setIconImage(windowIcon);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }
    
    private void initializeComponents() {
        GamePanel gamePanel = new GamePanel();
        gamePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        gamePanel.setBackground(Color.PINK);

        game = new Game(gamePanel);
        
        add(gamePanel, BorderLayout.CENTER);
        
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new PoketClickFrame();
        });
    }
}
