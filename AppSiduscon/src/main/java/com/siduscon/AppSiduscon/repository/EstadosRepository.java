package com.siduscon.AppSiduscon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.siduscon.AppSiduscon.model.Estados;

@Repository
public interface EstadosRepository
        extends JpaRepository<Estados, Long> {
}