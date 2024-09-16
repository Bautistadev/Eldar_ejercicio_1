package org.eldar.challenge.Entity;

import org.eldar.challenge.Entity.Interfaces.Tasa;

import java.time.LocalDate;

public abstract class Tarjeta implements Tasa {

    private Long numero;
    private LocalDate fecha_vencimiento;

    private String CVV;
    private Persona cashHolder;
    private Marca marca;

    public Tarjeta(Long numero, LocalDate fecha_vencimiento, Persona cashHolder, Marca marca) {
        this.numero = numero;
        this.fecha_vencimiento = fecha_vencimiento;
        this.cashHolder = cashHolder;
        this.marca = marca;
    }

    public Tarjeta() {
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public LocalDate getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(LocalDate fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Persona getCashHolder() {
        return cashHolder;
    }

    public void setCashHolder(Persona cashHolder) {
        this.cashHolder = cashHolder;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "numero=" + numero +
                ", fecha_vencimiento=" + fecha_vencimiento +
                ", cashHolder=" + cashHolder +
                ", marca=" + marca +
                '}';
    }
}
