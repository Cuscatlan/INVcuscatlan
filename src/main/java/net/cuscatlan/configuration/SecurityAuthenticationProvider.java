package net.cuscatlan.configuration;
import java.util.Collection;
import net.cuscatlan.domain.Invusuario;
import net.cuscatlan.repository.InvusuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {

     @Autowired
    InvusuarioRepository nombreclaseRepository;

     public SecurityUserDetails dbAuthentication(String user, String password) throws BadCredentialsException {
         System.out.println("entre ala autenticaci�n");
         try {
            Invusuario userInfo = nombreclaseRepository.findBynombre(user.trim());

             //Object userInfo=null;
            //prueba
            if (userInfo.getClaveusuario().trim().compareTo(password.trim()) != 0) {
                throw new BadCredentialsException("Usuario o contrase�a invalido");
            }


             if (userInfo == null) {
                 throw new BadCredentialsException("Usuario o contrase�a invalido");
}

             SecurityUserDetails securityUser = new SecurityUserDetails();

             securityUser.setUsuario(userInfo.getCorreousuario());
             securityUser.setNombre(userInfo.getClaveusuario());
             return securityUser;
         } catch (Exception e) {
             e.printStackTrace();
             throw new BadCredentialsException("Error al obtener informaci�n del usuario " + e.getMessage());
         }
     }

    /**
    * Metodo de autenticacion y obtener roles con base de datos y LDAP
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
     public Authentication authenticate(Authentication authentication) throws AuthenticationException {
         String username = authentication.getName();
         String password = (String) authentication.getCredentials();
         SecurityUserDetails user = dbAuthentication(username, password);
         user.setAuthorities(user.getAuthorities());
         Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
         return new UsernamePasswordAuthenticationToken(user, password, authorities);
     }

     public boolean supports(Class<?> arg0) {
         return true;
     }
}

