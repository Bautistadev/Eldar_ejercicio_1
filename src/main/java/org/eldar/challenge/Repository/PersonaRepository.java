package org.eldar.challenge.Repository;

import org.eldar.challenge.Entity.Persona;
import org.eldar.challenge.Entity.Tarjeta;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonaRepository {

    private Database database;

    private static PersonaRepository personaRepository;

    private PersonaRepository(){
        database = new Database();
    }

    //INTANCIAMOS SINGLETON
    public static  PersonaRepository getPersonaRepository(){
        if(personaRepository == null)
            personaRepository =  new PersonaRepository();

        return personaRepository;
    }





    /**
     * @funcion: Buscar persona por su dni
     * @param: Integer dni
     * @resturn: Persona
     * */
    public Persona getElementByDni(Integer dni) {

        Persona response = (Persona) this.database
                                        .getAll()
                                        .values()
                                        .stream()
                                        .filter(obj -> {
                                            Persona persona = (Persona) obj;
                                            if(persona.getDni().equals(dni))
                                                return true;
                                            return false;
                                        }).findFirst()
                                            .orElse(null);

        return response;
    }




    /**
     * @funcion: Listar todas las personas
     * @param: -
     * @resturn: Lista -> Persona
     * */
    public List<Persona> getAllElements() {
        List<Persona> listResponse = (List<Persona>) this.database
                                                        .getAll()
                                                        .values()
                                                        .stream()
                                                        .collect(Collectors.toList());

        return listResponse;
    }




    /**
     * @funcion: Agregar elemento
     * @param: Objeto persona
     * @resturn: verdadero o falso
     * */
    public Boolean addElement(Persona object) {
        if(object == null || !(object instanceof Persona))
            throw new IllegalArgumentException("EL OBJETO NO PUEDE SER NULO");

        this.database.add(object);

        return true;
    }




}
