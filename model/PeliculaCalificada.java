package model;

public class PeliculaCalificada {
    private String NombrePelicula;
    private int calificacion; 

    public PeliculaCalificada(String NombrePelicula, int score){
        this.NombrePelicula = NombrePelicula;
        this.calificacion = score;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    public int getCalificacion() {
        return calificacion;
    }
    public String getNombrePelicula(){
        return NombrePelicula;
    }
}