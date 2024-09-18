package org.eldar.challenge.Entity;

import org.eldar.challenge.Entity.Abstract.Marca;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Visa extends Marca {

    public Visa() {
        super("VISA");
    }

    @Override
    public BigDecimal calcularTasa(LocalDate fecha) {
        BigDecimal num1 = new BigDecimal(reducir(fecha.getYear()));
        BigDecimal num2 = new BigDecimal(fecha.getMonthValue());

        //Garantizamos una division con una presicion de 34 digitos y redondeamos a 2 cifras decimales
        return num1.divide(num2, MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP);
    }

    //PASAMOS A FORMATO ABREVIADO
    private Integer reducir(int ano){

        // Convertimos el número a una cadena
        String numeroComoCadena = String.valueOf(ano);

        return Integer.parseInt(numeroComoCadena.substring(numeroComoCadena.length() - 2));
    }
}
