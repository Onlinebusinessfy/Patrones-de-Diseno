package models;

public class Borde {

    private int ancho;
    private int color;

    // constructor por defecto
    public Borde() {
        this.ancho = 1;
        this.color = 0;
    }

    // constructor con parámetros
    public Borde(int ancho, int color) {
        this.ancho = ancho;
        this.color = color;
    }

    public int getAncho() {
        return ancho;
    }

    public int getColor() {
        return color;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
