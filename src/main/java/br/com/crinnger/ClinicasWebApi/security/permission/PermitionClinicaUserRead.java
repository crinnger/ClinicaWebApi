package br.com.crinnger.ClinicasWebApi.security.permission;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAuthority('clinica.user.read')")
public @interface PermitionClinicaUserRead {
}
