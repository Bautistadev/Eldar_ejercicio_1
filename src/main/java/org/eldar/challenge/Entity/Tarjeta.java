package org.eldar.challenge.Entity;

import org.eldar.challenge.Entity.Abstract.Marca;

import java.time.LocalDate;

public class Tarjeta {

    private Long numero;
    private LocalDate fecha_vencimiento;

    private String CVV;
    private String nombre_completo_titular;

    private Persona cardHolder;
    private Marca marca;

    public Tarjeta(Long numero, LocalDate fecha_vencimiento, String nombre_completo_titular, Marca marca,String CVV) throws Exception {
        setNumero(numero);
        setFecha_vencimiento(fecha_vencimiento);
        setMarca(marca);
        setNombre_completo_titular(nombre_completo_titular);
        setCVV(CVV);
    }

    public Tarjeta() {
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) throws Exception {

        if(CVV == null || CVV.isEmpty())
            throw new Exception("El CVV no puede ser vacio o nulo");

        this.CVV = CVV;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) throws Exception {
        if(numero == null)
            throw new Exception("El numero tarjeta no puede estar vacio");
        this.numero = numero;
    }





    public LocalDate getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(LocalDate fecha_vencimiento) throws Exception {
        if(fecha_vencimiento == null)
            throw new Exception("La fecha de vencimiento de la tarjeta, no puede estar vacio");
        this.fecha_vencimiento = fecha_vencimiento;
    }





    public Persona getCashHolder() {
        return cardHolder;
    }

    public void setCashHolder(Persona cardHolder) throws Exception {
        if(cardHolder == null)
            throw new Exception("El titular no puede estar vacio");

        this.cardHolder = cardHolder;
    }





    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) throws Exception {
        if(marca == null)
            throw new Exception("Se debe indicar la marca de la tarjeta");
        this.marca = marca;
    }




    public String getNombre_completo_titular() {
        return nombre_completo_titular;
    }

    public void setNombre_completo_titular(String nombre_completo_titular) throws Exception {
        if(nombre_completo_titular == null || nombre_completo_titular.isEmpty())
            throw new Exception("Se debe indicar el nombre completo del titular (<Apellido> <Nombre>");
        this.nombre_completo_titular = nombre_completo_titular;
    }



    public void createCVV(){

    }


    @Override
    public String toString() {
        return "Tarjeta{" +
                "numero=" + numero +
                ", fecha_vencimiento=" + fecha_vencimiento +
                ", cashHolder=" + cardHolder +
                ", marca=" + marca +
                '}';
    }
}
