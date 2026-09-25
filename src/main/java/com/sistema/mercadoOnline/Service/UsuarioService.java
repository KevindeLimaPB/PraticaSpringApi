package com.sistema.mercadoOnline.Service;

import com.sistema.mercadoOnline.Database.Model.UsuarioEntity;
import com.sistema.mercadoOnline.Database.Repository.UsuarioRepository;
import com.sistema.mercadoOnline.Dto.UsuarioDto;
import com.sistema.mercadoOnline.Exception.LoginDuplicadoException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder; // Injeta o bean do SecurityConfiguration

    //Lista todos os Usuarios
    public List<UsuarioEntity> findAll(){
        return usuarioRepository.findAll();
    }

    //adicionar um Usuario
    public UsuarioEntity save(UsuarioDto usuarioDto) throws LoginDuplicadoException{

        if (this.usuarioRepository.findByLogin(usuarioDto.getLogin()) != null){
            throw new LoginDuplicadoException("Esse login já Existe");
        }

        UsuarioEntity user = UsuarioEntity.builder()
                .login(usuarioDto.getLogin())
                .senha(passwordEncoder.encode(usuarioDto.getSenha()))
                .role(usuarioDto.getRole())
                .build();
        return usuarioRepository.save(user);
    }
}
