package com.sistema.mercadoOnline.Service;

import com.sistema.mercadoOnline.Database.Model.ClienteVipEntity;
import com.sistema.mercadoOnline.Database.Repository.ClienteVipRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class VIPServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClienteVipRepository clienteVipRepository;

    @Test
    @DisplayName("Retorne sucesso")
    @WithMockUser
    void deveDeletarClienteComSucesso() throws Exception{

        ClienteVipEntity vipEntity = new ClienteVipEntity();
        vipEntity.setNome("Kevin");
       ClienteVipEntity vip = clienteVipRepository.save(vipEntity);

        mockMvc.perform(delete("/vip/" + vip.getId()))
                .andExpect(
                        status().isNoContent()
                );
    }

    //put test
}