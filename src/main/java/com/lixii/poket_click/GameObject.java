package com.lixii.poket_click;

import java.awt.Graphics;
import java.awt.Image;

public abstract class GameObject {
    private int width, height;
    private float scaleX = 1, scaleY = 1;
    private int x, y;
    private Image sprite;
    
    public GameObject(int width, int height, int x, int y, Image sprite) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }
    
    public GameObject(Image sprite) {
        this(sprite.getWidth(null), sprite.getHeight(null), 0, 0, sprite);
    }
    
    public GameObject(int width, int height, Image sprite) {
        this(width, height, 0, 0, sprite);
    }
    
    public int getWidth() {
        return (int)(width * scaleX);
    }
    
    public int getHeight() {
        return (int)(height * scaleY);
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
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }

    public void setScaleX(float x) {
        this.scaleX = x;
    }

    public void setScaleY(float y) {
        this.scaleY = y;
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
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
    
    public boolean contains(int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + width &&
               mouseY >= y && mouseY <= y + height;
    }
    
    public void draw(Graphics g) {
        if (sprite != null) {
            g.drawImage(sprite, x, y, getWidth(), getHeight(), null);
        }
    }

    public void update(){};
}
