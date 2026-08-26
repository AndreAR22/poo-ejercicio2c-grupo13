package model;

public class Perfil {
    private String nombre;
    private String usuario;
    private int edad;
    private PeliculaCalificada[] calificacion = new PeliculaCalificada[10];


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
        this.calificacion[this.calificacion.length] = new PeliculaCalificada(NombrePelicula, score); 
   }


        
    } 
