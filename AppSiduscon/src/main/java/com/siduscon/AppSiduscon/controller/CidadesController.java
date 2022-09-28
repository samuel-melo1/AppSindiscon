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

import com.siduscon.AppSiduscon.model.Cidades;
import com.siduscon.AppSiduscon.repository.CidadesRepository;

@RestController
@RequestMapping({ "/cidades" })
public class CidadesController {

    private CidadesRepository repository;

    CidadesController(CidadesRepository cidadesRepository) {
        this.repository = cidadesRepository;
    }

    @GetMapping
    public List<Cidades> findAll() {
        return repository.findAll();
        // teste
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Cidades> findById(@PathVariable long id_cidade) {
        return repository.findById(id_cidade)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cidades create(@RequestBody Cidades cidades) {
        return repository.save(cidades);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cidades> update(@PathVariable("id_cidade") long id_cidade,
            @RequestBody Cidades cidades) {
        return repository.findById(id_cidade)
                .map(record -> {
                    record.setNome(cidades.getNome());
                    record.setAbreviacao(cidades.getAbreviacao());

                    Cidades updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<?> delete(@PathVariable("id_cidade") long id_cidade) {
        return repository.findById(id_cidade)
                .map(record -> {
                    repository.deleteById(id_cidade);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}