package br.com.crinnger.ClinicasWebApi.model;

import br.com.crinnger.ClinicasWebApi.model.security.UserClinicaRole;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EnableJpaAuditing
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String CNPJ;

    private String razaoSocial;

    private String nomeFantasia;

    @ManyToOne
    private Municipio municipio;

    private String Endereco;

    @OneToMany(mappedBy = "clinica")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<UserClinicaRole> userClinicaList;


}
