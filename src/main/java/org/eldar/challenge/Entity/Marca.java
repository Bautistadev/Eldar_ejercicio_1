package org.eldar.challenge.Entity;

public class Marca {

    private String nombre;

    public Marca(String nombre){
        this.nombre = nombre;
    }

    public Marca(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
