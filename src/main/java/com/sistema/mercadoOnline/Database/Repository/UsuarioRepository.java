package com.sistema.mercadoOnline.Database.Repository;

import com.sistema.mercadoOnline.Database.Model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    UserDetails findByLogin(String login);

    //CRIADO PARA TESTES
    @Query("SELECT u FROM UsuarioEntity u WHERE u.login = :login")
    Optional<UsuarioEntity> findByLoginUser(@Param("login") String login);

    Optional<UsuarioEntity> findById(Integer id);
}
