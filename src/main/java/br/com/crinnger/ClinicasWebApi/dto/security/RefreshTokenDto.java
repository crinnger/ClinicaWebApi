package br.com.crinnger.ClinicasWebApi.dto.security;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RefreshTokenDto {
    private String refreshToken;
}
