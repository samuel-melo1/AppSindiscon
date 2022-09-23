package com.siduscon.AppSiduscon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.siduscon.AppSiduscon.model.Cidades;

@Repository
public interface CidadesRepository
        extends JpaRepository<Cidades, Long> {
}