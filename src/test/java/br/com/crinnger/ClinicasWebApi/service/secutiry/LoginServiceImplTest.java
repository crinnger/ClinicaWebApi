package br.com.crinnger.ClinicasWebApi.service.secutiry;

import br.com.crinnger.ClinicasWebApi.ClinicasWebApiApplication;
import br.com.crinnger.ClinicasWebApi.dto.security.*;
import br.com.crinnger.ClinicasWebApi.model.Clinica;
import br.com.crinnger.ClinicasWebApi.model.security.*;
import br.com.crinnger.ClinicasWebApi.repository.*;
import br.com.crinnger.ClinicasWebApi.security.JwtTokenService;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.actuate.metrics.AutoConfigureMetrics;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ClinicasWebApiApplication.class)
@ExtendWith(SpringExtension.class)
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LoginServiceImplTest {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserClinicaRoleRepository userClinicaRoleRepository;

    @Autowired
    private RoleAuthorityRepository roleAuthorityRepository;

    @Autowired
    private JwtTokenService jwtTokenService;

    public static List<UserClinicaRole> userClinicaRole=new ArrayList<>();

    public static User user;
    @BeforeAll
    void setUp() {
        Authority authority = authorityRepository.save(Authority.builder().permission("authority").build());
        Role role= roleRepository.save(Role.builder().name("role").build());
        Role role2= roleRepository.save(Role.builder().name("role2").build());
        RoleAuthority roleAuthority=roleAuthorityRepository.save(RoleAuthority.builder().authority(authority).role(role).build());
        RoleAuthority roleAuthority2=roleAuthorityRepository.save(RoleAuthority.builder().authority(authority).role(role2).build());
        Clinica clinica= clinicaRepository.save(Clinica.builder().CNPJ("00.000.000/0001-11").nomeFantasia("clinica").build());
        user = User.builder()
                .email("teste@teste")
                .name("teste")
                .password(passwordEncoder.encode("teste"))
                .username("000.000.000-00")
                .build();
        user=userRepository.save(user);

        userClinicaRole.add(userClinicaRoleRepository.save(UserClinicaRole.builder().clinica(clinica).role(role).user(user).build()));
        userClinicaRole.add(userClinicaRoleRepository.save(UserClinicaRole.builder().clinica(clinica).role(role2)
                .user(user)
                .build()));

        User user2 = User.builder()
                .email("teste1@teste")
                .name("teste1")
                .password(passwordEncoder.encode("teste"))
                .username("000.000.000-01")
                .build();
        userRepository.save(user2);

        User user3 = User.builder()
                .email("teste1@teste")
                .name("teste3")
                .password(passwordEncoder.encode("teste"))
                .username("000.000.000-02")
                .build();
        user3=userRepository.save(user3);
        userClinicaRole.add(userClinicaRoleRepository.save(UserClinicaRole.builder().clinica(clinica).role(role2).user(user3).build()));

        //Authentication authentication = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
        //SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void loginSucess() {
        LoginDto loginDto=LoginDto.builder().username("000.000.000-00").password("teste").build();
        LoginResponseDto loginResponseDto =loginService.login(loginDto);
        Assertions.assertNotNull(loginResponseDto.getAccessToken());
        Assertions.assertNotNull(loginResponseDto.getRefreshToken());
        Assertions.assertEquals(loginResponseDto.getClinicaRoles().size(),1);
        Assertions.assertEquals(loginResponseDto.getClinicaRoles().get("clinica").get(0).getValue(),"role");
    }

    @Test
    void loginWrongPassword() {
        LoginDto loginDto=LoginDto.builder().username("000.000.000-00").password("teste11").build();
        Assertions.assertThrows(UsernameNotFoundException.class,()->loginService.login(loginDto));
    }

    @Test
    void loginUserNotExist() {
        LoginDto loginDto=LoginDto.builder().username("000.000.000-04").password("teste").build();
        Assertions.assertThrows(UsernameNotFoundException.class,()->loginService.login(loginDto));
    }

    @Test
    void loginUserWithoutRole() {
        LoginDto loginDto=LoginDto.builder().username("000.000.000-01").password("teste").build();
        Assertions.assertThrows(BadCredentialsException.class,()->loginService.login(loginDto));
    }

    @Test
    @WithUserDetails("000.000.000-00")
    void selectRoleSucess() {
        LoginSelectRoleDto loginSelectRoleDto= new LoginSelectRoleDto(userClinicaRole.get(0).getId());
        LoginSelectRoleResponseDto loginSelectRoleResponseDto=loginService.selectRole(loginSelectRoleDto);
        Assertions.assertEquals(loginSelectRoleResponseDto.getClinica(),"clinica");
        Assertions.assertEquals(loginSelectRoleResponseDto.getRoleName(),"role");
        Assertions.assertEquals(loginSelectRoleResponseDto.getAuthorities().size(),1);
        Assertions.assertEquals(loginSelectRoleResponseDto.getAuthorities().get(0),"authority");
    }

    @Test
    @WithUserDetails("000.000.000-00")
    void selectRoleNotExistRole() {
        LoginSelectRoleDto loginSelectRoleDto = new LoginSelectRoleDto(UUID.randomUUID());
        Assertions.assertThrows(BadCredentialsException.class,()->loginService.selectRole(loginSelectRoleDto));
    }

    @Test
    @WithUserDetails("000.000.000-02")
    void selectRoleDiferentUser() {
        LoginSelectRoleDto loginSelectRoleDto = new LoginSelectRoleDto(userClinicaRole.get(0).getId());
        Assertions.assertThrows(BadCredentialsException.class,()->loginService.selectRole(loginSelectRoleDto));
    }

    @Test
    @WithUserDetails("000.000.000-00")
    void refreshTokenSucess() {
        String refreshtoken =jwtTokenService.generationRefreshToken(user);
        RefreshTokenResponseDto refreshTokenResponseDto= loginService.refreshToken(new RefreshTokenDto(refreshtoken));
        Assertions.assertNotNull(refreshTokenResponseDto.getRefreshToken());
        Assertions.assertNotNull(refreshTokenResponseDto.getAccessToken());
    }

    @Test
    @WithUserDetails("000.000.000-02")
    void refreshTokenDiferentUser() {
        String refreshtoken =jwtTokenService.generationRefreshToken(user);
        Assertions.assertThrows(BadCredentialsException.class,()->loginService.refreshToken(new RefreshTokenDto(refreshtoken)));
    }

}