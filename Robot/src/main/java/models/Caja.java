package models;

import processing.core.PApplet;

public class Caja extends Figura {

    public Caja(Posicion posicion, Dimension dimension, Borde borde, int color) {
        super(posicion, dimension, borde, color);
    }

    public Caja() {
        super();
    }

    @Override
    public void dibujar(PApplet p) {
        configurarPropiedades(p);

        p.rect(
            posicion.getX(),
            posicion.getY(),
            dimension.getHorizontal(),
            dimension.getVertical()
        );
    }
}