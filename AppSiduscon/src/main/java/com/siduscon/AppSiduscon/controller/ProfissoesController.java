package com.siduscon.AppSiduscon.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siduscon.AppSiduscon.model.Profissoes;
import com.siduscon.AppSiduscon.repository.ProfissoesRepository;

@RestController
@RequestMapping({ "/profissoes" })
public class ProfissoesController {

    private ProfissoesRepository repository;

    ProfissoesController(ProfissoesRepository profissoesRepository) {
        this.repository = profissoesRepository;
    }

    @GetMapping
    public List<Profissoes> findAll() {
        return repository.findAll();
        // teste
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Profissoes> findById(@PathVariable long id_profissao) {
        return repository.findById(id_profissao)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Profissoes create(@RequestBody Profissoes profissoes) {
        return repository.save(profissoes);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Profissoes> update(@PathVariable("id_profissao") long id_profissao,
            @RequestBody Profissoes profissoes) {
        return repository.findById(id_profissao)
                .map(record -> {
                    record.setNome(profissoes.getNome());
                    record.setDescricao(profissoes.getDescricao());
                    record.setVoto_qualidade(profissoes.getVoto_qualidade());
                    record.setDiretorio(profissoes.getDiretorio());
                    Profissoes updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<?> delete(@PathVariable("id_profissao") long id_profissao) {
        return repository.findById(id_profissao)
                .map(record -> {
                    repository.deleteById(id_profissao);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}