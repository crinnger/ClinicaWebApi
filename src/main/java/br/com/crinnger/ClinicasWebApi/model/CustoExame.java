package br.com.crinnger.ClinicasWebApi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
public class CustoExame {
    @Id
    private Long id;

    @ManyToOne
    private TabelaExame tabelaExame;

    private Double valor;

    private LocalDateTime vigenciaInicial;
    private LocalDateTime vigenciaFinal;

    private Integer idadeInicial;
    private Integer idadeFinal;
}

