package br.com.crinnger.ClinicasWebApi.model;

import br.com.crinnger.ClinicasWebApi.model.security.User;
import br.com.crinnger.ClinicasWebApi.enums.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EnableJpaAuditing
public class Pagamentos {

    @Id
    private Long id;

    @ManyToOne
    private Candidato candidato;

    @OneToMany
    private List<PagamentoExame> exames;

    @ManyToOne
    private Clinica clinica;

    private Double valorTotal;

    private LocalDateTime inclusao;

    private LocalDateTime baixaPagamento;

    @ManyToOne
    private User usuarioBaixa;

    private TipoPagamento tipoPagamento;

}
