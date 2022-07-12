package com.codoacodo.turismo.services;

import com.codoacodo.turismo.models.OradoresModel;
import com.codoacodo.turismo.repositories.OradoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
    @Service
    public class OradoresService {
        @Autowired
        OradoresRepository oradoresRepository;
        public ArrayList<OradoresModel> obtenerOrador(){
            return (ArrayList<OradoresModel>) oradoresRepository.findAll();
            //findAll metodo de CrudRepository
        }
        public OradoresModel guardarOrador(OradoresModel usuario){
            return oradoresRepository.save(usuario);  //save metodo de CrudRepository
        }//**************** 2da etapa
        public Optional<OradoresModel> obtenerPorId(Long id){
            return oradoresRepository.findById(id);
        }
        public ArrayList<OradoresModel>  obtenerPorPrioridad(Integer prioridad) {
            return oradoresRepository.findByPrioridad(prioridad);
        }
        public boolean eliminarOrador(Long id) {
            try{
                oradoresRepository.deleteById(id);
                return true;
            }catch(Exception err){
                return false;
            }
        }
    }
