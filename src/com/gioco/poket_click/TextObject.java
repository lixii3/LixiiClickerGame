package com.gioco.poket_click;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TextObject extends GameObject {
    private String text;
    private Color color;
    private Font font;

    // Costruttore con posizione
    public TextObject(int x, int y, String text) {
        super(0, 0, x, y, null);
        this.text = text;
        this.color = Color.BLACK;
        this.font = new Font("Arial", Font.BOLD, 24);
    }
    
    // Costruttore senza posizione (default a 0,0)
    public TextObject(String text) {
        this(0, 0, text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.setFont(font);
        g.drawString(text, getX(), getY());
    }
}
