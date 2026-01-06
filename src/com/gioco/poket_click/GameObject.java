package com.gioco.poket_click;

import java.awt.Graphics;
import java.awt.Image;

public abstract class GameObject {
    private int width, height;
    private int x, y;
    private Image sprite;
    
    // Costruttore completo
    public GameObject(int width, int height, int x, int y, Image sprite) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }
    
    // Costruttore con sprite, posizione di default a (0,0)
    public GameObject(Image sprite) {
        this(sprite.getWidth(null), sprite.getHeight(null), 0, 0, sprite);
    }
    
    // Costruttore con dimensione e sprite, posizione di default a (0,0)
    public GameObject(int width, int height, Image sprite) {
        this(width, height, 0, 0, sprite);
    }
    
    // Getters
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public Image getSprite() {
        return sprite;
    }
    
    // Setters per la posizione
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    // Metodo di convenienza per impostare entrambe le coordinate insieme
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // Setters per la dimensione (utile per ridimensionare)
    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    // Verifica se un punto è dentro i limiti di questo oggetto
    public boolean contains(int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + width &&
               mouseY >= y && mouseY <= y + height;
    }
    
    // Disegna questo oggetto
    public void draw(Graphics g) {
        if (sprite != null) {
            g.drawImage(sprite, x, y, width, height, null);
        }
    }
}
