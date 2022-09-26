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
public class Cadastros_usuario{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String email;
  private int cpf_cnpj;
  private String endereco;
  private String bairro;
  private int telefone;
  private String prestador_cliente;
  private String senha;
  private String sobrenome;
  private int idade;
  private String nome_empresa;

@ManyToOne
@JoinColumn(nome="id_cidade", nullable=false)
  private Cidades cidade;

@ManyToOne
@JoindColumn(nome="id_profissao", nullable=false)
  private Profissoes profissao;

@OneToMany(mappedBy="Cadastros_usuario")
  private List<Redes_sociais> redes_sociais;
}