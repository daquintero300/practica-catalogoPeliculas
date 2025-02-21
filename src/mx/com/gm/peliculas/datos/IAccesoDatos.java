package mx.com.gm.peliculas.datos;

import java.util.List;
import mw.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public interface IAccesoDatos {

    boolean existe(String nombreArchivo) throws AccesoDatosEx;

    List<Pelicula> listar(String nombre) throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nombreArchivo, Boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreArchivo, String nombrePelicula) throws LecturaDatosEx;
    
    void crear(String nombreArchivo) throws AccesoDatosEx;

    void borrar(String nombreArchivo) throws AccesoDatosEx;
}
