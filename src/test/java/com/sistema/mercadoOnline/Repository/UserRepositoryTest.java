package com.sistema.mercadoOnline.Repository;

import com.sistema.mercadoOnline.Database.Model.Enums.UserRole;
import com.sistema.mercadoOnline.Database.Model.UsuarioEntity;
import com.sistema.mercadoOnline.Database.Repository.UsuarioRepository;
import com.sistema.mercadoOnline.Dto.UsuarioDto;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.*;
import java.util.Optional;


@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Retorne com sucesso o User")
    void findByLoginSucess(){
        UsuarioDto user = new UsuarioDto("LC","1234", UserRole.VIP);
        this.createUser(user);

        Optional<UsuarioEntity> foundUser = this.usuarioRepository.findByLoginUser("LC");

        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getLogin()).isEqualTo("LC");
    }

    private UsuarioEntity createUser(UsuarioDto usuarioDto){
        UsuarioEntity user = new UsuarioEntity(usuarioDto);
        this.entityManager.persist(user);
        this.entityManager.flush();
        this.entityManager.clear();
        return user;
    }
}
