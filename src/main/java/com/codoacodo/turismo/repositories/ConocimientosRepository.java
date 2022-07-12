package com.codoacodo.turismo.repositories;

import com.codoacodo.turismo.models.ConocimientosModel;
import com.codoacodo.turismo.models.PublicidadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ConocimientosRepository extends JpaRepository<ConocimientosModel, Long > {
    ArrayList<ConocimientosModel> findByIdOrador(Long idOrador);
}
