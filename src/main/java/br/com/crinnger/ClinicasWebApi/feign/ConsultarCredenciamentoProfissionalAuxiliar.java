package br.com.crinnger.ClinicasWebApi.feign;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ConsultarCredenciamentoProfissionalAuxiliar implements Serializable {

  private static final long serialVersionUID = 1L;

  private String mensagemRetorno;
  private String cpf;
  private String dataPesquisa;
  private String tipoProfissional;

}