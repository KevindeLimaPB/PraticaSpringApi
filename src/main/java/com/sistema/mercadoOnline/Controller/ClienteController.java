package com.sistema.mercadoOnline.Controller;

import com.sistema.mercadoOnline.Database.Model.ClienteEntity;
import com.sistema.mercadoOnline.Database.Model.ClienteVipEntity;
import com.sistema.mercadoOnline.Dto.ClienteDTO;
import com.sistema.mercadoOnline.Dto.ClienteVIPDTO;
import com.sistema.mercadoOnline.Service.ClienteService;
import com.sistema.mercadoOnline.Service.VIPService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteEntity> findAll(){
        return clienteService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteEntity save(@RequestBody @Valid ClienteDTO clienteDTO) throws Exception{
        return clienteService.save(clienteDTO);
    }
}
