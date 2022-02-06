package br.com.crinnger.ClinicasWebApi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class TabelaExame {
    @Id
    private Integer codigoExame;

    private String DescricaoExame;

    private Integer codigoExameRenach;

    @ManyToMany
    @JoinTable(name="TabelaExame_Observacao",
            joinColumns = {@JoinColumn(name = "TabelaExame_ID",referencedColumnName = "codigoExame")},
            inverseJoinColumns ={@JoinColumn(name = "Observacao_ID",referencedColumnName = "ID")})
    private List<Observacao> observacoes;

}
