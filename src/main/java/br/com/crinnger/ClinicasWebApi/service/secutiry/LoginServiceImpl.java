package br.com.crinnger.ClinicasWebApi.service.secutiry;

import br.com.crinnger.ClinicasWebApi.model.security.User;
import br.com.crinnger.ClinicasWebApi.dto.security.*;
import br.com.crinnger.ClinicasWebApi.mapper.LoginMapper;
import br.com.crinnger.ClinicasWebApi.model.security.UserClinicaRole;
import br.com.crinnger.ClinicasWebApi.repository.ClinicaRepository;
import br.com.crinnger.ClinicasWebApi.repository.UserClinicaRoleRepository;
import br.com.crinnger.ClinicasWebApi.repository.UserRepository;
import br.com.crinnger.ClinicasWebApi.security.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final UserRepository userRepository;
    private final UserClinicaRoleRepository userClinicaRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;
    private final LoginMapper loginMapper;


    @Override
    public LoginResponseDto login(LoginDto loginDto) {
        User user=userRepository.findByUsername(loginDto.getUsername()).orElseThrow(()-> new UsernameNotFoundException("Usuario/Senha invalido"));
        if(!passwordEncoder.matches(loginDto.getPassword(),user.getPassword())){
            throw  new UsernameNotFoundException("Usuario/Senha Invalido");
        }
        if(user.getUserClinicaRoles().size()==0){
            throw new BadCredentialsException("Usuario sem acesso ao sistema");
        }
        LoginResponseDto loginResponseDto= loginMapper.toLoginResponseDto(user);
        loginResponseDto.setAccessToken(jwtTokenService.generationToken(user));
        loginResponseDto.setRefreshToken(jwtTokenService.generationRefreshToken(user));
        return loginResponseDto;

    }

    @Override
    public LoginSelectRoleResponseDto selectRole(LoginSelectRoleDto selectRoleDto) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserClinicaRole userClinicaRole=userClinicaRoleRepository.findById(selectRoleDto.getUserClinicaRole())
                .orElseThrow(()-> new BadCredentialsException("Role nao existe"));

        if(!userClinicaRole.getUser().getId().equals(user.getId())){
            throw  new BadCredentialsException("Usuario nao tem acesso a Role");
        }
        user.setUserClinicaRoles(List.of(userClinicaRole));
        LoginSelectRoleResponseDto loginSelectRoleResponseDto=new LoginSelectRoleResponseDto();
        loginSelectRoleResponseDto.setRoleName(user.getUserClinicaRoles().get(0).getRole().getName());
        loginSelectRoleResponseDto.setClinica(user.getUserClinicaRoles().get(0).getClinica().getNomeFantasia());
        loginSelectRoleResponseDto.setAuthorities(user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        loginSelectRoleResponseDto.setAccessToken(jwtTokenService.generationToken(user));
        return loginSelectRoleResponseDto;
    }

    @Override
    public RefreshTokenResponseDto refreshToken(RefreshTokenDto refreshTokenDto) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userRefresh = (User) jwtTokenService.getUser(refreshTokenDto.getRefreshToken()).getPrincipal();
        if(!user.equals(userRefresh)){
            throw  new BadCredentialsException("Nao e possivel realizar o refresh");
        }
        RefreshTokenResponseDto refreshTokenResponseDto=new RefreshTokenResponseDto();
        refreshTokenResponseDto.setAccessToken(jwtTokenService.generationToken(user));
        refreshTokenResponseDto.setRefreshToken(jwtTokenService.generationRefreshToken(user));
        return refreshTokenResponseDto;
    }
}
