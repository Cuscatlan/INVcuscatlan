package net.cuscatlan.configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class SecurityHelper {

    /**
    * Metodo para obtener la informacion de Seguridad de la aplicacion
    * @return SecurityUserDetails objeto con todos los campos de seguridad 
    * @author Generador-Safi
    * @version 1.0
    */
    public static final SecurityUserDetails getLoggedInUserDetails() {
         Authentication au = SecurityContextHolder.getContext().getAuthentication();
         if (au != null) {
             Object o = au.getPrincipal();
             if (o instanceof SecurityUserDetails) {
                 return ((SecurityUserDetails) o);
             } else if (au instanceof PreAuthenticatedAuthenticationToken) {
                 PreAuthenticatedAuthenticationToken ptoken = (PreAuthenticatedAuthenticationToken) au;
                 SecurityUserDetails gaudiUserDetails = (SecurityUserDetails) ptoken.getDetails();
                 return gaudiUserDetails;
             } else {
                 return null;
             }
         }
         return null;
    }
}

