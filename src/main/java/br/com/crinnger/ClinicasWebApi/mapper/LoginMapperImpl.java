package br.com.crinnger.ClinicasWebApi.mapper;

import br.com.crinnger.ClinicasWebApi.model.security.User;
import br.com.crinnger.ClinicasWebApi.dto.security.LoginResponseDto;
import br.com.crinnger.ClinicasWebApi.model.security.UserClinicaRole;
import org.springframework.stereotype.Component;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
public class LoginMapperImpl implements LoginMapper{

    @Override
    public LoginResponseDto toLoginResponseDto(User user) {
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        Map<String,List<AbstractMap.SimpleEntry<Long,String>>> userClinicaRoles=
        user.getUserClinicaRoles().stream().collect(
                Collectors.groupingBy(
                        c->c.getClinica().getNomeFantasia(),
                        Collectors.mapping(r->new AbstractMap.SimpleEntry<Long,String>(r.getId(),r.getRole().getName()),Collectors.toList())
                        ));
        loginResponseDto.setClinicaRoles(userClinicaRoles);
        return loginResponseDto;
    }
}
