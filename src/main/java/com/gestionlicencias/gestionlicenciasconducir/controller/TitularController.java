package com.gestionlicencias.gestionlicenciasconducir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TitularController {

    @GetMapping("/registroTitular")
    public String mostrarFormulario() {
        return "registroTitular.html"; 
    }
}
