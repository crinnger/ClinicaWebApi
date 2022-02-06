package br.com.crinnger.ClinicasWebApi.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Resultado {

    @Id
    private Integer id;

    private Integer resultado;

    @ManyToOne
    private TabelaExame exame;

    private String descricao;
}
