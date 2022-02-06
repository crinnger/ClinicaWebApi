package br.com.crinnger.ClinicasWebApi.feign;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
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
public class ExamePsicotenicoRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	// // // @ApiParam(type = "String [11]", value = "CPF Válido com 11 digitos, Exemplo: 99999999999", example = "07847874415", required = true)
	private String cpf;

	@NotNull
	// // // @ApiParam(type = "String [11]", value = "Formato: AM + 999999999, Exemplo: AM029825083", example = "AM029825083", required = true)
	private String formRenach;

	@NotNull
	// // // @ApiParam(type = "String", value = "Formato: AAAAMMDDNNNN, Exemplo: 201903200282, Descrição: DATA + NUM PROTOCOLO", example = "201903200282", required = true)
	private String dataNumProtA;

	@NotNull
	// // // @ApiParam(type = "String [8]", value = "Formato: AAAAMMDD, Exemplo: 20190320", example = "20190320", required = true)
	private String dataExameA;

	@NotNull
	// // // @ApiParam(type = "String [14]", value = "CNPJ Válido com 14 digitos, Exemplo: 99999999999999", example = "", required = true)
	private String cnpjEntidadeA;

	@NotNull
	// // // @ApiParam(type = "String [5]", value = "Formato: 99999, Exemplo: 00255 (referente a Manaus), Observação: O código do município está disponível no retorno do serviço SCNHW057", example = "00255", required = true)
	private String codMunicA;

	@NotNull
	// // // @ApiParam(type = "String [11]", value = "CPF Válido com 11 digitos, Exemplo: 99999999999", example = "", required = true)
	private String cpfExamin1A;

	@NotNull
	// // // @ApiParam(type = "char", value = "Exemplos: '1' 'APTO'\r\n" + "'2' 'INAPTO TEMPORARIO'\r\n"
//			+ "'3' 'INAPTO'\r\n" + "'5' 'INAPTO'\r\n"
//			+ "'7' 'ENCAMINHAR JUNTA PSICOLOGICA'", example = "1", required = true)
	private char resultadoEpA;

	@NotNull
	// // // @ApiParam(type = "String [2]", value = "X, A, AB, AC, AD, AE, B, C, D, E, XB, XC, XD, XE\r\n"
//			+ "Observação: 'X' REFERE-SE À CATEGORIA ACC – AUTORIZACAO PARA CONDUZIR CICLOMOTOR (VEICULOS DE 2/3 RODAS ATÉ 59 CILINDRADAS)", example = "S", required = true)
	private String categoriaPermitida;

	@NotNull
	// // // @ApiParam(type = "String [2]", value = "Formato: de A até Z e 99 para sem observações, Obs.: Consultar tabela de restrições médicas", example = "99", required = true)
	private char quadroObs1;

	@NotNull
	// // // @ApiParam(type = "String [2]", value = "Formato: de A até Z e 99 para sem observações, Obs.: Consultar tabela de restrições médicas", example = "99", required = true)
	private char quadroObs2;

	@NotNull
	// // // @ApiParam(type = "String [2]", value = "Formato: de A até Z e 99 para sem observações, Obs.: Consultar tabela de restrições médicas", example = "99", required = true)
	private char quadroObs3;

	@NotNull
	// // // @ApiParam(type = "String [2]", value = "Formato: de A até Z e 99 para sem observações, Obs.: Consultar tabela de restrições médicas", example = "99", required = true)
	private char quadroObs4;

	@NotNull
	// // // @ApiParam(type = "String [2]", value = "Formato: de A até Z e 99 para sem observações, Obs.: Consultar tabela de restrições médicas", example = "99", required = true)
	private char quadroObs5;

	@NotNull
	// // // @ApiParam(type = "String [2]", value = "Formato: de A até Z e 99 para sem observações, Obs.: Consultar tabela de restrições médicas", example = "99", required = true)
	private char quadroObs6;

	@NotNull
	// // // @ApiParam(type = "String [2]", value = "Formato: de A até Z e 99 para sem observações, Obs.: Consultar tabela de restrições médicas", example = "99", required = true)
	private char quadroObs7;

	@NotNull
	// // // @ApiParam(type = "String [2]", value = "Formato: de A até Z e 99 para sem observações, Obs.: Consultar tabela de restrições médicas", example = "99", required = true)
	private char quadroObs8;

	@NotNull
	// // // @ApiParam(type = "String [2]", value = "Formato: de A até Z e 99 para sem observações, Obs.: Consultar tabela de restrições médicas", example = "99", required = true)
	private char quadroObs9;

	@NotNull
	// // // @ApiParam(type = "String [2]", value = "Formato: de A até Z e 99 para sem observações, Obs.: Consultar tabela de restrições médicas", example = "99", required = true)
	private char quadroObs10;

	@NotNull
	// // // @ApiParam(type = "char", value = "Descrição: VALOR EM ANOS (1,2 OU 3)", example = "1", required = true)
	private String revisaoPsicologica;

	@NotNull
	// // // @ApiParam(type = "Int [3]", value = "Descrição: VALOR EM DIAS (1 A 365)", example = "365", required = true)
	private Integer periodoInaptidaoA;

	@NotNull
	// // // @ApiParam(type = "String [8]", value = "Formato: AAAAMMDD, Exemplo: 20190320", example = "20190320", required = true)
	private String dataAtualizacao;

	@NotNull
	// // // @ApiParam(type = "String [7]", value = "Formato: HHMMSSM, Exemplo: 1210089", example = "1210089", required = true)
	private String horaAtualizacao;

	@NotNull
	// // // @ApiParam(type = "String [11]", value = "CPF Válido com 11 digitos, Exemplo: 99999999999", example = "", required = true)
	private String cpfFuncionario;

	@NotNull
	// // // @ApiParam(type = "String [44]", value = "Nome Completo Do Funcionário", example = "", required = true)
	private String nomeFuncionario;

}