package models;

import processing.core.PApplet;

public class Elipse extends Figura{
    public Elipse(Posicion posicion, Dimension dimension, Borde borde, int color){
        super(posicion, dimension, borde, color);
    }
    
    @Override
    public void dibujar(PApplet p){
        
        configurarPropiedades(p);
        
        //Dibujar elipse
        p.ellipse(
            posicion.getX(),
            posicion.getY(),
            dimension.getHorizontal(),
            dimension.getVertical()
        );
    }
}
