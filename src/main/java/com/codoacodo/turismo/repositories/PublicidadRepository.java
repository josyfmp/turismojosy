package com.codoacodo.turismo.repositories;

import com.codoacodo.turismo.models.PublicidadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PublicidadRepository extends JpaRepository<PublicidadModel, Long > {

    ArrayList<PublicidadModel> findByPrioridad(Integer prioridad);
}
