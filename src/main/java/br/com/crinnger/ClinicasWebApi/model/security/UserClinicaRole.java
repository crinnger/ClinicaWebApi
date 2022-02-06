package br.com.crinnger.ClinicasWebApi.model.security;

import br.com.crinnger.ClinicasWebApi.model.Clinica;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.apache.commons.lang3.builder.HashCodeExclude;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EnableJpaAuditing
public class UserClinicaRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(optional = false)
    private Clinica clinica;

    @ManyToOne(optional = false)
    private Role role;

    private LocalDateTime inclusao;

    @ManyToOne(fetch = FetchType.LAZY)
    private User usuarioInclusao;


}
