package com.ps.registro.services;

import com.ps.registro.modelo.Persona;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {



    public Persona guardar(Persona persona) throws Exception {

        if(persona.getId()<0 ){
            throw new Exception("El empleado no puede tener numeros menores o iguales a 0");
        }
        if(  persona.getCorreo()==null || persona.getCorreo().equals("")){
            throw new Exception("El usuario no tiene correo");
        }
        if(persona.getId()<=0 ){
            throw new Exception("El empleado no puede tener numeros menores o iguales a 0");
        }


        return persona;
    }
}