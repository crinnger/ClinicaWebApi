package br.com.crinnger.ClinicasWebApi.repository;

import br.com.crinnger.ClinicasWebApi.model.security.UserClinicaRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserClinicaRoleRepository extends JpaRepository<UserClinicaRole, UUID> {
}
