package com.sistema.mercadoOnline.Controller;

import com.sistema.mercadoOnline.Database.Model.UsuarioEntity;
import com.sistema.mercadoOnline.Dto.AuthenticationDTO;
import com.sistema.mercadoOnline.Dto.LoginResponseDTO;
import com.sistema.mercadoOnline.infra.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(
                authenticationDTO.login(),
                authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UsuarioEntity) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
