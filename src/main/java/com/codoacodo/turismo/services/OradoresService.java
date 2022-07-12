package com.codoacodo.turismo.services;

import com.codoacodo.turismo.dto.OradorResponse;
import com.codoacodo.turismo.models.OradoresModel;
import com.codoacodo.turismo.repositories.ConocimientosRepository;
import com.codoacodo.turismo.repositories.OradoresRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
    @Service
    public class OradoresService {
        @Autowired
        OradoresRepository oradoresRepository;

        @Autowired
        ConocimientosRepository conocimientosRepository;

        public ArrayList<OradorResponse> obtenerOrador(){
            ArrayList<OradorResponse> ListaOradores = new ArrayList<OradorResponse>();
            ArrayList<OradoresModel> dbOradoresList =(ArrayList<OradoresModel>) oradoresRepository.findAll();
            for(OradoresModel dbOrador: dbOradoresList){
                OradorResponse nuevoOrador = new OradorResponse();
                nuevoOrador.setDescripcion(dbOrador.getDescripcion());
                nuevoOrador.setId(dbOrador.getId());
                nuevoOrador.setImagen(dbOrador.getImagen());
                nuevoOrador.setNombre(dbOrador.getNombre());
                System.out.println(conocimientosRepository.findByIdOrador(dbOrador.getId()));
                nuevoOrador.setConocimientos(conocimientosRepository.findByIdOrador(dbOrador.getId()));
                ListaOradores.add(nuevoOrador);
            }
            return ListaOradores;
            //findAll metodo de CrudRepository
        }
        public OradoresModel guardarOrador(OradoresModel orador){
            return oradoresRepository.save(orador);  //save metodo de CrudRepository
        }//**************** 2da etapa
        public Optional<OradoresModel> obtenerPorId(Long id){
            return oradoresRepository.findById(id);
        }
        public boolean eliminarOrador(Long id) {
            try{
                oradoresRepository.deleteById(id);
                return true;
            }catch(Exception err){
                return false;
            }
        }

        public Optional<OradoresModel> editarOrador(Long id, OradoresModel orador) {
            Optional<OradoresModel> viejoOrador = this.obtenerPorId(id);
            if (!viejoOrador.isEmpty()){
                viejoOrador.get().setDescripcion(orador.getDescripcion());
                viejoOrador.get().setImagen(orador.getImagen());
                viejoOrador.get().setNombre(orador.getNombre());
                oradoresRepository.save(viejoOrador.get());
            }
            return viejoOrador;
        }
    }
