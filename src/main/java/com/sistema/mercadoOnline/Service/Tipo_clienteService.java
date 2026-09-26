package com.sistema.mercadoOnline.Service;

import com.sistema.mercadoOnline.Database.Model.TipoClienteEntity;
import com.sistema.mercadoOnline.Database.Model.UsuarioEntity;
import com.sistema.mercadoOnline.Database.Repository.TipoClienteRepository;
import com.sistema.mercadoOnline.Database.Repository.UsuarioRepository;
import com.sistema.mercadoOnline.Dto.Tipo_cliente_DTO;
import com.sistema.mercadoOnline.Exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Tipo_clienteService {

    private final TipoClienteRepository tipoClienteRepository;
    private final UsuarioRepository usuarioRepository;

    public Integer totalTipo(){
        return tipoClienteRepository.total();
    }

    public TipoClienteEntity save(Tipo_cliente_DTO tipoClienteDto) throws Exception{
        UsuarioEntity usuario = usuarioRepository
                .findById(tipoClienteDto.getUsuarioId())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        TipoClienteEntity tipoCliente = TipoClienteEntity.builder()
                .descricao(tipoClienteDto.getDescricao())
                .usuarioEntity(usuario)
                .build();

        return tipoClienteRepository.save(tipoCliente);
    }

}
