package com.gioco.poket_click;

import java.awt.Graphics;
import java.util.function.Supplier;

/**
 * Un TextObject che aggiorna il suo contenuto dinamicamente basandosi su una funzione supplier.
 * Molto flessibile - può mostrare qualsiasi valore dinamico!
 */
public class DynamicTextObject extends TextObject {
    private String prefix;
    private Supplier<String> valueSupplier;
    
    /**
     * Crea un oggetto di testo dinamico
     * @param prefix Il testo prima del valore dinamico (es. "Punteggio: ")
     * @param valueSupplier Una funzione che restituisce il valore corrente da visualizzare
     */
    public DynamicTextObject(String prefix, Supplier<String> valueSupplier) {
        super(prefix + "0");
        this.prefix = prefix;
        this.valueSupplier = valueSupplier;
    }
    
    @Override
    public void draw(Graphics g) {
        // Aggiorna il testo con il valore corrente prima di disegnare
        setText(prefix + valueSupplier.get());
        super.draw(g);
    }
}
