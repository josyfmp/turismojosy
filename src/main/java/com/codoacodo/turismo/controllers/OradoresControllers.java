package com.codoacodo.turismo.controllers;

import com.codoacodo.turismo.dto.OradorResponse;
import com.codoacodo.turismo.models.OradoresModel;
import com.codoacodo.turismo.services.OradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/oradores")         // mapea     /oradores
    public class OradoresControllers {
    @Autowired
   OradoresService oradoresService;

    @CrossOrigin   // para solucionar error “cors”
    @GetMapping("/")      //trae todos los oradorees y lo mapea  /oradores
    public  ArrayList<OradorResponse> obtenerUsuarios(){
        return oradoresService.obtenerOrador();
    }

    @CrossOrigin
    @PostMapping("/")    //   graba un orador
    public OradoresModel guardarUsuario(@RequestBody OradoresModel oradores){
        return this.oradoresService.guardarOrador(oradores);
    }

    @CrossOrigin
    @GetMapping( path = "/{id}")    // trae un orador segun id
    public Optional<OradoresModel> obtenerOradoresPorId(@PathVariable("id") Long id) {
        return this.oradoresService.obtenerPorId(id);
    }

    @CrossOrigin
    @DeleteMapping( path = "/{id}")   // borra un orador con determinado id
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.oradoresService.eliminarOrador(id);
        if (ok){
            return "Se eliminó el orador con id " + id;
        }else{
            return "No pudo eliminar el orador con id" + id;
        }
    }

    @CrossOrigin
    @PutMapping( path = "/{id}")    // trae una publicidad segun id
    public Optional<OradoresModel> EditarPublicidad(@PathVariable("id") Long id, @RequestBody OradoresModel orador) {
        return this.oradoresService.editarOrador(id, orador);
    }
}
