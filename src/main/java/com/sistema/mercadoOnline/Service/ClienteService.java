package com.sistema.mercadoOnline.Service;

import com.sistema.mercadoOnline.Database.Model.ClienteEntity;
import com.sistema.mercadoOnline.Database.Model.ClienteVipEntity;
import com.sistema.mercadoOnline.Database.Model.TipoClienteEntity;
import com.sistema.mercadoOnline.Database.Repository.ClienteNormalRepository;
import com.sistema.mercadoOnline.Database.Repository.TipoClienteRepository;
import com.sistema.mercadoOnline.Dto.ClienteDTO;
import com.sistema.mercadoOnline.Dto.ClienteVIPDTO;
import com.sistema.mercadoOnline.Exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteNormalRepository clienteRepository;
    private final TipoClienteRepository tipoClienteRepository;

    public List<ClienteEntity> findAll(){return clienteRepository.findAll();}

    public ClienteEntity save(ClienteDTO clienteDTO) throws Exception{
        TipoClienteEntity cliente = tipoClienteRepository
                .findById(clienteDTO.getTipoId())
                .orElseThrow(() -> new NotFoundException("Tipo não encontrado"));

        ClienteEntity clienteADD = ClienteEntity.builder()
                .nome(clienteDTO.getNome())
                .telefone(clienteDTO.getTelefone())
                .endereco(clienteDTO.getEndereco())
                .tipoCliente(cliente)
                .build();

        return clienteRepository.save(clienteADD);
    }
}
