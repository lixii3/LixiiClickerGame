package com.gioco.poket_click;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {
    private List<GameObject> objects; // lista di oggetti da disegnare

    public GamePanel() {
        objects = new ArrayList<>();

        // Listener per i click del mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (GameObject obj : objects) {
                    if (obj instanceof ClickableObject clickable) {
                        if (clickable.contains(e.getX(), e.getY())) {
                            clickable.onClick(); // esegue l'evento associato
                            repaint();           // ridisegna il pannello
                        }
                    }
                }
            }
        });
    }

    // Metodo per aggiungere un oggetto al pannello
    public void addObject(GameObject obj) {
        objects.add(obj);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Disegna tutti gli oggetti
        for (GameObject obj : objects) {
            obj.draw(g);
        }
    }
}