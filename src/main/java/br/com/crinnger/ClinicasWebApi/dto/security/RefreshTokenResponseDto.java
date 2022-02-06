package br.com.crinnger.ClinicasWebApi.dto.security;

import lombok.Data;

@Data
public class RefreshTokenResponseDto {
    private String accessToken;
    private String refreshToken;
}
