package models;

import processing.core.PApplet;

public class Circulo extends Figura {

    public Circulo(Posicion posicion, Dimension dimension, Borde borde, int color){
        super(posicion, dimension, borde, color);
    }

    public Circulo(){
        super();
    }

    @Override
    public void dibujar(PApplet p){
        configurarPropiedades(p);

        p.ellipse(
            posicion.getX(),
            posicion.getY(),
            dimension.getHorizontal(),
            dimension.getVertical()
        );
    }
}
