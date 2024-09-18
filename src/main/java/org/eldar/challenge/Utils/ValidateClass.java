package org.eldar.challenge.Utils;

import org.eldar.challenge.App;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.time.LocalDate;
import java.time.Period;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {

    public static boolean validateText(String validate,String message){

        if(validate == null || validate == "" || !validate.matches("[a-zA-Z]+")) {
            System.out.println(message);
            return true;
        }

        return false;
    }

    public static boolean validateMinNumber(Object validate,Integer limit,String message){
        if(validate == null || String.valueOf(validate).length() < limit) {
            System.out.println(message);
            return true;
        }
        return false;
    }
    public static boolean validateMaxNumber(Object validate,Integer limit,String message){
        if(validate == null || String.valueOf(validate).length() > limit) {
            System.out.println(message);
            return true;
        }
        return false;
    }

    public static boolean validateFormatDate(String validate,String message){
        if(validate == null || validate == "")
            return true;

        String regex = "\\d{2}-\\d{2}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(validate);
         if (!matcher.matches()) {
             System.out.println(message);
             return false;
         }
         return true;
    }

    //VALIDAMOS EDAD
    public static boolean validBirthDate(String validate,String message){

        if(Period.between(toLocalDate(validate),LocalDate.now()).getYears() < 18){
            System.out.println(message);
            return false;
        }
        return true;
    }

    public static boolean isExpired(String validate,String message){

        if(toLocalDate(validate).isBefore(LocalDate.now())) {
            System.out.println(message);
            return true;
        }
        return false;
    }

    public static boolean validateEmail(String validate,String message){

        if(validate == null || validate == "") {
            System.out.println(message);
            return true;
        }

        String regex = "^[\\w-\\.]+@[\\w-]+\\.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(validate);
        if (!matcher.matches()) {
            System.out.println(message);
            return false;
        }
        return true;
    }

    public static LocalDate toLocalDate(String fecha){
        String [] datosFecha = fecha.split("-") ;

        return LocalDate.of(Integer.parseInt(datosFecha[2].trim()), //AÑO
                Integer.parseInt(datosFecha[1].trim()), // FECHA
                Integer.parseInt(datosFecha[0].trim())); // MES
    }

    public static String formatearNumeroTarjeta(String numero) {
        // Verifica que el número tenga 16 cifras
        if (numero == null || numero.length() != 16 || !numero.matches("\\d+")) {
            throw new IllegalArgumentException("El número de tarjeta debe tener 16 cifras.");
        }

        // Usa expresiones regulares para insertar los guiones en la posición correcta
        return numero.replaceAll("(\\d{4})(\\d{4})(\\d{4})(\\d{4})", "$1-$2-$3-$4");
    }




}
