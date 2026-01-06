package com.gioco.poket_click;

import java.awt.Image;

public class ClickableObject extends GameObject {
    private ClickEvent clickEvent;

    // Costruttore completo
    public ClickableObject(int width, int height, int x, int y, Image sprite, ClickEvent clickEvent) {
        super(width, height, x, y, sprite);
        this.clickEvent = clickEvent;
    }
    
    // Costruttore senza posizione (default a 0,0)
    public ClickableObject(int width, int height, Image sprite, ClickEvent clickEvent) {
        super(width, height, sprite);
        this.clickEvent = clickEvent;
    }
    
    // Costruttore senza posizione e senza evento di click
    public ClickableObject(int width, int height, Image sprite) {
        this(width, height, sprite, null);
    }
    
    // Costruttore con solo lo sprite (usa la dimensione naturale dello sprite e nessun evento di click)
    public ClickableObject(Image sprite) {
        super(sprite);
        this.clickEvent = null;
    }

    public void onClick() {
        if (clickEvent != null) {
            clickEvent.start();
        }
    }
    
    public void setClickEvent(ClickEvent clickEvent) {
        this.clickEvent = clickEvent;
    }
    
    public ClickEvent getClickEvent() {
        return clickEvent;
    }
}
