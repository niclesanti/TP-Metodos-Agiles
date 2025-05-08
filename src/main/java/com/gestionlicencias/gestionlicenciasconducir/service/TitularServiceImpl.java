package com.gestionlicencias.gestionlicenciasconducir.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionlicencias.gestionlicenciasconducir.model.Titular;
import com.gestionlicencias.gestionlicenciasconducir.repository.TitularRepository;

@Service
public class TitularServiceImpl implements TitularService {

    private final TitularRepository repository;

    @Autowired
    public TitularServiceImpl(TitularRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Titular crearTitular(Titular titular) {
        // Puedes validar aquí, e.g. documento único:
        if (repository.existsByDocumento(titular.getDocumento())) {
            throw new IllegalArgumentException(
                "Ya existe un titular con documento " + titular.getDocumento());
        }
        return repository.save(titular);
    }

    @Override
    public List<Titular> listarTitulares() {
        return repository.findAll();
    }

}
