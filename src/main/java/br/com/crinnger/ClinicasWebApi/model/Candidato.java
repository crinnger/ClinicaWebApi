package br.com.crinnger.ClinicasWebApi.model;

import br.com.crinnger.ClinicasWebApi.model.security.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EnableJpaAuditing
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String formrenach;
    private Integer CPF;
    private String protocolo;
    private String servico;

    @ManyToMany
    @JoinTable(name="Candidato_Categoria",
            joinColumns = {@JoinColumn(name = "Candidato_ID",referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "Categoria_ID",referencedColumnName = "ID")})
    private List<Categoria> categorias;

    private LocalDate dataSolicitacao;
    private LocalDate dataPagamento;
    private LocalDate dataValidade;
    private LocalDate dataColeta;
    private String indicAtividadeRemunerada;

    @ManyToOne
    private Clinica clinicaMedica;

    @ManyToOne
    private Clinica clinicaPsicologica;

    private LocalDate dataInclusao;

    @ManyToOne
    private User usuarioAtendimento;
}
