package com.lixii.poket_click;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.function.Consumer;

public class ButtonObject extends ClickableObject {
    private String text;
    private Color textColor;
    private Font font;
    
    public ButtonObject(int width, int height, Image sprite, String text, Consumer<ClickableObject> clickEvent) {
        super(width, height, sprite, clickEvent);
        this.text = text;
        this.textColor = Color.BLACK;
        this.font = new Font("Arial", Font.BOLD, 16);
    }
    
    public ButtonObject(Image sprite, String text, Consumer<ClickableObject> clickEvent) {
        super(sprite.getWidth(null), sprite.getHeight(null), sprite, clickEvent);
        this.text = text;
        this.textColor = Color.BLACK;
        this.font = new Font("Arial", Font.BOLD, 16);
    }
    
    public ButtonObject(int width, int height, Image sprite, String text) {
        this(width, height, sprite, text, null);
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public Color getTextColor() {
        return textColor;
    }
    
    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
    
    public Font getFont() {
        return font;
    }
    
    public void setFont(Font font) {
        this.font = font;
    }
    
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        
        if (text != null && !text.isEmpty()) {
            g.setColor(textColor);
            g.setFont(font);
            
            java.awt.FontMetrics metrics = g.getFontMetrics(font);
            int textWidth = metrics.stringWidth(text);
            int textHeight = metrics.getHeight();
            
            int textX = getX() + (getWidth() - textWidth) / 2;
            int textY = getY() + (getHeight() + textHeight / 2) / 2;
            
            g.drawString(text, textX, textY);
        }
    }
}
