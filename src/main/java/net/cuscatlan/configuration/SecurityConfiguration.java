package net.cuscatlan.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    SecurityAuthenticationProvider securityAuthenticationProvider;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(securityAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
         .authorizeRequests()
         .antMatchers("/resources/**")
         .permitAll()
         .anyRequest().authenticated()
         .and()
         .formLogin()
         .loginPage("/login/login")
         .defaultSuccessUrl("/login/index", true)
         .failureUrl("/login/login?error")
         .loginProcessingUrl("/j_spring_security_check")
         .usernameParameter("user").passwordParameter("pass")
         .and()
         .logout()
         .logoutSuccessUrl("/login/login")
         .logoutUrl("/j_spring_security_logout")
         .permitAll()
         .and().csrf().csrfTokenRepository(csrfTokenRepository());
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }
}

