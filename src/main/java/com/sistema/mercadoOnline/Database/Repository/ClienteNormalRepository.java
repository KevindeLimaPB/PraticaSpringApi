package com.sistema.mercadoOnline.Database.Repository;

import com.sistema.mercadoOnline.Database.Model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteNormalRepository extends JpaRepository<UsuarioEntity, Integer> {
}
