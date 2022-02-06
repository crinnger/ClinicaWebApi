package br.com.crinnger.ClinicasWebApi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtTokenService jwtService;

    private final UserDetailsService userService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        String auth= request.getHeader("Authorization");
        if(auth!=null && auth.startsWith("Bearer")){
            try{
                String token = auth.split(" ")[1];
                UsernamePasswordAuthenticationToken user=jwtService.getUser(token);
                user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(user);
            } catch (Exception e){
                response.setHeader("error",e.getMessage());
                response.sendError(HttpStatus.FORBIDDEN.value());
            }
        }
        filterChain.doFilter(request,response);
    }
}
