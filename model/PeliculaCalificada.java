package model;

public class PeliculaCalificada {
    private String NombrePelicula;
    private int calificacion; 

    private void validarCalificacion(int calificacion) {
        if (calificacion < 1 || calificacion > 10) {
            throw new IllegalArgumentException("La calificación debe estar entre 1 y 10.");
        }
    }

    public PeliculaCalificada(String NombrePelicula, int score){
        validarCalificacion(score);
        this.NombrePelicula = NombrePelicula;
        this.calificacion = score;
    }

    public void setCalificacion(int calificacion) {
        validarCalificacion(calificacion);
        this.calificacion = calificacion;
    }
    public int getCalificacion() {
        return calificacion;
    }
    public String getNombrePelicula(){
        return NombrePelicula;
    }
}