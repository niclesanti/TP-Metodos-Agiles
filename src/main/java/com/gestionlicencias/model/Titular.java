package com.gestionlicencias.model;

import java.util.Date;

public class Titular {
    private Integer idTitular;
    private String tipoDocumento;
    private Long numeroDocumento;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String direccion;
    private String grupoSanguineo;
    private Licencia factorRH;
    private Boolean esDonanteOrganos;
}
