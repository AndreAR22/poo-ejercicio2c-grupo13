package controller;

import java.util.ArrayList;

import model.PeliculaCalificada;

public class Peliculas {
    
    ArrayList<PeliculaCalificada> peliculas = new ArrayList<>();
    int[] calificaciones = new int[10];
    

    public Peliculas(){
        peliculas.add(new PeliculaCalificada("Family Guy the movie"));
        peliculas.add(new PeliculaCalificada("Bee Movie"));
        peliculas.add(new PeliculaCalificada("Los Croods"));
        peliculas.add(new PeliculaCalificada("Hoppers"));
    }

    public int getCalificaciones(int NoID){
        peliculas.get(NoID);
    }

}
