package main;

import processing.core.PApplet;
import processing.core.PGraphics;
import models.*;

public class NuevoPoo extends PApplet {

    Robot robot;
    PGraphics fondo; // Fondo estático con estrellas

    public static void main(String[] args) {
        PApplet.main("main.NuevoPoo");
    }

    @Override
    public void settings() {
        size(800,600);
    }

    @Override
    public void setup() {
        // Crear fondo solo una vez
        fondo = createGraphics(width, height);
        fondo.beginDraw();
        fondo.background(10, 10, 40);
        dibujarEstrellas(fondo, 200);
        fondo.endDraw();

        // Crear robot
        robot = new Robot(200, 300);

        // --- Cuerpo ---
        robot.agregarParte(new Caja(
                new Posicion(200, 300),
                new Dimension(120, 100),
                new Borde(3, color(150, 100, 0)),
                color(200, 180, 50)
        ));

        // --- Cabeza ---
        robot.agregarParte(new Caja(
                new Posicion(230, 250),
                new Dimension(60, 50),
                new Borde(2, color(0)),
                color(200,200,200)
        ));

        // --- Ojos ---
        robot.agregarParte(new Elipse(
                new Posicion(240, 265),
                new Dimension(15, 15),
                new Borde(1, color(0)),
                color(0)
        ));
        robot.agregarParte(new Elipse(
                new Posicion(265, 265),
                new Dimension(15, 15),
                new Borde(1, color(0)),
                color(0)
        ));

        // --- Brazos ---
        robot.agregarParte(new Caja(
                new Posicion(180, 310),
                new Dimension(20, 70),
                new Borde(2, color(0)),
                color(200, 180, 50)
        ));
        robot.agregarParte(new Caja(
                new Posicion(320, 310),
                new Dimension(20, 70),
                new Borde(2, color(0)),
                color(200, 180, 50)
        ));

        // --- Llantas ---
        robot.agregarParte(new Elipse(
                new Posicion(210, 390),
                new Dimension(30, 30),
                new Borde(2, color(0)),
                color(50)
        ));
        robot.agregarParte(new Elipse(
                new Posicion(290, 390),
                new Dimension(30, 30),
                new Borde(2, color(0)),
                color(50)
        ));
    }

    @Override
    public void draw() {
        // Dibujar fondo estático
        image(fondo, 0, 0);

        // Mover robot y dibujarlo
        robot.moverConLimites(width, height);
        robot.dibujar(this);
    }

    @Override
    public void keyPressed() {
        if(keyCode == RIGHT) robot.setDireccionX(1);
        if(keyCode == LEFT)  robot.setDireccionX(-1);
        if(keyCode == UP)    robot.setDireccionY(-1);
        if(keyCode == DOWN)  robot.setDireccionY(1);
    }

    @Override
    public void keyReleased() {
        robot.setDireccionX(0);
        robot.setDireccionY(0);
    }

    // Dibujar estrellas en el PGraphics
    private void dibujarEstrellas(PGraphics pg, int cantidad){
        for(int i=0;i<cantidad;i++){
            float x = random(width);
            float y = random(height);
            pg.noStroke();
            pg.fill(255,255,200);
            pg.ellipse(x,y,random(1,3), random(1,3));
        }
    }
}
