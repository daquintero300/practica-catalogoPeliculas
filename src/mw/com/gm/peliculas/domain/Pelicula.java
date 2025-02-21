package mw.com.gm.peliculas.domain;


public class Pelicula {
    private String nombre;
    
    public Pelicula() {    
    }
    
    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nombre);
        return sb.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
