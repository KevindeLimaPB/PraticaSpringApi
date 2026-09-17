package com.sistema.mercadoOnline.Database.Repository;

import com.sistema.mercadoOnline.Database.Model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    UserDetails findByLogin(String login);
}
