package br.edu.utfpr.pb.pw25s.aula4.config;

import br.edu.utfpr.pb.pw25s.aula4.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    @Qualifier("usuarioServiceImpl")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()) //qual é o userDetailService que o Spring vai utilizar para autenticação
            .passwordEncoder(passwordEncoder()); // informa o encoder utilizado para criptografar a senha do usuário
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .formLogin().loginPage("/login")
                    .defaultSuccessUrl("/")
                    .failureUrl("/login?error=bad_credentials").permitAll()
                .and()
                .logout()
                    .logoutSuccessUrl("/login")
                .and()
                    .authorizeRequests()
                        .antMatchers("/autor/**").hasAnyRole("USER", "ADMIN")
                        .antMatchers(HttpMethod.GET, "/livro/**").hasAnyRole("USER", "ADMIN")
                        .antMatchers(HttpMethod.POST, "/livro/**").hasAnyRole("ADMIN")
                        .antMatchers("/**").authenticated();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/images/**")
                .antMatchers("/webjars/**")
                .antMatchers("/vendors/**");
    }
}

