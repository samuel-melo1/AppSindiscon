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
public class Redes_sociais{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_redes_sociais;

  private String linkedin;
  private String instagram;
  private String whatsapp;
  private String telegram;
  private String facebook;
  private String youtube;

  @ManyToOne
  @JoinColumn(nome = "id", nullable=false)
    private Cadastros_usuario cadastros_usuario;


}