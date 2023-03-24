package ksftaxispringback.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    //remplacer par filterchaine ?? à voir


    @Override @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CORS c'est la possibilité pour une appli d'etre appelé par une autre nom de domaine (ex: plusieurs ports par default)
        // and disable CSRF car pas possible d'avoir d'attaque csrf vu qu'on a un token qui fait le job
        http = http.cors().and().csrf().disable();

        // Set session management to stateless, interdiction de se souvenir du client
        http = http
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and();

        // Set unauthorized requests exception handler
        http = http
            .exceptionHandling()
            .authenticationEntryPoint(new SecurityEntryPoint())
            .and();

        // Set permissions on endpoints
        http
            .authorizeRequests()
                .antMatchers("/authorize").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/courses").permitAll()
                .antMatchers("/address").permitAll()
                .antMatchers("/message").permitAll()
                .antMatchers("/reservation").permitAll()
                .antMatchers("/persons/{username}").permitAll()
                .antMatchers("/messages").hasAnyAuthority("ADMIN")
            // Our private endpoints
            .anyRequest().authenticated();


        http
            .addFilterBefore(securityFilter(), UsernamePasswordAuthenticationFilter.class); //ajout d'un filtre avant chaque requete
    }

    @Bean
    public SecurityFilter securityFilter() {
        return new SecurityFilter();
    }


}