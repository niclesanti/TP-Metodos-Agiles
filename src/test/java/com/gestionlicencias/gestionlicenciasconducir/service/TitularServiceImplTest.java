package com.gestionlicencias.gestionlicenciasconducir.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gestionlicencias.gestionlicenciasconducir.model.Titular;
import com.gestionlicencias.gestionlicenciasconducir.repository.TitularRepository;

public class TitularServiceImplTest {

    @Mock
    private TitularRepository titularRepository;

    @InjectMocks
    private TitularServiceImpl titularService;

    private Titular titular;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Crear un titular de ejemplo para usar en los tests
        titular = new Titular();
        titular.setIdTitular(1);
        titular.setDocumento("12345678");
        titular.setNombre("Juan");
        titular.setApellido("Perez");
    }

    @Test
    void testCrearTitularExitoso() {
        // Configurar el mock para que no exista un titular con el mismo documento
        when(titularRepository.existsByDocumento("12345678")).thenReturn(false);
        when(titularRepository.save(titular)).thenReturn(titular);

        // Llamar al método crearTitular
        Titular resultado = titularService.crearTitular(titular);

        // Verificar que el titular se creó correctamente
        assertNotNull(resultado, "El titular no debería ser nulo");
        assertEquals("12345678", resultado.getDocumento(), "El documento debería coincidir");
        verify(titularRepository, times(1)).save(titular);
    }

    @Test
    void testCrearTitularDocumentoDuplicado() {
        // Configurar el mock para que exista un titular con el mismo documento
        when(titularRepository.existsByDocumento("12345678")).thenReturn(true);

        // Verificar que se lanza una excepción al intentar crear un titular duplicado
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            titularService.crearTitular(titular);
        });

        assertEquals("Ya existe un titular con documento 12345678", exception.getMessage());
        verify(titularRepository, never()).save(titular);
    }

    @Test
    void testListarTitulares() {
        // Configurar el mock para devolver una lista de titulares
        List<Titular> titulares = Arrays.asList(titular);
        when(titularRepository.findAll()).thenReturn(titulares);

        // Llamar al método listarTitulares
        List<Titular> resultado = titularService.listarTitulares();

        // Verificar que la lista de titulares se recuperó correctamente
        assertNotNull(resultado, "La lista de titulares no debería ser nula");
        assertEquals(1, resultado.size(), "La lista debería contener un titular");
        assertEquals("12345678", resultado.get(0).getDocumento(), "El documento del titular debería coincidir");
        verify(titularRepository, times(1)).findAll();
    }
}
