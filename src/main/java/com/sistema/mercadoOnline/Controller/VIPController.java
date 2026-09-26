package com.sistema.mercadoOnline.Controller;

import com.sistema.mercadoOnline.Database.Model.ClienteVipEntity;
import com.sistema.mercadoOnline.Dto.ClienteVIPDTO;
import com.sistema.mercadoOnline.Service.VIPService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vip")
@RequiredArgsConstructor
@Validated
public class VIPController {

    private final VIPService vipService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteVipEntity> findAll(){
        return vipService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteVipEntity save(@RequestBody @Valid ClienteVIPDTO clienteVIPDTO) throws Exception{
        return vipService.save(clienteVIPDTO);
    }
}
