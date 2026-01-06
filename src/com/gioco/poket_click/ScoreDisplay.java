package com.gioco.poket_click;

/**
 * Mostra il punteggio corrente.
 * Ora estende DynamicTextObject per maggiore flessibilità!
 */
public class ScoreDisplay extends DynamicTextObject {
    
    public ScoreDisplay(String prefix) {
        super(prefix, () -> String.valueOf((int)GameState.getInstance().getScore()));
    }
    
    public ScoreDisplay() {
        this("Love possessed: ");
    }
}
