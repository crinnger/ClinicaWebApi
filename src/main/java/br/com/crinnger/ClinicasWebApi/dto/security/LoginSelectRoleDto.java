package br.com.crinnger.ClinicasWebApi.dto.security;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class LoginSelectRoleDto {
    private UUID userClinicaRole;
}
