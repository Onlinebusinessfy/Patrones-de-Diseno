package models;

import processing.core.PApplet;
import java.util.ArrayList;

public class Carro {
    
    private ArrayList<Figura> partes;
    
    public Carro(){
        partes = new ArrayList<>();
    }
    
    public void agregarParte(Figura f){
        partes.add(f);
    }
    
    public void dibujar(PApplet p){
        for (Figura f: partes){
            f.dibujar(p);
        }
    }
    
    public void moverHorizontal(){
        for (Figura f: partes){
            f.moverHorizontal();
        }
    }
}
