package com.gestionlicencias.gestionlicenciasconducir.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tramite")
public class Tramite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tramite")
    private Integer idTramite;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "descripcion", length = 255, nullable = false)
    private String descripcion;

    @Column(name = "costo", nullable = false)
    private Float costo;

    @ManyToOne
    @JoinColumn(name = "id_usuario_responsable", nullable = false)
    private Usuario usuarioResponsable;

    @ManyToOne
    @JoinColumn(name = "id_licencia_asociada", nullable = false)
    private Licencia licenciaAsociada;

    public Tramite() {
    }

    // Getters and Setters
    public Integer getIdTramite() { return idTramite; }
    public void setIdTramite(Integer idTramite) { this.idTramite = idTramite; }
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Float getCosto() { return costo; }
    public void setCosto(Float costo) { this.costo = costo; }
    public Usuario getUsuarioResponsable() { return usuarioResponsable; }
    public void setUsuarioResponsable(Usuario usuarioResponsable) { this.usuarioResponsable = usuarioResponsable; }
    public Licencia getLicenciaAsociada() { return licenciaAsociada; }
    public void setLicenciaAsociada(Licencia licenciaAsociada) { this.licenciaAsociada = licenciaAsociada; }
    // hashCode and equals methods
    @Override
    public int hashCode() {
        return idTramite != null ? idTramite.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tramite tramite = (Tramite) obj;
        return idTramite != null && idTramite.equals(tramite.idTramite);
    }

    // toString method
    @Override
    public String toString() {
        return "Tramite{" +
                "idTramite=" + idTramite +
                ", fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", costo=" + costo +
                ", usuarioResponsable=" + usuarioResponsable +
                ", licenciaAsociada=" + licenciaAsociada +
                '}';
    }
}