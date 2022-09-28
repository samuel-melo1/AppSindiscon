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

import com.siduscon.AppSiduscon.model.Cadastros_usuario;
import com.siduscon.AppSiduscon.repository.Cadastros_usuarioRepository;

@RestController
@RequestMapping({ "/usuarios" })
public class Cadastros_usuarioController {

    private Cadastros_usuarioRepository repository;

    Cadastros_usuarioController(Cadastros_usuarioRepository cadastros_usuarioRepository) {
        this.repository = cadastros_usuarioRepository;
    }

    @GetMapping
    public List<Cadastros_usuario> findAll() {
        return repository.findAll();
	// teste
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Cadastros_usuario> findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cadastros_usuario create(@RequestBody Cadastros_usuario cadastros_usuario) {
        return repository.save(cadastros_usuario);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cadastros_usuario> update(@PathVariable("id") long id,
            @RequestBody Cadastros_usuario cadastros_usuario) {
        return repository.findById(id)
                .map(record -> {
                    record.setNome(cadastros_usuario.getNome());
                    record.setEmail(cadastros_usuario.getEmail());
                    record.setCpf_cnpj(cadastros_usuario.getCpf_cnpj());
                    record.setEndereco(cadastros_usuario.getEndereco());
                    record.setBairro(cadastros_usuario.getBairro());
                    record.setTelefone(cadastros_usuario.getTelefone());
                    record.setPrestador_cliente(cadastros_usuario.getPrestador_cliente());
                    record.setSenha(cadastros_usuario.getSenha());
                    record.setSobrenome(cadastros_usuario.getSobrenome());
                    record.setIdade(cadastros_usuario.getIdade());
                    record.setNome_empresa(cadastros_usuario.getNome_empresa());
                    Cadastros_usuario updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}