package main;

import processing.core.PApplet;
import processing.core.PGraphics;
import models.*;

public class NuevoPoo extends PApplet {

    Robot robot;
    Robot robot2;
    
    PGraphics fondo;

    public static void main(String[] args) {
        PApplet.main("main.NuevoPoo");
    }

    @Override
    public void settings() {
        size(800,600);
    }

    @Override
    public void setup() {
        // Fondo espacial estático
        fondo = createGraphics(width, height);
        fondo.beginDraw();
        fondo.background(10,10,40);
        dibujarEstrellas(fondo,200);
        fondo.endDraw();

        // Crear robots
        robot = new Robot(200,300,
                color(255, 210, 0),
                color(200,200,200),
                color(50),
                color(0)
        );
        
        robot2 = new Robot(500, 300,
                color(100, 50, 255),
                color(180),
                color(0),
                color(0)
        );
    }

    @Override
    public void draw() {
        image(fondo,0,0);
        robot.moverConLimites(width,height);
        robot.dibujar(this);
        robot2.moverConLimites(width, height);
        robot2.dibujar(this);
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
