package org.eldar.challenge.Repository;

import org.eldar.challenge.Entity.Tarjeta;

import java.util.List;
import java.util.stream.Collectors;

import static org.eldar.challenge.Utils.encryptClass.desencriptar;

public class TarjetaRepository {


    private Database database;

    private static TarjetaRepository tarjetaRepository;

    private TarjetaRepository(){
        database = new Database();
    }

    //Instanciamos nuestro objeto singleton
    public static TarjetaRepository getTarjetaRepository(){
        if(tarjetaRepository == null)
            tarjetaRepository = new TarjetaRepository();

        return tarjetaRepository;
    }



    /**
     * @function: Buscar todas las terjetas de una persona por dni
     * @param: dni -> Integer
     * @return lista de tarjetas
     * */
    public List<Tarjeta> getTarjetasByDni(Integer dni) {

        List <Tarjeta> response = (List<Tarjeta>) this.database.getAll()
                .values()
                .stream()
                .filter(obj ->{
                    Tarjeta tarjeta =  (Tarjeta) obj;
                    if(tarjeta.getCashHolder().getDni().equals(dni))
                        return true;
                    return false;
                }).collect(Collectors.toList());

        return response;
    }



    /**
     * @function: Listar todos las tarjetas
     * @param: -
     * @return lista de tarjetas
     * */
    public List <Tarjeta> getAllElements() {

        List<Tarjeta> listResponse =  (List<Tarjeta>) this.database.getAll()
                .values()
                .stream()
                .collect(Collectors.toList());

        return listResponse;
    }



    /**
     * @function: Agregar nueva tarjeta a la base de datos
     * @param: Objecto tarjeta
     * @return Resultado exitoso o Error
     * */
    public Boolean addElement(Tarjeta object) {
        if(object == null || !(object instanceof Tarjeta))
            throw new IllegalArgumentException("EL OBJETO NO PUEDE SER NULO");

        if(validateCardNumber(object.getNumero()))
            return false;

        if(validateCVV(object.getCVV()))
            return false;

        this.database.add(object);

        return true;
    }


   private boolean validateCardNumber(Long numeroTarjeta){
        return this.database
                .getAll()
                .values()
                .stream()
                .anyMatch(e ->{
                    Tarjeta tarjeta =  (Tarjeta) e;
                    if(tarjeta.getNumero().equals(numeroTarjeta)) {
                        System.out.println("INFO: TARJETA EXISTENTE");
                        return true;
                    }else {
                        return false;
                    }
                });
    }

    private boolean validateCVV(String cvv){
        return this.database
                .getAll()
                .values()
                .stream()
                .anyMatch(e ->{
                    Tarjeta tarjeta =  (Tarjeta) e;
                    try {
                        if(desencriptar(tarjeta.getCVV()).equals(tarjeta.getNumero())) {
                            System.out.println("INFO: CVV EXISTENTE");
                            return true;
                        }else {
                            return false;
                        }
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                });
    }
}
