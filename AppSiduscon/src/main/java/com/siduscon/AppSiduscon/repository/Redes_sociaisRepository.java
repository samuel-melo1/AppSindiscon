package com.siduscon.AppSiduscon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.siduscon.AppSiduscon.model.Redes_sociais;

@Repository
public interface Redes_sociaisRepository
        extends JpaRepository<Redes_sociais, Long> {
}