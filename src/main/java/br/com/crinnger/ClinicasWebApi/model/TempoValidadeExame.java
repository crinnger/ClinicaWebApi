package br.com.crinnger.ClinicasWebApi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class TempoValidadeExame {

    @Id
    private Integer id;

    private LocalDateTime vigenciaInicial;
    private LocalDateTime vigenciaFinal;

    private Integer idadeInicial;
    private Integer idadeFinal;

    private Integer tempoValidade;
}
