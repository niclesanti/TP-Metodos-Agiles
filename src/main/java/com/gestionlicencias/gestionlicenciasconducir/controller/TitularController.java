package com.gestionlicencias.gestionlicenciasconducir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gestionlicencias.gestionlicenciasconducir.model.Titular;
import com.gestionlicencias.gestionlicenciasconducir.service.TitularService;

@Controller
@RequestMapping("/api/titulares")
public class TitularController {

    private final TitularService service;

    @GetMapping("/registroTitular")
    public String mostrarFormulario() {
        return "registroTitular.html"; 
    }
    
    @Autowired
    public TitularController(TitularService service) {
        this.service = service;
    }

    @PostMapping("/crear")
    public ResponseEntity<Titular> crearTitular(@RequestBody Titular titular) {
        Titular creado = service.crearTitular(titular);
        return ResponseEntity.ok(creado);
    }

}
