package com.sistema.mercadoOnline.Service;

import com.sistema.mercadoOnline.Database.Model.UsuarioEntity;
import com.sistema.mercadoOnline.Database.Repository.UsuarioRepository;
import com.sistema.mercadoOnline.Dto.UsuarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    //Lista todos os Usuarios
    public List<UsuarioEntity> findAll(){
        return usuarioRepository.findAll();
    }

    //adicionar um Usuario
    public UsuarioEntity save(UsuarioDto usuarioDto){
        UsuarioEntity user = UsuarioEntity.builder()
                .login(usuarioDto.getLogin())
                .senha(usuarioDto.getSenha())
                .build();
        return usuarioRepository.save(user);
    }
}
