package org.eldar.challenge;

import org.eldar.challenge.Entity.*;
import org.eldar.challenge.Entity.Abstract.Marca;
import org.eldar.challenge.Repository.PersonaRepository;
import org.eldar.challenge.Repository.TarjetaRepository;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;

import static org.eldar.challenge.Utils.ValidateClass.*;
import static org.eldar.challenge.Utils.encryptClass.desencriptar;
import static org.eldar.challenge.Utils.encryptClass.encriptar;

public class App 
{

    static Scanner scanner = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main( String[] args ) throws IOException {

        new App();

    }

    public App() throws IOException {

        int opcion;

        do{
            menu();
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    addPersona();
                    break;
                case 2:
                    addTarjeta();
                    break;
                case 3:
                    listarTarjetas();
                    break;
                case 4:
                    listarTasas();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

        }while(true);

    }


    /**
     * INTERFACE PRINCIPAL
     */
    public static void menu(){
        System.out.println("=================== MENU ======================");
        System.out.println("OPCION 1: REGISTRAR PERSONA");
        System.out.println("OPCION 2: REGISTRAR TARJETA");
        System.out.println("OPCION 3: VER INFORMACION DE TARJETA");
        System.out.println("OPCION 4: VER TASAS ");
        System.out.println("OPCION 0: SALIR");
    }




    /**
     * FLUJO DE ALTA PERSONA
     * */
    public static void addPersona() throws IOException {

        //NOMBRE
        System.out.println("NOMBRE");
        String nombre = reader.readLine().toUpperCase();
        if (validateText(nombre,"ERROR!!: ERROR EN EL NOMBRE"))
            new App();




        //APELLIDO
        System.out.println("APELLIDO");
        String apellido = reader.readLine().toUpperCase();
        if (validateText(apellido,"ERROR!!: ERROR EN EL APELLIDO"))
            new App();




        //DNI
        System.out.println("DNI");
        Integer dni=null;
        try {
           dni = Integer.parseInt(reader.readLine());
           if (validateMinNumber(dni,8,"ERROR!!: ERROR EN EL FORMATO DEL DNI !!!"))
                new App();
        }catch (NumberFormatException e){
            System.out.println("ERROR!!: ERROR EN EL FORMATO DEL DNI !!!");
            new App();
        }



        //FECHA
        System.out.println("INGRESA LA FECHA DE NACIMIENTO (dd-mm-yyyy)");
        String fecha = reader.readLine();
        if(!validateFormatDate(fecha,"ERROR!!: FORMATO INVALIDO") || !validBirthDate(fecha,"ERROR!!: DEBES SER MAYOR DE EDAD"))
            new App();




        //EMAIL
        System.out.println("INGRESA TU EMAIL");
        String email = reader.readLine();
        if(!validateEmail(email,"ERROR!!: EMAIL INVALIDO "))
            new App();


        //VALIDAMOS DATOS
        Persona persona = null;
        try {
            persona = new Persona(nombre, apellido, dni, toLocalDate(fecha), email);
            System.out.println("================VERIFICACION================");
            System.out.println("NOMBRE      : "+nombre);
            System.out.println("APELLIDO    : "+apellido);
            System.out.println("DNI         : "+dni);
            System.out.println("FECHA       : "+fecha);
            System.out.println("EMAIL       : "+email.toUpperCase());
            System.out.println("=============================================");

            boolean valid = true;
            while (valid){
                System.out.println("DATOS CORRECTOS: SI/NO");
                switch (reader.readLine().toUpperCase()) {
                    case "SI": valid=false; break; //saley sigue con la persistencia
                    case "NO": new App();
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //USUARIO REPETIDO?
        if(PersonaRepository.getPersonaRepository().getElementByDni(dni) != null) {
            System.out.println("ERROR: NO PUEDE HABÉR DOS PERSONAS CON EL MISMO DNI");
            new App();
        }

        //PERSISIMOS
        if(PersonaRepository.getPersonaRepository().addElement(persona))
            System.out.println("INFO: PERSISTENCIA EXITOSA");

    }



    /**
     * FLUJO DE ALTA TARJETA DE CREDITO
     * */
    public static void addTarjeta() throws IOException {

        //PAM
        System.out.println("INGRESA EL PAM DE TARJETA");
        Long pam = null;
        try{
        pam =  Long.parseLong(reader.readLine());
        if (validateMinNumber(pam,16,"ERROR EN EL FORMATO DEL PAM !!!") || validateMaxNumber(pam,16,"ERROR EN EL FORMATO DEL DNI !!!"))
            new App();
        }catch (NumberFormatException e){
            System.out.println("ERROR EN EL FORMATO DEL PAM !!!");
            new App();
        }




        //TITULAR
        System.out.println("INGRESA EL NOMBRE COMPLETO DEL TITULAR");
        String titular = reader.readLine();
        if (validateText(titular.split(" ")[0],"ERROR!!: ERROR EN EL NOMBRE COMPLETO") || validateText(titular.split(" ")[1],"ERROR!!: ERROR EN EL NOMBRE COMPLETO"))
            new App();



        //DNI
        System.out.println("INGRESA EL DNI DEL TITULAR");
        Integer dni=null;
        try {
            dni = Integer.parseInt(reader.readLine());
            if (validateMinNumber(dni,8,"ERROR!!: ERROR EN EL FORMATO DEL DNI !!!"))
                new App();
        }catch (NumberFormatException e){
            System.out.println("ERROR!!: ERROR EN EL FORMATO DEL DNI !!!");
            new App();
        }



        //FECHA DE VENCIMIENTO
        System.out.println("INGRESA LA FECHA DE VENCIMIENTO");
        String fecha_vencimiento = reader.readLine();
        if(!validateFormatDate(fecha_vencimiento,"EEROR!!: FORMATO INCORRECTO ") || isExpired(fecha_vencimiento,"ERROR: TARJETA CADUCADA"))
            new App();



        //CVV
        System.out.println("INGRESA LA CLAVE DE LA TARJETA (CVV)");
        String CVV = reader.readLine();
        if(CVV.length() != 3)
            new App();


        //MARCA
        System.out.println("INGRESA LA MARCA DE LA TARJETA");
        System.out.println("1. VISA");
        System.out.println("2. NARA");
        System.out.println("3. AMEX");
        Integer marcaOpcion = Integer.parseInt(reader.readLine());
        Marca marca = null;
        switch (marcaOpcion){
            case 1:
                marca = new Visa();
                break;
            case 2:
                marca = new Nara();
                break;
            case 3:
                marca = new Amex();
                break;
            default:
                System.out.println("Opcion no valida");
                new App();
                break;
        }


        //VALIDAMOS EXISTENCIA DE LA PERSONA EN BD
        if(PersonaRepository.getPersonaRepository().getElementByDni(dni) == null) {
            System.out.println("ERROR!!: PERSONA NO REGISTRADA, POR FAVOR REALIZA EL REGISTRO E INTENTA NUEVAMENTE");
            new App();
        }


        //PERSISTIMOS
        Tarjeta tarjeta = null;
        try {
            //CREAMOS OBJETO TERJETA
            tarjeta= new Tarjeta(pam,toLocalDate(fecha_vencimiento),titular,marca,encriptar(CVV));

            //SETEAMOS AL USUARIO DUEÑO DE LA TARJETA
            tarjeta.setCashHolder(PersonaRepository.getPersonaRepository().getElementByDni(dni));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        if (TarjetaRepository.getTarjetaRepository().addElement(tarjeta))
            System.out.println("INFO: PERSISTENCIA EXITOSA");
        else
            System.out.println("ERROR!!: ERROR EN LA PERSISTENCIA");

    }




    /**
     * FLUJO DE LITAR TARJETAS DE UNA PERSONA
     * */
    private static void listarTarjetas() throws IOException {

        //INGRESA DNI
        System.out.println("INGRESA TU DNI");
        Integer dni=null;
        try {
            dni = Integer.parseInt(reader.readLine());
            if (validateMinNumber(dni,8,"ERROR!!: ERROR EN EL FORMATO DEL DNI !!!"))
                new App();
        }catch (NumberFormatException e){
            System.out.println("ERROR!!: ERROR EN EL FORMATO DEL DNI !!!");
            new App();
        }

        //IMPRIMIMOS DATOS DE TARJETA
        TarjetaRepository.getTarjetaRepository().getTarjetasByDni(dni).forEach(e->{
            try {

            System.out.println("==========================================");
            System.out.println("CODIGO DE TARJETA       : ".concat(formatearNumeroTarjeta(e.getNumero().toString())));
            System.out.println("TITULAR                 : ".concat(e.getNombre_completo_titular()));
            System.out.println("MARCA                   : ".concat(e.getMarca().getNombre()));
            System.out.println("CVV                     : ".concat(desencriptar(e.getCVV())));
            System.out.println("FECHA DE VENCIMIENTO    : ".concat(e.getFecha_vencimiento().toString()));

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

    }


    /**
     * FLUJO DE LISTAR TASAS
     * */
    private static void listarTasas() throws IOException {
        System.out.println("INGRESA UNA FECHA, ENTER VACÍO EN CASO DE ELEGÍR LA ACTUAL");
        String fecha_vencimiento = reader.readLine();

        if (fecha_vencimiento.isEmpty()) {
            System.out.println("AMEX:  :" + new Amex().calcularTasa(LocalDate.now()));
            System.out.println("NARA:  :" + new Nara().calcularTasa(LocalDate.now()));
            System.out.println("VISA:  :" + new Visa().calcularTasa(LocalDate.now()));
        }else {
            System.out.println("AMEX   : " + new Amex().calcularTasa(toLocalDate(fecha_vencimiento)));
            System.out.println("NARA   : " + new Nara().calcularTasa(toLocalDate(fecha_vencimiento)));
            System.out.println("VISA   : " + new Visa().calcularTasa(toLocalDate(fecha_vencimiento)));
        }


    }




}
