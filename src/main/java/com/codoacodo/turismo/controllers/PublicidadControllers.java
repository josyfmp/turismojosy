package com.codoacodo.turismo.controllers;

import com.codoacodo.turismo.models.PublicidadModel;
import com.codoacodo.turismo.services.PublicidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/publicidad")         // mapea     /publicidad

public class PublicidadControllers {
    @Autowired
    PublicidadService publicidadService;

    @CrossOrigin   // para solucionar error “cors”
    @GetMapping("/")      //trae todas las publicidads y lo mapea  /publicidad
    public ArrayList<PublicidadModel> obtenerPublicidad(){
        return publicidadService.obtenerPublicidad();
    }

    @CrossOrigin
    @PostMapping("/")    //   graba una publicidad
    public PublicidadModel guardarPublicidad(@RequestBody PublicidadModel publicidad){
        return this.publicidadService.guardarPublicidad(publicidad);
    }


    @CrossOrigin
    @GetMapping( path = "/{id}")    // trae una publicidad segun id
    public Optional<PublicidadModel> obtenerPublicidadPorId(@PathVariable("id") Long id) {
        return this.publicidadService.obtenerPorId(id);
    }

    @CrossOrigin
    @PutMapping( path = "/{id}")    // trae una publicidad segun id
    public Optional<PublicidadModel> EditarPublicidad(@PathVariable("id") Long id, @RequestBody PublicidadModel publicidad) {
        return this.publicidadService.editarPublicidad(id, publicidad);
    }

    @CrossOrigin
    @DeleteMapping( path = "/{id}")   // borra una publicidad con determinado id
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.publicidadService.eliminarPublicidad(id);
        if (ok){
            return "Se eliminó la publicidad por con id " + id;
        }else{
            return "No pudo eliminar la publicidad con id" + id;
        }
    }
}
