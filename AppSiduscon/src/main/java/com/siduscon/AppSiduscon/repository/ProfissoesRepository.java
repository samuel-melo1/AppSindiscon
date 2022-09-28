package com.siduscon.AppSiduscon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.siduscon.AppSiduscon.model.Profissoes;

@Repository
public interface ProfissoesRepository
        extends JpaRepository<Profissoes, Long> {
}