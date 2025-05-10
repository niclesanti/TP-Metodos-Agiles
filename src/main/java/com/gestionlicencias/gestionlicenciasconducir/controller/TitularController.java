package com.gestionlicencias.gestionlicenciasconducir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    @PostMapping("/crear")
    public ResponseEntity<Titular> crearTitular(@RequestBody Titular titular) {
        Titular creado = service.crearTitular(titular);
        return ResponseEntity.ok(creado);
    }

    // Manejo de excepciones (necesito esto para correr los tests)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArg(IllegalArgumentException ex) {
        // 400 Bad Request o 500 según prefieras
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    
    //Cosas del front (revisar porque no creo que esto vaya aquí)

    @GetMapping
    public String mostrarMenu() {  return "menuTitular";    }

    @GetMapping("/registroTitular")
    public String mostrarFormulario() {   return "registroTitular";    }

    @GetMapping("/modificar")
    public String mostrarFormularioModificar() {   return "modificarTitular";    }

    //modificar
    // No entiendo por qué esto (no existía esta tarea en el proyecto)
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
