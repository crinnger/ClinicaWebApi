package br.com.crinnger.ClinicasWebApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EnableJpaAuditing
public class ExamePsicologico implements Serializable  {

    @Id
    @OneToOne
    private Exame exame;

    private String tipo;


}
