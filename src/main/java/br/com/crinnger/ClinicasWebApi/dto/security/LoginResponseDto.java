package br.com.crinnger.ClinicasWebApi.dto.security;

import br.com.crinnger.ClinicasWebApi.model.security.Role;
import lombok.Data;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class LoginResponseDto {
    private String accessToken;
    private String refreshToken;
    private Map<String,List<AbstractMap.SimpleEntry<UUID,String>>> clinicaRoles;

}
