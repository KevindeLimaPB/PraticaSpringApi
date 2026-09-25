package com.sistema.mercadoOnline.Service;

import com.sistema.mercadoOnline.Database.Model.ClienteVipEntity;
import com.sistema.mercadoOnline.Database.Repository.ClienteVipRepository;
import com.sistema.mercadoOnline.Dto.ClienteVIPDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VIPService {

    private final ClienteVipRepository vipRepository;


    public List<ClienteVipEntity> findAll(){
        return vipRepository.findAll();
    }

    public void save(ClienteVIPDTO clienteVIPDTO){

    }

}
