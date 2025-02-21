package mx.com.gm.peliculas.negocio;

import java.util.List;
import mw.com.gm.peliculas.domain.Pelicula;


public interface ICatalogoPeliculas {
    
    String NOMBRE_ARCHIVO = "peliculas.txt";
    
    void agregarPelicula(String nombrePelicula);
    
    void listarPeliculas();
    
    void buscarPelicula(String buscar);
    
    void iniciarCatalogoPeliculas();
}
