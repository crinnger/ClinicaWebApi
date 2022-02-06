package br.com.crinnger.ClinicasWebApi.feign;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.ApiParam;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaProcessoCandidatoRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@CPF
	//@ApiParam(type = "String [11]", value = "CPF Válido com 11 digitos, Exemplo: 99999999999", example = "07847874415", required = true)
	private String cpf;

	@NotNull
	//@ApiParam(type = "String [11]", value = "Formato: AM + 999999999, Exemplo: AM029825083", example = "AM029825083", required = true)
	private String formRenach;

}