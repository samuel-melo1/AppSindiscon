package com.siduscon.AppSiduscon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.siduscon.AppSiduscon.model.Cadastros_usuario;

@Repository
public interface Cadastros_usuarioRepository
        extends JpaRepository<Cadastros_usuario, Long> {
}