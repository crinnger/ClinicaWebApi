package br.com.crinnger.ClinicasWebApi.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EnableJpaAuditing
public class PagamentoExame {

    @Id
    private Long id;

    @ManyToOne
    private TabelaExame exame;

    @ManyToOne
    private Pagamentos pagamentos;

    private Double valor;
}
