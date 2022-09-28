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

import com.siduscon.AppSiduscon.model.Estados;
import com.siduscon.AppSiduscon.repository.EstadosRepository;

@RestController
@RequestMapping({ "/estados" })
public class EstadosController {

    private EstadosRepository repository;

    EstadosController(EstadosRepository estadosRepository) {
        this.repository = estadosRepository;
    }

    @GetMapping
    public List<Estados> findAll() {
        return repository.findAll();
        // teste
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Estados> findById(@PathVariable long id_estado) {
        return repository.findById(id_estado)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estados create(@RequestBody Estados estados) {
        return repository.save(estados);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Estados> update(@PathVariable("id_estado") long id_estado,
            @RequestBody Estados estados) {
        return repository.findById(id_estado)
                .map(record -> {
                    record.setNome(estados.getNome());
                    record.setAbreviacao(estados.getAbreviacao());
                    Estados updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<?> delete(@PathVariable("id_estado") long id_estado) {
        return repository.findById(id_estado)
                .map(record -> {
                    repository.deleteById(id_estado);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}