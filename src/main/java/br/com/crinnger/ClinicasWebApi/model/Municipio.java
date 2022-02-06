package br.com.crinnger.ClinicasWebApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Municipio")
public class Municipio {

    @Id
    private Integer codigo;

    private String nome;

    private String uf;
}
