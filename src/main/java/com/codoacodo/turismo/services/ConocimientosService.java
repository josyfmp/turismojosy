package com.codoacodo.turismo.services;

import com.codoacodo.turismo.models.ConocimientosModel;
import com.codoacodo.turismo.repositories.ConocimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ConocimientosService {
    @Autowired
    ConocimientosRepository conocimientosRepository;
    public ArrayList<ConocimientosModel> obtenerConocimientos(){
        return (ArrayList<ConocimientosModel>) conocimientosRepository.findAll();
        //findAll metodo de CrudRepository
    }
    public ConocimientosModel guardarConocimientos(ConocimientosModel conocimientos){
        return conocimientosRepository.save(conocimientos);  //save metodo de CrudRepository
    }//**************** 2da etapa
    public Optional<ConocimientosModel> obtenerPorId(Long id){
        return conocimientosRepository.findById(id);
    }
    public boolean eliminarConocimientos(Long id) {
        try{
            conocimientosRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public Optional<ConocimientosModel> editarConocimiento(Long id, ConocimientosModel conocimiento) {
        Optional<ConocimientosModel> viejoConocimiento = this.obtenerPorId(id);
        if(!viejoConocimiento.isEmpty()){
            ConocimientosModel conocimientodb = viejoConocimiento.get();
            conocimientodb.setIdOrador(conocimiento.getIdOrador());
            conocimientodb.setNombre(conocimiento.getNombre());
            conocimientodb.setStyle(conocimiento.getStyle());
        }
        return viejoConocimiento;

    }
}

