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

    @Autowired
    public TitularController(TitularService service) {
        this.service = service;
    }

    @GetMapping
    public String mostrarMenu() {  return "menuTitular";    }

    @GetMapping("/registroTitular")
    public String mostrarFormulario() {   return "registroTitular";    }

    @PostMapping("/crear")
    public ResponseEntity<Titular> crearTitular(@RequestBody Titular titular) {
        Titular creado = service.crearTitular(titular);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/modificar")
    public String mostrarFormularioModificar() {   return "modificarTitular";    }

    //modificar
    @PostMapping("/modificar")
    public ResponseEntity<Titular> modificarTitular(@RequestBody Titular titular) {
        Titular modificado = service.crearTitular(titular);//Modificar crear por registrar
        return ResponseEntity.ok(modificado);
    }

    //eliminar
    @GetMapping("/eliminar")
    public String mostrarFormularioEliminar() {   return "eliminarTitular";    }

    //listar
    @GetMapping("/listar")
    public String mostrarFormularioListar() {   return "listarTitular";    }



}
