package org.eldar.challenge.Entity;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellido;
    private Integer dni;
    private LocalDate fecha_de_nacimiento;
    private String email;

    public Persona(String nombre, String apellido, Integer dni, LocalDate fecha_de_nacimiento, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.email = email;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public LocalDate getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(LocalDate fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", fecha_de_nacimiento=" + fecha_de_nacimiento +
                ", email='" + email + '\'' +
                '}';
    }
}
