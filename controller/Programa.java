package controller;

import java.util.Scanner;
import model.*;
import view.*;

public class Programa {

    public void ejecutarPrograma() {
        
        
        Scanner scanner = new Scanner(System.in);
        Perfil[] usuarios = new Perfil[10];
        Menu menu = new Menu();
        Boolean running = true;

        while(running){
            menu.showOpciones();
            int selection = scanner.nextInt();
            switch (selection) {
                case 9:
                    running = false;
                    break;
                case 1:
                    scanner.nextLine();
                    System.out.print("Nombre completo: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Usuario: ");
                    String username = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    usuarios[0] = new Perfil(nombre, username, edad);
                    break;
                
                case 2:
                    scanner.nextLine();
                    System.out.print("Nombre de pelicula: ");
                    String NombrePelicula = scanner.nextLine();
                    System.out.print("Puntuación: ");
                    int score = scanner.nextInt();
                    usuarios[0].calificarPeli(NombrePelicula, score);
                    break;


            }
        }
        
        
        

        scanner.close();
    }
    
}
