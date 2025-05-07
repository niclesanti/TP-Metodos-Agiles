package com.gestionlicencias.gestionlicenciasconducir.service;

import java.util.List;

import com.gestionlicencias.gestionlicenciasconducir.model.Titular;

public interface TitularService {
    Titular crearTitular(Titular titular);
    List<Titular> listarTitulares();
    // …otros métodos: buscarPorId, eliminar, etc.
}
