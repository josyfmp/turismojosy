package com.codoacodo.turismo.controllers;

import com.codoacodo.turismo.models.OradoresModel;
import com.codoacodo.turismo.services.OradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/oradores")         // mapea     /oradores
    public class OradoresControllers {
    @Autowired
    com.codoacodo.turismo.services.OradoresService OradoresService;
    @CrossOrigin   // para solucionar error “cors”
    @GetMapping()      //trae todos los oradorees y lo mapea  /oradores
    public ArrayList<OradoresModel> obtenerUsuarios(){
        return OradoresService.obtenerOrador();
    }
    @CrossOrigin
    @PostMapping()    //   graba un orador
    public OradoresModel guardarUsuario(@RequestBody OradoresModel oradores){
        return this.OradoresService.guardarOrador(oradores);
    }

    @CrossOrigin
    @GetMapping( path = "/{id}")    // trae un orador segun id
    public Optional<OradoresModel> obtenerOradoresPorId(@PathVariable("id") Long id) {
        return this.OradoresService.obtenerPorId(id);
    }

    @CrossOrigin
    @GetMapping("/query")        // trae los oradores con determinada prioridad
    public ArrayList<OradoresModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.OradoresService.obtenerPorPrioridad(prioridad);
    }
    @CrossOrigin
    @DeleteMapping( path = "/{id}")   // borra un orador con determinado id
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.OradoresService.eliminarOrador(id);
        if (ok){
            return "Se eliminó el orador con id " + id;
        }else{
            return "No pudo eliminar el orador con id" + id;
        }
    }
}
