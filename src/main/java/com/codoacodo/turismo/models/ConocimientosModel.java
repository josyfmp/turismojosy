package com.codoacodo.turismo.models;

import javax.persistence.*;

@Entity
@Table(name = "conocimientos")
public class ConocimientosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String style;
    private Long idOrador;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdOrador() {
        return idOrador;
    }

    public void setIdOrador(Long idOrador) {
        this.idOrador = idOrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
