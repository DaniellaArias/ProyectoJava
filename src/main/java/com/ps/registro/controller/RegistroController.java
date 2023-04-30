package com.ps.registro.controller;

import com.ps.registro.modelo.Registro;
import com.ps.registro.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro")
public class RegistroController {
    @Autowired
    RegistroService registroSevice;

    @GetMapping("/{id}")
    public ResponseEntity<Registro> consultar(@PathVariable("id") int id) {
        Registro registro = new Registro();
        registro.setId(id);
        return ResponseEntity.ok(registro);
    }

    @PostMapping("/")
    public ResponseEntity<Registro> guardar(@RequestBody Registro registro) {
        try {
            registroSevice.guardar(registro);
            return ResponseEntity.ok(registro);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/")
    public ResponseEntity<Registro> actualizar(@RequestBody Registro registro) {
        return ResponseEntity.ok(registro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Registro> borrar(@PathVariable("id") int id) {
        Registro registro = new Registro();
        registro.setId(id);
        return ResponseEntity.ok(registro);
    }
}
