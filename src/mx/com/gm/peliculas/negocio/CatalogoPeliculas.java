package mx.com.gm.peliculas.negocio;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Spring;
import mw.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.excepciones.*;

public class CatalogoPeliculas implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculas() {
        this.datos = new AccesoDatos();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_ARCHIVO);
            if (anexar != false) {
                datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos:");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            List peliculas = datos.listar(NOMBRE_ARCHIVO);
            peliculas.forEach(pelicula -> {
                System.out.println("pelicula = " + pelicula.toString());
            });
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos:");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        try {
            this.datos.buscar(NOMBRE_ARCHIVO, buscar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos:");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_ARCHIVO)) {
                datos.borrar(NOMBRE_ARCHIVO);
                datos.crear(NOMBRE_ARCHIVO);
            } else {
                datos.crear(NOMBRE_ARCHIVO);
            }
        } catch (AccesoDatosEx ex) {
            Logger.getLogger(CatalogoPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
