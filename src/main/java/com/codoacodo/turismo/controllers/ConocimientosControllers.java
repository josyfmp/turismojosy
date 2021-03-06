package com.codoacodo.turismo.controllers;

import com.codoacodo.turismo.models.ConocimientosModel;
import com.codoacodo.turismo.models.OradoresModel;
import com.codoacodo.turismo.services.ConocimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/conocimientos")         // mapea     /conocimientos
public class ConocimientosControllers {
    @Autowired
    ConocimientosService conocimientosService;

    @CrossOrigin   // para solucionar error “cors”
    @GetMapping("/")      //trae todos los conocimientos y lo mapea  /conocimientos
    public ArrayList<ConocimientosModel> obtenerConocimientos(){

        return conocimientosService.obtenerConocimientos();
    }

    @CrossOrigin
    @PostMapping("/")    //   graba un conocimiento
    public ConocimientosModel guardarConocimientos(@RequestBody ConocimientosModel conocimientos){
        return this.conocimientosService.guardarConocimientos(conocimientos);
    }

    @CrossOrigin
    @GetMapping( path = "/{id}")    // trae un conocimiento segun id
    public Optional<ConocimientosModel> obtenerConocimientosPorId(@PathVariable("id") Long id) {
        return this.conocimientosService.obtenerPorId(id);
    }

    @CrossOrigin
    @DeleteMapping( path = "/{id}")   // borra un conocimiento con determinado id
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.conocimientosService.eliminarConocimientos(id);
        if (ok){
            return "Se eliminó el conocimiento con id " + id;
        }else{
            return "No pudo eliminar el conocimiento con id" + id;
        }
    }

    @CrossOrigin
    @PutMapping( path = "/{id}")    // trae una publicidad segun id
    public Optional<ConocimientosModel> EditarConocimiento(@PathVariable("id") Long id, @RequestBody ConocimientosModel conocimiento) {
        return this.conocimientosService.editarConocimiento(id, conocimiento);
    }
}
