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
public class DesistenciaExamePsicotenicoRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotNull
/*	@ApiParam(type = "String [11]",
		    value = "CPF Válido com 11 digitos, Exemplo: 99999999999",
		    example = "07847874415",
		    required = true)
*/
	private String cpf;

	@NotNull
/*	@ApiParam(type = "String [11]",
		    value = "Formato: AM + 999999999, Exemplo: AM029825083",
		    example = "AM029825083",
		    required = true)
*/
	private String formRenach;

	@NotNull
/*	@ApiParam(type = "String",
		    value = "Formato: AAAAMMDDNNNN, Exemplo: 201903200282, Descrição: DATA + NUM PROTOCOLO",
		    example = "201903200282",
		    required = true)
 */
	private String dataNumProtA;

	@NotNull
/*	@ApiParam(type = "String [14]",
		    value = "CNPJ Válido com 14 digitos, Exemplo: 99999999999999",
		    example = "",
		    required = true)
 */
	private String cnpjEntidadeA;

	@NotNull
/*	@ApiParam(type = "String [5]",
		    value = "Formato: 99999, Exemplo: 00255 (referente a Manaus), Observação: O código do município está disponível no retorno do serviço SCNHW057",
		    example = "00255",
		    required = true)
 */
	private String codMunicA;

	@NotNull
/*	@ApiParam(type = "String [3]",
		    value = "SIM",
		    example = "SIM",
		    required = true)
 */
	private String confirmacaoDesistencia;

	@NotNull
/*	@ApiParam(type = "String [8]",
		    value = "Formato: AAAAMMDD, Exemplo: 20190320",
		    example = "20190320",
		    required = true)
 */
	private String dataAtualizacao;

	@NotNull
/*	@ApiParam(type = "String [7]",
		    value = "Formato: HHMMSSM, Exemplo: 1210089",
		    example = "1210089",
		    required = true)*/
	private String horaAtualizacao;

	@NotNull
/*	@ApiParam(type = "String [11]",
		    value = "CPF Válido com 11 digitos, Exemplo: 99999999999",
		    example = "",
		    required = true)*/
	private String cpfFuncionario;

	@NotNull
/*	@ApiParam(type = "String [44]",
	    value = "Nome Completo Do Funcionário",
	    example = "",
	    required = true)*/
	private String nomeFuncionario;

}

