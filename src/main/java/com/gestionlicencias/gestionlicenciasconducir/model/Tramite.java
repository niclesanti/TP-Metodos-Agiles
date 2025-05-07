package com.gestionlicencias.gestionlicenciasconducir.model;

import java.util.Date;

public class Tramite {
    private Integer idTramite;
    private Date fecha;
    private String descripcion;
    private Float costo;
    private Usuario usuarioResponsable;
    private Licencia licenciaAsociada;
}
