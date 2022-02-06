package br.com.crinnger.ClinicasWebApi.controller;

import br.com.crinnger.ClinicasWebApi.dto.security.*;
import br.com.crinnger.ClinicasWebApi.service.secutiry.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponseDto> login(LoginDto loginDto){
        return ResponseEntity.ok(loginService.login(loginDto));
    }

    @PostMapping("/refresh")
    public ResponseEntity<RefreshTokenResponseDto> refreshToken(RefreshTokenDto refreshTokenDto){
        return ResponseEntity.ok(loginService.refreshToken(refreshTokenDto));
    }

    @PostMapping("/role")
    public ResponseEntity<LoginSelectRoleResponseDto> selectRole(LoginSelectRoleDto loginSelectRoleDto){
        return ResponseEntity.ok(loginService.selectRole(loginSelectRoleDto));
    }

}
