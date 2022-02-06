package br.com.crinnger.ClinicasWebApi.model;

import br.com.crinnger.ClinicasWebApi.model.security.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EnableJpaAuditing
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    private Candidato candidato;

    @ManyToOne
    private TabelaExame exame;

    private Date dataExame;

    private String cnpjEntidade;

    @ManyToOne
    private Municipio municipio;

    @ManyToMany
    @JoinTable(name="Exame_Examinador",
            joinColumns = {@JoinColumn(name = "Exame_ID",referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "Examinador_ID",referencedColumnName = "ID")})
    private List<User> examinadores;

    @ManyToMany
    @JoinTable(name="Exame_Categoria",
            joinColumns = {@JoinColumn(name = "Exame_ID",referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "Categoria_ID",referencedColumnName = "ID")})
    private List<Categoria> categoriaPermitida;

    @ManyToOne
    private Resultado resultado;

    @ManyToMany
    @JoinTable(name="Exame_Observacao",
            joinColumns = {@JoinColumn(name = "Observacao_ID",referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "Exame_ID",referencedColumnName = "ID")})
    private List<Observacao> observacoes;

    private String outrasObervacos;

    private Date dataHoraInclusao;

    private User usuarioInclusao;

    private Integer revisao;

    private Integer periodoInaptidao;

}
