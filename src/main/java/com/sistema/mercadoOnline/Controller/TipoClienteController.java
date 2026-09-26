package com.sistema.mercadoOnline.Controller;

import com.sistema.mercadoOnline.Database.Model.TipoClienteEntity;
import com.sistema.mercadoOnline.Dto.Tipo_cliente_DTO;
import com.sistema.mercadoOnline.Service.Tipo_clienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo")
@RequiredArgsConstructor
@Validated
public class TipoClienteController {

    private final Tipo_clienteService tipoClienteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Integer total(){
        return  tipoClienteService.totalTipo();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoClienteEntity save(@RequestBody @Valid Tipo_cliente_DTO tipoClienteDto) throws Exception{
        return tipoClienteService.save(tipoClienteDto);
    }
}
