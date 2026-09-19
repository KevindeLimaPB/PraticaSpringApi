package com.sistema.mercadoOnline.Service;

import com.sistema.mercadoOnline.Database.Model.UsuarioEntity;
import com.sistema.mercadoOnline.Database.Repository.UsuarioRepository;
import com.sistema.mercadoOnline.Dto.UsuarioDto;
import com.sistema.mercadoOnline.Exception.LoginDuplicadoException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticationManager;

    //Lista todos os Usuarios
    public List<UsuarioEntity> findAll(){
        return usuarioRepository.findAll();
    }

    //adicionar um Usuario
    public UsuarioEntity save(UsuarioDto usuarioDto) throws LoginDuplicadoException{

        if (this.usuarioRepository.findByLogin(usuarioDto.getLogin()) != null){
            throw new LoginDuplicadoException("Esse login já Existe");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(usuarioDto.getSenha());

        UsuarioEntity user = UsuarioEntity.builder()
                .login(usuarioDto.getLogin())
                .senha(encryptedPassword)
                .role(usuarioDto.getRole())
                .build();
        return usuarioRepository.save(user);
    }
}
