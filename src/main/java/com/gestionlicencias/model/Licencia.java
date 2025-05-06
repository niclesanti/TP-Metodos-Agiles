package com.gestionlicencias.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;
@Entity
@Table(name = "licencias")
public class Licencia {
    private Integer idLicencia;
    private Date fechaInicio;
    private Date fechaVencimiento;
    private Boolean estaVigente;
}
