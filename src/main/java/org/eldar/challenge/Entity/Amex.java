package org.eldar.challenge.Entity;

import org.eldar.challenge.Entity.Abstract.Marca;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Amex extends Marca {

    private static Float PORCENTAJE = 0.1F;

    public Amex() {
        super("Amex");
    }
    @Override
    public BigDecimal calcularTasa(LocalDate fecha) {

        BigDecimal mes = new BigDecimal(fecha.getMonthValue());
        BigDecimal porcentaje = new BigDecimal(PORCENTAJE);

        //Garantizamos una division con una presicion de 34 digitos y redondeamos a 2 cifras decimales
        return mes.multiply(porcentaje, MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP);
    }


}
