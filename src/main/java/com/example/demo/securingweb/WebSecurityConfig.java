package com.example.demo.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
            .requestMatchers("/", "/home").permitAll()
            .anyRequest().authenticated()
            )
            .formLogin((form) -> form
            .loginPage("/login")
            .permitAll()
            )
            .logout(LogoutConfigurer::permitAll);

            return http.build();
    }

    // crea usuario de forma local para realizar las pruebas básicas
    /*@Bean
    public UserDetailsService userDetailsService() {
        var user = User.withUsername("usuario1")
                .password("123456")
                .roles("read")
                .build();

        return new InMemoryUserDetailsManager(user);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        //No apto para producción
        return NoOpPasswordEncoder.getInstance();
        //El encoder jode la contraseña
        //return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
    //Código propuesto por spring para primera version
    /*http
            .authorizeHttpRequests((requests) -> requests
            .requestMatchers("/", "/home").permitAll()
            .anyRequest().authenticated()
            )
            .formLogin((form) -> form
            .loginPage("/login")
            .permitAll()
            )
            .logout(LogoutConfigurer::permitAll);

            return http.build();*/
