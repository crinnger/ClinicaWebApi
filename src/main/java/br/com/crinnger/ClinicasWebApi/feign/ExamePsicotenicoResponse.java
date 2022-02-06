package br.com.crinnger.ClinicasWebApi.feign;

import java.io.Serializable;
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
public class ExamePsicotenicoResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mensagemRetorno;
	
	//@ApiModelProperty(notes = "CPF Válido com 11 digitos", example = "99999999999")
	private String cpfA;
	
	//@ApiModelProperty(notes = "Formato ('AM' + 999999999)", example = "AM999999999")
	private String formRenachA;
	
	//@ApiModelProperty(notes = "DATA + NUM PROTOCOLO DO SERVICO DO CANDIDATO", example = "201903200282")
	private String dataNumProtA;
	
	//@ApiModelProperty(notes = "NUMERO(10) DO CERTIFICADO DE EXAME GERADO NA PRODAM", example = "9999999999")
	private String numCertificado;

}