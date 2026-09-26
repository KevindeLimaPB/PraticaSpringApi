package com.sistema.mercadoOnline.Database.Repository;

import com.sistema.mercadoOnline.Database.Model.TipoClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TipoClienteRepository extends JpaRepository<TipoClienteEntity, Integer> {

    @Query("SELECT COUNT(t) FROM TipoClienteEntity t")
    Integer total();

    Optional<TipoClienteEntity> findById(Integer id);
}
