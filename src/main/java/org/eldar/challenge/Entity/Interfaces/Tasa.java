package org.eldar.challenge.Entity.Interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Tasa {
    public BigDecimal calcularTasa(LocalDate fecha);
}
