package br.com.crinnger.ClinicasWebApi.dto.security;

import lombok.Data;

import java.util.List;

@Data
public class LoginSelectRoleResponseDto {
        private String clinica;
        private String roleName;
        private String accessToken;
        private List<String> authorities;
}
