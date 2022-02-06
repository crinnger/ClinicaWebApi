package br.com.crinnger.ClinicasWebApi.security;

import br.com.crinnger.ClinicasWebApi.model.Clinica;
import br.com.crinnger.ClinicasWebApi.model.security.User;
import br.com.crinnger.ClinicasWebApi.model.security.UserClinicaRole;
import br.com.crinnger.ClinicasWebApi.repository.ClinicaRepository;
import br.com.crinnger.ClinicasWebApi.repository.UserClinicaRoleRepository;
import br.com.crinnger.ClinicasWebApi.repository.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
@RequiredArgsConstructor
public class JwtTokenServiceImpl implements JwtTokenService{
    @Value(("${secutiry.jwt.token.expiration}"))
    public String expirationToken;

    @Value(("${secutiry.jwt.refresh.token.expiration}"))
    public String expirationRefreshToken;

    @Value(("${secutiry.jwt.secret}"))
    private String secret;

    private final UserRepository userRepository;

    private final UserClinicaRoleRepository userClinicaRoleRepository;

    private final ClinicaRepository clinicaRepository;

    @Override
    public String generationToken(User user) {
        LocalDateTime expirationDate = LocalDateTime.now().plusMinutes(Long.valueOf(expirationToken));
        Date date = Date.from(expirationDate.atZone(ZoneId.systemDefault()).toInstant());

        // can put anything you want
        HashMap<String,String> claims = new HashMap<>();
        if(user.getUserClinicaRoles().size()==1) {
            claims.put("AUTHORITIES", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()).toString());
            claims.put("USERCLINICAROLE", user.getUserClinicaRoles().get(0).getId().toString());
            claims.put("CLINICA", user.getUserClinicaRoles().get(0).getClinica().getId().toString());
        }
        JWTCreator.Builder jwtBuilder = JWT.create().withSubject(user.getUsername());
        jwtBuilder.withExpiresAt(date);
        jwtBuilder.withNotBefore(new Date());
        claims.forEach(jwtBuilder::withClaim);
        return jwtBuilder.sign(getAlgotithm());
    }

    @Override
    public String generationRefreshToken(User user) {
        LocalDateTime expirationDate = LocalDateTime.now().plusMinutes(Long.valueOf(expirationRefreshToken));
        Date date = Date.from(expirationDate.atZone(ZoneId.systemDefault()).toInstant());

        JWTCreator.Builder jwtBuilder = JWT.create().withSubject(user.getUsername());
        jwtBuilder.withExpiresAt(date);
        jwtBuilder.withNotBefore(new Date());

        return jwtBuilder.sign(getAlgotithm());
    }

    @Override
    public UsernamePasswordAuthenticationToken getUser(String token){
        JWTVerifier verifier = JWT.require(getAlgotithm()).build();
        DecodedJWT decodedJWT = verifier.verify(token);

        String username = decodedJWT.getSubject();
        String jwtClinica = decodedJWT.getClaim("CLINICA").asString();
        String jwtUserClinicaRole = decodedJWT.getClaim("USERCLINICAROLE").asString();
        String[] jwtAuthorities = decodedJWT.getClaim("AUTHORITIES").asArray(String.class);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if(jwtAuthorities!=null) {
            stream(jwtAuthorities).forEach(auth -> {
                authorities.add(new SimpleGrantedAuthority(auth));
            });
        }
        User user;
        if(jwtUserClinicaRole!=null){
            Clinica clinica=clinicaRepository.findById(UUID.fromString(jwtClinica))
                    .orElseThrow(()-> new BadCredentialsException("Token invalido"));
          UserClinicaRole userClinicaRole = userClinicaRoleRepository
                  .findById(UUID.fromString(jwtUserClinicaRole))
                  .orElseThrow(()-> new BadCredentialsException("Token invalido"));
          if(!clinica.getId().equals(userClinicaRole.getClinica().getId())){
              throw new BadCredentialsException("Necessario revalidar Token");
          }
          user=userClinicaRole.getUser();
          if(!authorities.equals(user.getAuthorities())){
              throw new BadCredentialsException("Necessario revalidar Token");
          }
        } else {
          user = userRepository.findByUsername(username)
                    .orElseThrow(()-> new UsernameNotFoundException("Usuario nao encontrado"));
        }
        return  new UsernamePasswordAuthenticationToken(user, null, authorities);
    }

    private Algorithm getAlgotithm(){
        return Algorithm.HMAC512(secret);
    }
}
