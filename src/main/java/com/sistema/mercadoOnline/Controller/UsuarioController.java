package com.sistema.mercadoOnline.Controller;

import com.sistema.mercadoOnline.Database.Model.UsuarioEntity;
import com.sistema.mercadoOnline.Dto.UsuarioDto;
import com.sistema.mercadoOnline.Service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/oi")
    @ResponseStatus(HttpStatus.OK)
    public String mes(){
        return "ola";
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioEntity> findAll(){
        return usuarioService.findAll();
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioEntity save(@Valid @RequestBody UsuarioDto usuarioDto) throws Exception{


        return usuarioService.save(usuarioDto);
    }
}
