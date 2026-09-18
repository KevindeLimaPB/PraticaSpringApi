package com.sistema.mercadoOnline.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration//redifinir a configuração padrão
@EnableWebSecurity//habilita minha própria configuração
public class SecurityConfiguration {


    //metodo de autorização
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sessions -> sessions.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/oi").hasRole("ADMIN")
                        .anyRequest().authenticated())
                //esses dois comandos faz que fora do /user
                //o usuario possa mexer em outras url's
                .build();
    }
}
