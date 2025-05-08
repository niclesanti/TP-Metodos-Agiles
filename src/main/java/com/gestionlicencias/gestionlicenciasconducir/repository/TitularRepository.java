package com.gestionlicencias.gestionlicenciasconducir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionlicencias.gestionlicenciasconducir.model.Titular;

@Repository
public interface TitularRepository extends JpaRepository<Titular, Integer> {
    //Buscar si ya existe un titular por documento
    boolean existsByDocumento(String documento);
}
