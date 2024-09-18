package org.eldar.challenge.Entity;

import org.eldar.challenge.Entity.Abstract.Marca;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Nara extends Marca {

    private static float PORCENTAJE = 0.5F;

    public Nara() {
        super("NARA");
    }

    @Override
    public BigDecimal calcularTasa(LocalDate fecha) {

        BigDecimal dia = new BigDecimal(fecha.getDayOfMonth());
        BigDecimal porcentaje = new BigDecimal(PORCENTAJE);

        //Garantizamos una division con una presicion de 34 digitos y redondeamos a 2 cifras decimales
        return dia.multiply(porcentaje, MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP);
    }
}
