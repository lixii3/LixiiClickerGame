package com.lixii.poket_click;

public class ScoreDisplay extends DynamicTextObject {
    
    public ScoreDisplay(String prefix) {
        super(prefix, () -> String.valueOf((int)GameState.getInstance().getScore()));
    }
    
    public ScoreDisplay() {
        this("Love possessed: ");
    }
}
