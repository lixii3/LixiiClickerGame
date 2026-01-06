package com.gioco.poket_click;

public class PokeClickEvent extends ClickEvent {
    
    public PokeClickEvent() {
        super("Score Update");
    }
    
    @Override
    public void start() {
        GameState.getInstance().addScore(1);
        System.out.println("Gained +1 love");
    }
    
    @Override
    public void stop() {
        System.out.println("Stopped event");
    }
}
