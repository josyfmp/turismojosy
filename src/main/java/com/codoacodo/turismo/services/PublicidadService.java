package com.codoacodo.turismo.services;

import com.codoacodo.turismo.models.PublicidadModel;
import com.codoacodo.turismo.repositories.PublicidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class PublicidadService {
        @Autowired
        PublicidadRepository publicidadRepository;
        public ArrayList<PublicidadModel> obtenerPublicidad(){
            return (ArrayList<PublicidadModel>) publicidadRepository.findAll();
            //findAll metodo de CrudRepository
        }
        public PublicidadModel guardarPublicidad(PublicidadModel publicidad){
            return publicidadRepository.save(publicidad);  //save metodo de CrudRepository
        }//**************** 2da etapa
        public Optional<PublicidadModel> obtenerPorId(Long id){
            return publicidadRepository.findById(id);
        }
        public boolean eliminarPublicidad(Long id) {
            try{
                publicidadRepository.deleteById(id);
                return true;
            }catch(Exception err){
                return false;
            }
        }

    public Optional<PublicidadModel> editarPublicidad(Long id, PublicidadModel publicidad) {
           Optional<PublicidadModel> viejaPublicidad = this.obtenerPorId(id);
           if (!viejaPublicidad.isEmpty()){
               viejaPublicidad.get().setDescripcion(publicidad.getDescripcion());
               viejaPublicidad.get().setImagen(publicidad.getImagen());
               viejaPublicidad.get().setTitulo(publicidad.getTitulo());
               publicidadRepository.save(viejaPublicidad.get());
           }
           return viejaPublicidad;

    }
}
