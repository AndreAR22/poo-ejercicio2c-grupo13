package model;

public class Perfil {
    private String nombre;
    private String usuario;
    private int edad;
    private PeliculaCalificada[] calificacion = new PeliculaCalificada[10];
    private int numCalificaciones = 0; 


    public Perfil(String nombre, String usuario, int edad) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void calificarPeli(String NombrePelicula, int score) {
        if (this.numCalificaciones < this.calificacion.length) {
            this.calificacion[this.numCalificaciones] = new PeliculaCalificada(NombrePelicula, score); 
            this.numCalificaciones++; 
            System.out.println("La calificación de la película ha sido registrada");
        } else {
            System.out.println("Error: El arreglo de calificaciones está lleno.");
        }
    }
    public void getCalificaciones(){
        int i = 0;
        while(this.calificacion[i] != null){
            System.out.printf("Película %s se calificó con una puntuación de %d puntos\n",this.calificacion[i].getNombrePelicula(),this.calificacion[i].getCalificacion());
            i++;
        }
    }


        
    } 
