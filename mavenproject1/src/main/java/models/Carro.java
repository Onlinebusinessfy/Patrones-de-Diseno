package models;

import processing.core.PApplet;
import java.util.ArrayList;

public class Carro {
    
    private ArrayList<Figura> partes;
    private int direccion = 0;
    
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
    
    public void setDireccion(int direccion){
        this.direccion = direccion;
    }
    
    public void moverHorizontal(int anchoVentana){
        Figura referencia = partes.get(0);
        
        float x = referencia.getPosicion().getX();
        float anchoCarro = referencia.getDimension().getHorizontal();
        
        if((x + anchoCarro >= anchoVentana && direccion == 1) ||
           (x <= 0 && direccion == -1)){
            return;
        }
        
        for (Figura f: partes){
            float nuevaX = f.getPosicion().getX() + direccion;
            f.getPosicion().setX(nuevaX);
        }
    }
}
