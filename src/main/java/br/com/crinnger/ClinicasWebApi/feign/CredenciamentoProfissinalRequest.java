package br.com.crinnger.ClinicasWebApi.feign;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CredenciamentoProfissinalRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
//  @ApiParam(name =  "cpf",
//		    type = "String",
//		    value = "CPF Válido com 11 digitos - 99999999999",
//		    example = "07847874415",
//		    required = true)
  private String cpf;

  @NotNull
//  @ApiParam(name = "dataPesquisa",
//  			type = "String",
 // 			value = "AAAAMMDD",
 // 			example = "20170101",
 // 			required = true)
  private String dataPesquisa;
  
  @NotNull
//  @ApiParam(type = "String [2]",
//  			value = "'00' PARA TODOS OS TIPOS;\r\n"
//		  		+ "01 'Diretor Geral';\r\n"
//		  		+ "02 'Diretor de Ensino';\r\n"
//		  		+ "03 'Examinador de Transito';\r\n"
//		  		+ "04 'Instrutor de Transito';\r\n"
//		  		+ "05 'Instrutor de Transito Autonomo';\r\n"
//		  		+ "06 'Junta Medica';\r\n"
//		  		+ "07 'Junta Psicologica';\r\n"
//		  		+ "08 'Medico';\r\n"
//		  		+ "09 'Psicologo';\r\n"
//		  		+ "10 'Examinador de Transito de Entidades Especiais';",
//		  	example = "00",
//		  	required = true)
  private String tipoProfissional;
  
}