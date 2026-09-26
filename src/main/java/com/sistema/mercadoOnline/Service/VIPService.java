package com.sistema.mercadoOnline.Service;

import com.sistema.mercadoOnline.Database.Model.ClienteVipEntity;
import com.sistema.mercadoOnline.Database.Model.TipoClienteEntity;
import com.sistema.mercadoOnline.Database.Repository.ClienteVipRepository;
import com.sistema.mercadoOnline.Database.Repository.TipoClienteRepository;
import com.sistema.mercadoOnline.Dto.ClienteVIPDTO;
import com.sistema.mercadoOnline.Exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VIPService {

    private final ClienteVipRepository vipRepository;
    private  final TipoClienteRepository tipoClienteRepository;


    public List<ClienteVipEntity> findAll(){
        return vipRepository.findAll();
    }

    public ClienteVipEntity save(ClienteVIPDTO clienteVIPDTO) throws Exception{
        TipoClienteEntity clienteVIP = tipoClienteRepository
                .findById(clienteVIPDTO.getTipoId())
                .orElseThrow(() -> new NotFoundException("Tipo não encontrado"));

            ClienteVipEntity clienteVipADD = ClienteVipEntity.builder()
                    .saldo(clienteVIPDTO.getSaldo())
                    .tipoCliente(clienteVIP)
                    .build();

            return vipRepository.save(clienteVipADD);
    }

}
