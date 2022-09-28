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

import com.siduscon.AppSiduscon.model.Redes_sociais;
import com.siduscon.AppSiduscon.repository.Redes_sociaisRepository;

@RestController
@RequestMapping({ "/redes-sociais" })
public class Redes_sociaisController {

    private Redes_sociaisRepository repository;

    Redes_sociaisController(Redes_sociaisRepository redes_sociaisRepository) {
        this.repository = redes_sociaisRepository;
    }

    @GetMapping
    public List<Redes_sociais> findAll() {
        return repository.findAll();
        // teste
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Redes_sociais> findById(@PathVariable long id_redes_sociais) {
        return repository.findById(id_redes_sociais)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Redes_sociais create(@RequestBody Redes_sociais redes_sociais) {
        return repository.save(redes_sociais);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Redes_sociais> update(@PathVariable("id_redes_sociais") long id_redes_sociais,
            @RequestBody Redes_sociais redes_sociais) {
        return repository.findById(id_redes_sociais)
                .map(record -> {
                    record.setLinkedin(redes_sociais.getLinkedin());
                    record.setInstagram(redes_sociais.getInstagram());
                    record.setWhatsapp(redes_sociais.getWhatsapp());
                    record.setTelegram(redes_sociais.getTelegram());
                    record.setFacebook(redes_sociais.getFacebook());
                    record.setYoutube(redes_sociais.getYoutube());
                    Redes_sociais updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<?> delete(@PathVariable("id_redes_sociais") long id_redes_sociais) {
        return repository.findById(id_redes_sociais)
                .map(record -> {
                    repository.deleteById(id_redes_sociais);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}