package br.com.crinnger.ClinicasWebApi.model.security;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String name;

    @Singular
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "role")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<RoleAuthority> roleAuthorities;

    @Transient
    public Set<String> getAuthorities(){
        return this.roleAuthorities.stream()
                .map(RoleAuthority::getAuthority)
                .map(Authority::getPermission)
                .collect(Collectors.toSet());
    }

}
