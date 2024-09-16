package org.eldar.challenge.Entity;

import java.time.LocalDate;

public class TarjetaVisa extends Tarjeta {


    public TarjetaVisa(Long numero, LocalDate fecha_vencimiento, Persona cashHolder){

        super(numero, fecha_vencimiento, cashHolder, new Marca("VISA"));

    }

    @Override
    public Float calcularTasa() {
        return null;
    }
}
