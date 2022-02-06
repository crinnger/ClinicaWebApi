package br.com.crinnger.ClinicasWebApi.mapper;


import br.com.crinnger.ClinicasWebApi.model.security.User;
import br.com.crinnger.ClinicasWebApi.dto.security.LoginResponseDto;

public interface LoginMapper {
    public LoginResponseDto toLoginResponseDto(User user);
}
