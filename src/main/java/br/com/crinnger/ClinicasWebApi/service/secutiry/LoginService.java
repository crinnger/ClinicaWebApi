package br.com.crinnger.ClinicasWebApi.service.secutiry;

import br.com.crinnger.ClinicasWebApi.dto.security.*;

public interface LoginService {
    public LoginResponseDto login(LoginDto loginDto);
    public LoginSelectRoleResponseDto selectRole(LoginSelectRoleDto selectRoleDto);
    public RefreshTokenResponseDto refreshToken(RefreshTokenDto refreshTokenDto);
}
