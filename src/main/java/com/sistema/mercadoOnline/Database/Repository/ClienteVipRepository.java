package com.sistema.mercadoOnline.Database.Repository;

import com.sistema.mercadoOnline.Database.Model.ClienteVipEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClienteVipRepository extends JpaRepository<ClienteVipEntity, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE ClienteVipEntity c SET c.telefone = :telefone WHERE c.id = :id")
    Integer updateTelefoneById(@Param("telefone") String telefone, @Param("id") Integer id);


    @Query("SELECT c FROM ClienteVipEntity c WHERE c.id = :id")
    Optional<ClienteVipEntity> findById(@Param("id") Integer id);
}
