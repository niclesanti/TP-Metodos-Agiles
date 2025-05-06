package com.gestionlicencias.model;



import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(name="nombre_usuario", nullable = false, length = 20)
    private String nombreUsuario;
    @Column(name="contrasena", nullable = false, length = 20)
    private String contrasena;
    @Column(name="rol", nullable = false, length = 30)
    private String rol;
}
