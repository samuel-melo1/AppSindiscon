package com.siduscon.AppSiduscon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cidades{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_cidade;

  private String nome;
  private String abreviacao;

  @OneToMany(mappedBy = "Cidades")    
  private List<Cadastros_usuario> cadastros_usuarios;

  @ManyToOne(nome = "id_estado", nullable=false)
    private Estados estado;
}