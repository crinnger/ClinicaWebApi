package br.com.crinnger.ClinicasWebApi.repository;

import br.com.crinnger.ClinicasWebApi.model.security.RoleAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleAuthorityRepository extends JpaRepository<RoleAuthority,Long> {
}
