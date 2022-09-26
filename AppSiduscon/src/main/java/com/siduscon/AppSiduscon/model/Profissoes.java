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
public class Profissoes{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_profissao;

  private String nome;
  private String descricao;
  private int voto_qualidade;
  private String diretorio;
    
  @OneToMany(mappedBy= "Profissoes")
  private List<Cadastros_usuario> cadastros_usuarios;
}