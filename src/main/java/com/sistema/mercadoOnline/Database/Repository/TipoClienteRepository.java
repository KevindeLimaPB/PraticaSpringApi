package com.sistema.mercadoOnline.Database.Repository;

import com.sistema.mercadoOnline.Database.Model.TipoClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoClienteRepository extends JpaRepository<TipoClienteEntity, Integer> {
}
