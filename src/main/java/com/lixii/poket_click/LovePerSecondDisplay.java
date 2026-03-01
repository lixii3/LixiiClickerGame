package com.lixii.poket_click;

public class LovePerSecondDisplay extends DynamicTextObject {
    
    public LovePerSecondDisplay(String prefix) {
        super(prefix, () -> String.format("%.2f", GameState.getInstance().getLovePerSecond()));
    }
    
    public LovePerSecondDisplay() {
        this("Love/sec: ");
    }
}
