package br.com.crinnger.ClinicasWebApi.security;

import br.com.crinnger.ClinicasWebApi.model.security.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface JwtTokenService {

    public String generationToken(User user);
    public String generationRefreshToken(User user);
    public UsernamePasswordAuthenticationToken getUser(String token);
}
