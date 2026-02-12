package models;

import processing.core.PApplet;
import nuevopoo.InterfaceFiguras;


abstract class Figura implements InterfaceFiguras{

    protected Posicion posicion;
    protected Dimension dimension;
    protected Borde borde;
    protected int color;

    public Figura(Posicion posicion, Dimension dimension, Borde borde, int color){
        this.posicion = posicion;
        this.dimension = dimension;
        this.borde = borde;
        this.color = color;
    }

    public Figura(){
        this(new Posicion(), new Dimension(), new Borde(), 255);
    }

    // Getters
    public Posicion getPosicion(){
        return posicion;
    }

    public Dimension getDimension(){
        return dimension;
    }

    public Borde getBorde(){
        return borde;
    }

    public int getColor(){
        return color;
    }

    // Setters
    public void setPosicion(Posicion nuevaPosicion){
        this.posicion = nuevaPosicion;
    }

    public void setDimension(Dimension nuevaDimension){
        this.dimension = nuevaDimension;
    }

    public void setBorde(Borde nuevoBorde){
        this.borde = nuevoBorde;
    }

    public void setColor(int nuevoValor){
        if(nuevoValor < 0){
            System.out.println("Error: El numero debe ser mayor o igual a 0");
            return;
        }
        this.color = nuevoValor;
    }

    // Configura color y borde (común a todas las figuras)
    protected void configurarPropiedades(PApplet p){
        if(borde != null){
            p.stroke(borde.getColor());
            p.strokeWeight(borde.getAncho());
        } else {
            p.noStroke();
        }
        p.fill(color);
    }
    
    @Override
    public void moverHorizontal(){
        float nuevaX = this.getPosicion().getX() + 1;
        this.getPosicion().setX(nuevaX);
    }
    
    @Override
    public void moverVertical(){
    float nuevaY = this.getPosicion().getY() + 1;
    this.getPosicion().setY(nuevaY);
    }

    // Cada figura decide cómo dibujarse
    public abstract void dibujar(PApplet p);
}