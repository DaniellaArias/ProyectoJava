package com.ps.registro.services;

import com.ps.registro.modelo.Persona;
import com.ps.registro.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaService implements  IPersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Transactional()
    @Override
    public Persona guardar(Persona persona) throws Exception {

        if (persona.getId() < 0) {
            throw new Exception("El empleado no puede tener numeros menores o iguales a 0");
        }
        if (persona.getCorreo() == null || persona.getCorreo().equals("")) {
            throw new Exception("El usuario no tiene correo");
        }
        if (persona.getIdentificacion() == null || persona.getIdentificacion().equals("")) {
            throw new Exception("El usuario no tiene identificacion");
        }


        //TODO Terminar las validaciones.

        return  personaRepository.save(persona);
    }

    @Override
    public Persona consultar(Long id) throws Exception {

        if (id==null || id<1){
            throw new Exception("El id enviado no es valido");
        }

        return personaRepository.getOne(id);
    }

    @Override
    @Transactional()
    public Persona actualizar(Persona persona) throws Exception {

        Persona resultado=consultar((long) persona.getId());

        if (persona.getCorreo() != null && !persona.getCorreo().equals("")) {
            resultado.setCorreo(persona.getCorreo());
        }

        if (persona.getNombres() != null && !persona.getNombres().equals("")) {
            resultado.setNombres(persona.getNombres());
        }




        //TODO Terminar las validaciones.

        return  personaRepository.save(persona);
    }
}