package models;

public class Dimension {

    private float ancho;
    private float alto;

    public Dimension() {
        this.ancho = 0f;
        this.alto = 0f;
    }

    public Dimension(float ancho, float alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public float getAncho() {
        return ancho;
    }

    public float getAlto() {
        return alto;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }
}
