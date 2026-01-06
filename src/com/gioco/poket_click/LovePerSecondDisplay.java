package com.gioco.poket_click;

/**
 * Mostra il tasso attuale di generazione di amore al secondo.
 * Usa DynamicTextObject per flessibilità!
 */
public class LovePerSecondDisplay extends DynamicTextObject {
    
    public LovePerSecondDisplay(String prefix) {
        super(prefix, () -> String.format("%.2f", GameState.getInstance().getLovePerSecond()));
    }
    
    public LovePerSecondDisplay() {
        this("Love/sec: ");
    }
}
