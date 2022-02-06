package br.com.crinnger.ClinicasWebApi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Categoria {

    @Id
    private Integer id;

    private String categoria;
}
