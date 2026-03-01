package com.lixii.poket_click;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.function.Consumer;

public class ClickableObject extends GameObject {
    private Consumer<ClickableObject> clickEvent;
    private float wobbleAmount = 0;

    public ClickableObject(int width, int height, int x, int y, Image sprite, Consumer<ClickableObject> clickEvent) {
        super(width, height, x, y, sprite);
        this.clickEvent = clickEvent;
    }
    
    public ClickableObject(int width, int height, Image sprite, Consumer<ClickableObject> clickEvent) {
        super(width, height, sprite);
        this.clickEvent = clickEvent;
    }
    
    public ClickableObject(int width, int height, Image sprite) {
        this(width, height, sprite, null);
    }

    @Override
    public void update() {
        setScaleY(0.5f + Math.abs((float)Math.sin(3.14f/2f * (1 + wobbleAmount * 4f)))/2f);
        setScaleX(0.5f + Math.abs((float)Math.cos(3.14f/2f * wobbleAmount * 2f))/2f);

        if (wobbleAmount > 0)
            wobbleAmount -= 0.05f * wobbleAmount;
        else
            wobbleAmount = 0;
    }

    public ClickableObject(Image sprite) {
        super(sprite);
        this.clickEvent = null;
    }

    public void onClick() {
        if (clickEvent != null) {
            clickEvent.accept(this);
        }
    }
    
    public void setClickEvent(Consumer<ClickableObject> clickEvent) {
        this.clickEvent = clickEvent;
    }
    
    public Consumer<ClickableObject> getClickEvent() {
        return clickEvent;
    }

    public void wobble() {
        wobbleAmount = 1f;
        try {
            InputStream audioSrc = getClass().getResourceAsStream("/mhanz.wav");
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
