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
public class Estados{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_estado;

  private String nome;
  private String abreviacao;
    
}