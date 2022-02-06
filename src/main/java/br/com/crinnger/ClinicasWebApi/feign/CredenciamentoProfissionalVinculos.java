package br.com.crinnger.ClinicasWebApi.feign;

import java.io.Serializable;

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
public class CredenciamentoProfissionalVinculos implements Serializable {

  private static final long serialVersionUID = 1L;

//  @ApiModelProperty(notes = "CNPJ Válido com 14 digitos", example = "99999999999999")
  private String cnpj;
  
//  @ApiModelProperty(notes = "Descrição")
  private String tipoEntidade;
  
 // @ApiModelProperty(notes = "BLOQ=SIM OU BLOQ=NAO", example = "BLOQ=NAO")
  private String entidadeBloqueada;
  
 // @ApiModelProperty(notes = "Descrição")
  private String tipoProfissional;
  
 // @ApiModelProperty(notes = "BLOQ=SIM OU BLOQ=NAO", example = "BLOQ=NAO")
  private String profissionalBloqueado;
  
 // @ApiModelProperty(notes = "AAAAMMDD", example = "19990210")
  private String dataInicioVigencia;
  
 // @ApiModelProperty(notes = "AAAAMMDD", example = "19990210")
  private String dataTerminoVigencia;
  
}