package com.codoacodo.turismo.repositories;

import com.codoacodo.turismo.models.OradoresModel;
import com.codoacodo.turismo.models.PublicidadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OradoresRepository extends JpaRepository<OradoresModel, Long > {
}
