package com.lixii.poket_click;

import java.awt.Graphics;
import java.util.function.Supplier;

public class DynamicTextObject extends TextObject {
    private String prefix;
    private Supplier<String> valueSupplier;
    
    public DynamicTextObject(String prefix, Supplier<String> valueSupplier) {
        super(prefix + "0");
        this.prefix = prefix;
        this.valueSupplier = valueSupplier;
    }
    
    @Override
    public void draw(Graphics g) {
        setText(prefix + valueSupplier.get());
        super.draw(g);
    }
}
