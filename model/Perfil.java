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
        validarMaximoCalificaciones();
        if (this.numCalificaciones < this.calificacion.length) {
            this.calificacion[this.numCalificaciones] = new PeliculaCalificada(NombrePelicula, score); 
            this.numCalificaciones++; 
            System.out.println("La calificación de la película ha sido registrada");
        } else {
            System.out.println("Error: El arreglo de calificaciones está lleno.");
        }
    }

    private void validarMaximoCalificaciones() {
        if (numCalificaciones >= calificacion.length) {
            throw new IllegalArgumentException("No se pueden registrar más calificaciones. El límite es de 10.");
        }
    }

    public void getCalificaciones(){
        int i = 0;
        while(this.calificacion[i] != null){
            System.out.printf("Película %s se calificó con una puntuación de %d puntos\n",this.calificacion[i].getNombrePelicula(),this.calificacion[i].getCalificacion());
            i++;
        }
    }

    private void validarNumeroPelicula(int noID) {
        if (noID < 1 || noID > numCalificaciones) {
            throw new IllegalArgumentException("No existe una pelicula registrada con ese numero.");
        }
    }

    public float consultarCalificacion(int noID) {
        validarNumeroPelicula(noID);
        return calificacion[noID - 1].getCalificacion();
    }

    public String consultarPelicula(int noID) {
        validarNumeroPelicula(noID);
        PeliculaCalificada pelicula = calificacion[noID - 1];
        return String.format("Película %s se calificó con una puntuación de %d puntos",
                pelicula.getNombrePelicula(), pelicula.getCalificacion());
    }

    public void modificarCalificacion(int noID, int nuevaCalificacion) {
        validarNumeroPelicula(noID);
        calificacion[noID - 1].setCalificacion(nuevaCalificacion);
        System.out.println("La calificación de la película ha sido modificada");
    }

    public float calcularPromedio() {
        if (numCalificaciones == 0) {
            return 0;
        }

        int suma = 0;
        for (int i = 0; i < numCalificaciones; i++) {
            suma += calificacion[i].getCalificacion();
        }
        return (float) suma / numCalificaciones;
    }

    public PeliculaCalificada obtenerMejorCalificacion() {
        if (numCalificaciones == 0) {
            return null;
        }

        PeliculaCalificada mejor = calificacion[0];
        for (int i = 1; i < numCalificaciones; i++) {
            if (calificacion[i].getCalificacion() > mejor.getCalificacion()) {
                mejor = calificacion[i];
            }
        }
        return mejor;
    }

    public PeliculaCalificada obtenerPeorCalificacion() {
        if (numCalificaciones == 0) {
            return null;
        }

        PeliculaCalificada peor = calificacion[0];
        for (int i = 1; i < numCalificaciones; i++) {
            if (calificacion[i].getCalificacion() < peor.getCalificacion()) {
                peor = calificacion[i];
            }
        }
        return peor;
    }

    public int consultarEspaciosDisponibles() {
        return calificacion.length - numCalificaciones;
    }

}
