package com.codoacodo.turismo.dto;

import com.codoacodo.turismo.models.ConocimientosModel;

import java.util.List;

public class OradorResponse {

    private Long id;

    private String nombre;
    private String descripcion;
    private String imagen;

    public OradorResponse() {
    }

    public OradorResponse(Long id, String nombre, String descripcion, String imagen, List<ConocimientosModel> conocimientos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.conocimientos = conocimientos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<ConocimientosModel> getConocimientos() {
        return conocimientos;
    }

    public void setConocimientos(List<ConocimientosModel> conocimientos) {
        this.conocimientos = conocimientos;
    }

    private List<ConocimientosModel> conocimientos;
}
