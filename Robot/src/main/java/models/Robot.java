package models;

import java.util.ArrayList;
import processing.core.PApplet;

public class Robot {

    private ArrayList<Figura> partes;
    private float posX, posY; // Posición central
    private int direccionX = 0;
    private int direccionY = 0;

    public Robot(float startX, float startY){
        partes = new ArrayList<>();
        posX = startX;
        posY = startY;
    }

    public void agregarParte(Figura f){
        partes.add(f);
    }

    public void dibujar(PApplet p){
        for(Figura f: partes){
            f.dibujar(p);
        }
    }

    public void setDireccionX(int d){ direccionX = d; }
    public void setDireccionY(int d){ direccionY = d; }

    public void moverConLimites(float anchoVentana, float altoVentana){
        // Calcular nueva posición central
        float nuevaX = posX + direccionX * 5;
        float nuevaY = posY + direccionY * 5;

        // Encontrar bounds del robot
        float minX = Float.MAX_VALUE;
        float minY = Float.MAX_VALUE;
        float maxX = Float.MIN_VALUE;
        float maxY = Float.MIN_VALUE;

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

        // Verificar límites
        if(minX + dx < 0) dx = -minX;
        if(minY + dy < 0) dy = -minY;
        if(maxX + dx > anchoVentana) dx = anchoVentana - maxX;
        if(maxY + dy > altoVentana) dy = altoVentana - maxY;

        // Mover todas las partes
        for(Figura f : partes){
            Posicion p = f.getPosicion();
            p.setX(p.getX() + dx);
            p.setY(p.getY() + dy);
        }

        // Actualizar posición central
        posX += dx;
        posY += dy;
    }
}
