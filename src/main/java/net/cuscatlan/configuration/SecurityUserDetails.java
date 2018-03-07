package net.cuscatlan.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUserDetails implements UserDetails{

private List<Rol> authorities;
private String usuario;
private String nombre;

public String getNombre() {
		return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public SecurityUserDetails() {
        this.authorities = new ArrayList<Rol>();
    }

    public List<Rol> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Rol> authorities) {
        this.authorities = authorities;
    }

    public void addGrantedAuthority(String name) {
        Rol rol = new Rol();
        rol.setName(name);
        this.authorities.add(rol);
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getUsername() {
        return getUsuario();
    }

    public class Rol implements GrantedAuthority,Serializable {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthority() {
            return this.name;
        }

    }

}

