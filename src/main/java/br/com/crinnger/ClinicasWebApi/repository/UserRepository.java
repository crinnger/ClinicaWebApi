package br.com.crinnger.ClinicasWebApi.repository;

import br.com.crinnger.ClinicasWebApi.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    public Optional<User> findByUsername(String username);
}
