package cpjlaboratorofinal;

import java.io.File;
import java.util.Scanner;
import mx.com.gm.peliculas.negocio.*;

public class CPJLaboratorioFinal {

    static ICatalogoPeliculas catalogoPeliculas = new CatalogoPeliculas();

    static Scanner consola = new Scanner(System.in);

    static boolean salir = false;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        System.out.println("*** Catalogo Peliculas ***");

        while (salir != true) {
            System.out.print("""
                             
                           \t1.-Iniciar catalogo peliculas
                           \t2.-Agregar pelicula
                           \t3.-Listar peliculas
                           \t4.-Buscar pelicula
                           \t0.-Salir
                         
                           Elije opcion:""");
            
            try {
                var opcion = Integer.parseInt(consola.nextLine());
                
                switch (opcion) {
                case 1 -> iniciarCatalogoPeliculas();
                case 2 -> agregarPelicula();
                case 3 -> listarPeliculas();
                case 4 -> buscarPelicula();
                case 0 -> salir();
                default -> System.out.print("No es una opcion valida, intente de nuevo\n");
            }
            } catch (Exception e) {
                System.out.print("No es una opcion valida, intente de nuevo\n");
            }
            
            
            

            

        }

    }

    public static void agregarPelicula() {
        System.out.print("Introduce el nombre de una pelicula a agregar: ");
        String nombrePelicula = consola.nextLine();
        catalogoPeliculas.agregarPelicula(nombrePelicula);
        listarPeliculas();
    }

    public static void listarPeliculas() {
        catalogoPeliculas.listarPeliculas();
    }

    public static void buscarPelicula() {
        System.out.print("Introduce el nombre de una pelicula que quiere buscar: ");
        String nombrePelicula = consola.nextLine();
        catalogoPeliculas.buscarPelicula(nombrePelicula);
    }

    public static void iniciarCatalogoPeliculas() {
        catalogoPeliculas.iniciarCatalogoPeliculas();
    }
    
    public static void salir() {
        System.out.println("Saliendo del sistema, regresa pronto");
        salir = true;
    }

}
