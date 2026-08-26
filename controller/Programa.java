package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import view.*;
import controller.Peliculas;

public class Programa {

    public void ejecutarPrograma() {
        
        Peliculas controladorPeliculas = new Peliculas();
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Perfil> usuarios = new ArrayList<>();
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
                    usuarios.add(new Perfil(nombre, username, edad));
                    break;
                
                case 2:
                    break;


            }
        }
        
        
        

        scanner.close();
    }
    
}
