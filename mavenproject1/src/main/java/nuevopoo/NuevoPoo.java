package nuevopoo;

import processing.core.PApplet;
import models.Caja;
import models.Circulo;
import models.Dimension;
import models.Posicion;
import models.Borde;

public class NuevoPoo extends PApplet {

    // Calle
    Caja calle;

    // Lineas amarillas
    Caja linea1;
    Caja linea2;
    Caja linea3;
    Caja linea4;

    // Partes del carrito
    Caja cuerpo;
    Caja techo;
    Caja ventana1;
    Caja ventana2;

    Circulo llanta1;
    Circulo llanta2;

    @Override
    public void settings() {
        size(Config.ANCHO, Config.ALTO);
    }

    @Override
    public void setup() {

        // Calle (rectángulo negro)
        calle = new Caja(
            new Posicion(0, 300),
            new Dimension(width, 100),
            null,
            color(30)
        );

        // Lineas amarillas de la calle
        linea1 = new Caja(new Posicion(50, 340), new Dimension(80, 10), null, color(255, 204, 0));
        linea2 = new Caja(new Posicion(180, 340), new Dimension(80, 10), null, color(255, 204, 0));
        linea3 = new Caja(new Posicion(310, 340), new Dimension(80, 10), null, color(255, 204, 0));
        linea4 = new Caja(new Posicion(440, 340), new Dimension(80, 10), null, color(255, 204, 0));

        // Cuerpo del carro
        cuerpo = new Caja(
            new Posicion(180, 250),
            new Dimension(240, 60),
            new Borde(3, color(0)),
            color(200, 0, 0)
        );

        // Techo
        techo = new Caja(
            new Posicion(220, 210),
            new Dimension(160, 40),
            new Borde(3, color(0)),
            color(200, 0, 0)
        );

        // Ventanas
        ventana1 = new Caja(
            new Posicion(235, 220),
            new Dimension(50, 30),
            new Borde(2, color(0)),
            color(180, 220, 255)
        );

        ventana2 = new Caja(
            new Posicion(305, 220),
            new Dimension(50, 30),
            new Borde(2, color(0)),
            color(180, 220, 255)
        );

        // Llantas
        llanta1 = new Circulo(
            new Posicion(230, 310),
            new Dimension(40, 40),
            new Borde(3, color(0)),
            color(50)
        );

        llanta2 = new Circulo(
            new Posicion(360, 310),
            new Dimension(40, 40),
            new Borde(3, color(0)),
            color(50)
        );
    }

    @Override
    public void draw() {
        background(Config.COLOR_FONDO);

        // Dibujar calle
        calle.dibujar(this);

        // Dibujar lineas amarillas
        linea1.dibujar(this);
        linea2.dibujar(this);
        linea3.dibujar(this);
        linea4.dibujar(this);

        // Dibujar carrito
        cuerpo.dibujar(this);
        techo.dibujar(this);
        ventana1.dibujar(this);
        ventana2.dibujar(this);
        llanta1.dibujar(this);
        llanta2.dibujar(this);
    }

    public static void main(String[] args) {
        PApplet.main("nuevopoo.NuevoPoo");
    }
}
