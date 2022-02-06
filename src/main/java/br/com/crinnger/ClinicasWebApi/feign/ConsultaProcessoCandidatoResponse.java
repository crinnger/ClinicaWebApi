package br.com.crinnger.ClinicasWebApi.feign;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CNPJ;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConsultaProcessoCandidatoResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private String mensagemRetorno;
  
  //@ApiModelProperty(notes = "AAAAMMDD", example = "19990210")
  private String dataOperacao;
  
  //@ApiModelProperty(notes = "HHMMSSM)", example = "1219311")
  private String horaOperacao;

  //@ApiModelProperty(notes = "CPF Válido com 11 digitos", example = "99999999999")
  private String cpf;

  //@ApiModelProperty(notes = "Formato ('AM' + 999999999)", example = "AM999999999")
  private String formRenach;
  
  //@ApiModelProperty(notes = "AAAAMMDDNNNN", example = "999988776666")
  private String protocolo;
  
  private String descricaoServico;
  
  //@ApiModelProperty(notes = "Formato: X, A, B, C, D, E, AB, AC, AD, AE, X, XB, XC, XD, XE Observação: 'X'" +
  //		  				"REFERE-SE À CATEGORIA ACC – AUTORIZACAO PARA CONDUZIR CICLOMOTOR (VEICULOS DE 2/3 RODAS ATÉ 59" +
  //		  				"CILINDRADAS)", example = "AB")
  private String catPretendida;
  
  //@ApiModelProperty(notes = "AAAAMMDD", example = "19990210")
  private String dataSolicitacao;
  
  //@ApiModelProperty(notes = "AAAAMMDD", example = "19990210")
  private String dataPagamento;
  
  //@ApiModelProperty(notes = "AAAAMMDD", example = "19990210")
  private String dataValidade;
  
  //@ApiModelProperty(notes = "AAAAMMDD", example = "19990210")
  private String dataColeta;
  
  //@ApiModelProperty(notes = "EAR=SIM OU EAR=NAO", example = "EAR=SIM")
  private String indicDeAtividadeRemunerada;
  
  //@ApiModelProperty(notes = "EAR=SIM OU EAR=NAO", example = "EAR=SIM")
  private String indicExigeClinMed;
  
  //@ApiModelProperty(notes = "CNPJ Válido com 14 digitos", example = "99999999999999")
  private String cnpjClinMed;
  
  //@ApiModelProperty(notes = "BLOQ=SIM OU BLOQ=NAO", example = "BLOQ=SIM")
  private String indicBloqClinMed;
  
  //@ApiModelProperty(notes = "AAAAMMDD", example = "19990210")
  private String dataIniCredClinMed;
  
  //@ApiModelProperty(notes = "AAAAMMDD", example = "19990210")
  private String dataFinCredClinMed;
  
  //@ApiModelProperty(notes = "PSI=SIM OU PSI=NAO", example = "PSI=SIM")
  private String indicExigeClinPsi;
  
  //@ApiModelProperty(notes = "CNPJ Válido com 14 digitos", example = "99999999999999")
  private String cnpjClinPsi;
  
  //@ApiModelProperty(notes = "BLOQ=SIM OU BLOQ=NAO", example = "BLOQ=SIM")
  private String indicBloqClinPsi;
  
  //@ApiModelProperty(notes = "AAAAMMDD", example = "19990210")
  private String dataIniCredClinPsi;
  
  //@ApiModelProperty(notes = "AAAAMMDD", example = "19990210")
  private String dataFinCredClinPsi;

}
