package com.mycompany.mavenproject1;
import nuevopoo.Config;
import models.Borde;

import processing.core.PApplet;

public class Mavenproject1 extends PApplet {
    
    Borde borde;

    public static void main(String[] args) {
        // Inicia el sketch de Processing
        PApplet.main("com.mycompany.mavenproject1.Mavenproject1");
    }

    @Override
    public void settings() {
        size(Config.ANCHO, Config.ALTO);
    }

    @Override
    public void setup() {
        background(Config.COLOR_FONDO);
        borde = new Borde();
    }

    @Override
    public void draw() {
        borde.setAncho(100);
        borde.setColor(0);
        // colores pueden ser texto, rgb, escala de grises
        // texto: "green"
        // rgb (100, 100, 100)
        // escala de grises: 0 - 255 (0 es negro y 255 blanco)

        // sirve para poner un color a un borde de figura
        stroke(borde.getColor());
        strokeWeight(borde.getAncho());

        // define color de relleno
        fill(150);

        // rect dibuja un cuadrado
        // coordX, coordY
        // ancho y alto
        rect(0, 0, 100, 100);
    }
}
