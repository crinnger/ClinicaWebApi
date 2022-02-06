package br.com.crinnger.ClinicasWebApi.model.security;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RoleAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    @ManyToOne
    private Authority authority;

    private LocalDateTime dataInclusao;

    @ManyToOne(fetch = FetchType.LAZY)
    private User userInclusao;
}
