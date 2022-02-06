package br.com.crinnger.ClinicasWebApi.feign;

import java.io.Serializable;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredenciamentoProfissionalResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private String mensagemRetorno;
  
//  @ApiModelProperty(notes = "CPF Válido com 11 digitos", example = "99999999999")
  private String cpf;
  
//  @ApiModelProperty(notes = "AAAAMMDD", example = "19990210")
  private String dataPesquisa;
  
/**  @ApiModelProperty(notes = "'00' PARA TODOS OS TIPOS\n"
  		+ "01 'Diretor Geral'\n"
  		+ "02 'Diretor de Ensino'\n"
  		+ "03 'Examinador de Transito'\n"
  		+ "04 'Instrutor de Transito'\n"
  		+ "05 'Instrutor de Transito Autonomo'\n"
  		+ "06 'Junta Medica'\n"
  		+ "07 'Junta Psicologica'\n"
  		+ "08 'Medico'\n"
  		+ "09 'Psicologo'\n"
  		+ "10 'Examinador de Transito de Entidades Especiais'\n"
  		+ "", example = "01")
**/
  private String tipoProfissional;
  private List<CredenciamentoProfissionalVinculos> registros;
  
  public CredenciamentoProfissionalResponse(ConsultarCredenciamentoProfissionalAuxiliar consultaAux, List<CredenciamentoProfissionalVinculos> registros) {
	  this.mensagemRetorno = consultaAux.getMensagemRetorno();
	  this.cpf = consultaAux.getCpf();
	  this.dataPesquisa = consultaAux.getDataPesquisa();
	  this.tipoProfissional = consultaAux.getTipoProfissional();
	  this.registros = registros;
  }

}