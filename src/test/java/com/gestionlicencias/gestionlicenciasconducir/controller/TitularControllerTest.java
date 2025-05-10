package com.gestionlicencias.gestionlicenciasconducir.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestionlicencias.gestionlicenciasconducir.model.Titular;
import com.gestionlicencias.gestionlicenciasconducir.model.TipoDocumento;
import com.gestionlicencias.gestionlicenciasconducir.service.TitularService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TitularController.class)
class TitularControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TitularService service;

    private ObjectMapper mapper;
    private Titular ejemplo;

    @BeforeEach
    void setUp() {
        // Jackson JSON mapper
        mapper = new ObjectMapper()
                   .findAndRegisterModules(); // para java.util.Date

        // Datos de ejemplo
        ejemplo = new Titular();
        ejemplo.setIdTitular(1);
        ejemplo.setTipoDocumento(TipoDocumento.DNI);
        ejemplo.setDocumento("12345678");
        ejemplo.setNombre("Juan");
        ejemplo.setApellido("Perez");
        ejemplo.setFechaNacimiento(new Date());
        ejemplo.setDireccion("Calle Falsa 123");
        ejemplo.setGrupoSanguineo("O+");
        ejemplo.setFactorRH("+");
        ejemplo.setDonanteOrganos(true);
    }

    @Test
    void crearTitular_deberiaResponder200yJson() throws Exception {
        // Dado que el servicio devuelve correctamente el ejemplo
        given(service.crearTitular(any(Titular.class)))
            .willReturn(ejemplo);

        // Cuando hacemos POST a /api/titulares/crear con el JSON de ejemplo
        mockMvc.perform(post("/api/titulares/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(ejemplo)))
            // Entonces esperamos HTTP 200 OK
            .andExpect(status().isOk())
            // Y el JSON de respuesta contiene los campos esperados
            .andExpect(jsonPath("$.idTitular").value(1))
            .andExpect(jsonPath("$.documento").value("12345678"))
            .andExpect(jsonPath("$.nombre").value("Juan"))
            .andExpect(jsonPath("$.apellido").value("Perez"));
    }

    @Test
    void crearTitular_siElServicioLanzaError_resp400() throws Exception {
        // Simulamos que el servicio lanza una excepción conocida
        doThrow(new IllegalArgumentException("Doc duplicado"))
            .when(service).crearTitular(any(Titular.class));

        // Esperamos un 400 con el mensaje de error
        mockMvc.perform(post("/api/titulares/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(ejemplo)))
            .andExpect(status().isBadRequest())
            .andExpect(content().string("Doc duplicado"));
    }
}
