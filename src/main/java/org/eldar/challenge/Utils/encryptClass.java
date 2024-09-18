package org.eldar.challenge.Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class encryptClass {

    /**
     * @function: Encriptar
     * @param: String cvv
     * @return: ccv encriptado
     * */
    public static String encriptar(String CVV) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, crearClave("1234567812345678"));
        byte[] encrypted = cipher.doFinal(CVV.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    /**
     * @function: Desencriptar
     * @param: String cvv
     * @return: ccv desencriptado
     * */
    public static String desencriptar(String encriptadoCVV) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, crearClave("1234567812345678"));

        byte[] datosDescifrados = cipher.doFinal(Base64.getDecoder().decode(encriptadoCVV));
        return new String(datosDescifrados);
    }


    private static SecretKeySpec crearClave(String claveSecreta) throws Exception {
        byte[] key = claveSecreta.getBytes("UTF-8");
        return new SecretKeySpec(key, "AES");
    }
}
