package br.com.crinnger.ClinicasWebApi.repository;

import br.com.crinnger.ClinicasWebApi.model.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExameRepository extends JpaRepository<Exame, UUID> {
}
