package models;

public class Posicion {
    
    // Atributos
    private float x;
    private float y;

    // Constructor vacío
    public Posicion() {
        this.x = 0f;
        this.y = 0f;
    }

    // Constructor con parámetros
    public Posicion(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Getters
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    // Setters
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    // Método para mover la posición
    public void mover(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }

    // Método para establecer nueva posición
    public void setPosicion(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Método para mostrar la posición
    public String mostrar() {
        return "Posicion [x=" + x + ", y=" + y + "]";
    }
}
