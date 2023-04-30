package com.ps.registro.services;

import com.ps.registro.modelo.Registro;
import org.springframework.stereotype.Service;
public class RegistroService {


    public Registro guardar(Registro registro) throws Exception {

        if(registro.getId()<0 ){
            throw new Exception("El empleado no puede tener numeros menores o iguales a 0");
        }

        if(registro.getId()<=0 ){
            throw new Exception("El empleado no puede tener numeros menores o iguales a 0");
        }


        return registro;
    }
}
