package models;

import java.util.ArrayList;
import processing.core.PApplet;

public class Robot {

    private ArrayList<Figura> partes;
    private ArrayList<Elipse> llantas;
    private ArrayList<Caja> cuerpoCompleto;

    private float posX, posY; // posición central
    private int direccionX = 0;
    private int direccionY = 0;

    // Colores internos
    private int colorCuerpoBrazos;
    private int colorCabeza;
    private int colorLlantas;
    private int colorOjos;

    public Robot(float startX, float startY, int colorCuerpoBrazos, int colorCabeza, int colorLlantas, int colorOjos){
        partes = new ArrayList<>();
        llantas = new ArrayList<>();
        cuerpoCompleto = new ArrayList<>();
        posX = startX;
        posY = startY;

        this.colorCuerpoBrazos = colorCuerpoBrazos;
        this.colorCabeza = colorCabeza;
        this.colorLlantas = colorLlantas;
        this.colorOjos = colorOjos;

        crearRobot();
    }

    private void crearRobot() {
        // --- Cuerpo ---
        Caja cuerpo = new Caja(
            new Posicion(posX, posY),
            new Dimension(120, 100),
            new Borde(3, 0),
            colorCuerpoBrazos
        );
        agregarParte(cuerpo);
        cuerpoCompleto.add(cuerpo);

        // --- Brazos ---
        Caja brazoIzq = new Caja(
            new Posicion(posX - 20, posY + 10),
            new Dimension(20, 70),
            new Borde(2, 0),
            colorCuerpoBrazos
        );
        Caja brazoDer = new Caja(
            new Posicion(posX + 120, posY + 10),
            new Dimension(20, 70),
            new Borde(2, 0),
            colorCuerpoBrazos
        );
        agregarParte(brazoIzq);
        agregarParte(brazoDer);
        cuerpoCompleto.add(brazoIzq);
        cuerpoCompleto.add(brazoDer);

        // --- Cabeza ---
        agregarParte(new Caja(
            new Posicion(posX + 30, posY - 50),
            new Dimension(60, 50),
            new Borde(2, 0),
            colorCabeza
        ));

        // --- Ojos ---
        agregarParte(new Elipse(
            new Posicion(posX + 35, posY - 35),
            new Dimension(15, 15),
            new Borde(1,0),
            colorOjos
        ));
        agregarParte(new Elipse(
            new Posicion(posX + 55, posY - 35),
            new Dimension(15, 15),
            new Borde(1,0),
            colorOjos
        ));

        // --- Llantas ---
        agregarLlanta(new Elipse(
            new Posicion(posX + 10, posY + 90),
            new Dimension(40, 40),
            new Borde(2, 0),
            colorLlantas
        ));
        agregarLlanta(new Elipse(
            new Posicion(posX + 70, posY + 90),
            new Dimension(40, 40),
            new Borde(2, 0),
            colorLlantas
        ));
    }

    // --- Métodos de modificación de color ---
    public void cambiarColorCuerpoBrazos(int nuevoColor){
        colorCuerpoBrazos = nuevoColor;
        for(Caja f : cuerpoCompleto){
            f.setColor(nuevoColor);
        }
    }

    public void cambiarColorLlantas(int nuevoColor){
        colorLlantas = nuevoColor;
        for(Elipse l : llantas){
            l.setColor(nuevoColor);
        }
    }

    // --- Métodos básicos ---
    public void agregarParte(Figura f){ 
        partes.add(f);
    }
    
    public void agregarLlanta(Elipse l){
        partes.add(l);
        llantas.add(l);
    }

    public void dibujar(PApplet p){
        for(Figura f: partes){
            f.dibujar(p);
        }
    }

    public void setDireccionX(int d){ 
        direccionX = d; 
    }
    public void setDireccionY(int d){ 
        direccionY = d; 
    }

    public void moverConLimites(float anchoVentana, float altoVentana){
        float nuevaX = posX + direccionX * 5;
        float nuevaY = posY + direccionY * 5;

        float minX = Float.MAX_VALUE, minY = Float.MAX_VALUE;
        float maxX = Float.MIN_VALUE, maxY = Float.MIN_VALUE;

        for(Figura f : partes){
            Posicion p = f.getPosicion();
            Dimension d = f.getDimension();
            minX = Math.min(minX, p.getX());
            minY = Math.min(minY, p.getY());
            maxX = Math.max(maxX, p.getX() + d.getHorizontal());
            maxY = Math.max(maxY, p.getY() + d.getVertical());
        }

        float dx = nuevaX - posX;
        float dy = nuevaY - posY;

        if(minX + dx < 0) dx = -minX;
        if(minY + dy < 0) dy = -minY;
        if(maxX + dx > anchoVentana) dx = anchoVentana - maxX;
        if(maxY + dy > altoVentana) dy = altoVentana - maxY;

        for(Figura f : partes){
            Posicion p = f.getPosicion();
            p.setX(p.getX() + dx);
            p.setY(p.getY() + dy);
        }

        posX += dx;
        posY += dy;
    }
}
