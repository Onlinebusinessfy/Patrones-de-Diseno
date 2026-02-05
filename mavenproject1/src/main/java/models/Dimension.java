package models;

public class Dimension {
    private float horizontal; // ancho
    private float vertical;   // alto

    // Constructor por defecto
    public Dimension() {
        this.horizontal = 50;
        this.vertical = 50;
    }

    // Constructor con parámetros
    public Dimension(float horizontal, float vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    // Getters
    public float getHorizontal() {
        return horizontal;
    }

    public float getVertical() {
        return vertical;
    }

    // Setters
    public void setHorizontal(float horizontal) {
        this.horizontal = horizontal;
    }

    public void setVertical(float vertical) {
        this.vertical = vertical;
    }
}
