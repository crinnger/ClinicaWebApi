package br.com.crinnger.ClinicasWebApi.repository;

import br.com.crinnger.ClinicasWebApi.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato,Long> {


}
