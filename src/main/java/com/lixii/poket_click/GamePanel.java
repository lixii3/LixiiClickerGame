package com.lixii.poket_click;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {
    private List<GameObject> objects;

    public GamePanel() {
        objects = new ArrayList<>();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (GameObject obj : objects) {
                    if (obj instanceof ClickableObject clickable) {
                        if (clickable.contains(e.getX(), e.getY())) {
                            clickable.onClick();
                            repaint();
                        }
                    }
                }
            }
        });
    }

    public void addObject(GameObject obj) {
        objects.add(obj);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (GameObject obj : objects) {
            obj.draw(g);
        }
    }

    public void updateObjects() {
        for (GameObject obj : objects) {
            obj.update();
        }
    }
}