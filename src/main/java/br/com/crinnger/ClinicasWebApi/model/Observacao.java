package br.com.crinnger.ClinicasWebApi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Observacao {

    @Id
    private Integer id;

    private String observacao;

    private String descricao;

    @ManyToMany(mappedBy = "observacoes")
    private List<TabelaExame> tabelaExames;
}
