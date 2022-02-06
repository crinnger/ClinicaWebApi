package br.com.crinnger.ClinicasWebApi.model.security;

import lombok.*;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User implements UserDetails, CredentialsContainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String password;

    @Column(nullable = false,unique = true)
    private String username;
    private String name;
    private String email;

    @Singular
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<UserClinicaRole> userClinicaRoles;

    @Transient
    public Set<GrantedAuthority> getAuthorities() {
        return this.userClinicaRoles.stream()
                .map(UserClinicaRole::getRole)
                .map(Role::getAuthorities)
                .flatMap(Set::stream)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    @Builder.Default
    private boolean accountNonExpired=true;
    @Builder.Default
    private boolean accountNonLocked=true;
    @Builder.Default
    private boolean credentialsNonExpired=true;
    @Builder.Default
    private boolean enabled=true;

    private LocalDateTime dataInclusao;

    @ManyToOne(fetch = FetchType.LAZY)
    private User userInclusao;


    @Override
    public void eraseCredentials() {
        this.password=null;
    }
}
