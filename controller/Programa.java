package controller;

import java.util.Scanner;
import model.*;
import view.*;

public class Programa {

    public void ejecutarPrograma() {
        Scanner scanner = new Scanner(System.in);
        Perfil[] usuarios = new Perfil[10]; //Maximo de 10 usuarios
        Menu menu = new Menu();
        Boolean running = true;
        int usuarios_registrados = -1;

        while(running){
            menu.showOpciones();
            int selection = scanner.nextInt();
            try {
                switch (selection) {
                    case 9:
                        running = false;
                        break;
                    case 1:
                        usuarios_registrados++;
                        scanner.nextLine();
                        System.out.print("Nombre completo: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Usuario: ");
                        String username = scanner.nextLine();
                        System.out.print("Edad: ");
                        int edad = scanner.nextInt();
                        usuarios[usuarios_registrados] = new Perfil(nombre, username, edad);
                        break;
                    
                    case 2:
                        validarUsuarioRegistrado(usuarios_registrados);
                        scanner.nextLine();
                        System.out.print("Nombre de pelicula: ");
                        String NombrePelicula = scanner.nextLine();
                        System.out.print("Puntuación: ");
                        int score = scanner.nextInt();
                        usuarios[usuarios_registrados].calificarPeli(NombrePelicula, score);
                        break;

                    case 3:
                        validarUsuarioRegistrado(usuarios_registrados);
                        usuarios[usuarios_registrados].getCalificaciones();
                        break;

                    case 4:
                        validarUsuarioRegistrado(usuarios_registrados);
                        System.out.print("Número de película: ");
                        int noID = scanner.nextInt();
                        try {
                            System.out.println(usuarios[usuarios_registrados].consultarPelicula(noID));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 5:
                        validarUsuarioRegistrado(usuarios_registrados);
                        System.out.print("Número de película: ");
                        int peliculaModificar = scanner.nextInt();
                        System.out.print("Nueva puntuación: ");
                        int nuevaCalificacion = scanner.nextInt();
                        try {
                            usuarios[usuarios_registrados].modificarCalificacion(peliculaModificar, nuevaCalificacion);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 6:
                        validarUsuarioRegistrado(usuarios_registrados);
                        System.out.printf("El promedio de calificaciones es: %.2f%n",
                                usuarios[usuarios_registrados].calcularPromedio());
                        break;

                    case 7:
                        validarUsuarioRegistrado(usuarios_registrados);
                        PeliculaCalificada mejor = usuarios[usuarios_registrados].obtenerMejorCalificacion();
                        PeliculaCalificada peor = usuarios[usuarios_registrados].obtenerPeorCalificacion();
                        if (mejor == null) {
                            System.out.println("No hay películas calificadas.");
                        } else {
                            System.out.printf("Mejor calificación: %s con %d puntos%n",
                                    mejor.getNombrePelicula(), mejor.getCalificacion());
                            System.out.printf("Peor calificación: %s con %d puntos%n",
                                    peor.getNombrePelicula(), peor.getCalificacion());
                        }
                        break;

                    case 8:
                        validarUsuarioRegistrado(usuarios_registrados);
                        System.out.printf("Espacios disponibles: %d%n",
                                usuarios[usuarios_registrados].consultarEspaciosDisponibles());
                        break;
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    private void validarUsuarioRegistrado(int usuarios_registrados) {
        if (usuarios_registrados < 0) {
            throw new IllegalArgumentException("No hay usuarios registrados. Por favor, registre un usuario primero.");
        }
    }
}

