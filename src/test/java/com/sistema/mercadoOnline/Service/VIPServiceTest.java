package com.sistema.mercadoOnline.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.mercadoOnline.Database.Model.ClienteVipEntity;
import com.sistema.mercadoOnline.Database.Repository.ClienteVipRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
@RequiredArgsConstructor
class VIPServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClienteVipRepository clienteVipRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

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
    @Test
    @DisplayName("Retorno de sucesso no update")
    @WithMockUser
    void updateTest() throws  Exception {

        ClienteVipEntity vipEntity = new ClienteVipEntity();

        vipEntity.setTelefone("1111000077");

        vipEntity = clienteVipRepository.save(vipEntity);
        String phone = "111111111";

        String jsonResponse = objectMapper.writeValueAsString(phone);


       MvcResult mvcResult= mockMvc.perform(put("/vip/" + vipEntity.getId())
                        .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonResponse))
                .andExpect(status().isNoContent()).andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        System.out.println("Corpo retornado pela API: " + responseBody);

        //verifica se mudou com sucesso no banco de dados
        ClienteVipEntity atualizadoNoBanco = clienteVipRepository.findById(vipEntity.getId())
                .orElseThrow();
        assertEquals(phone, atualizadoNoBanco.getTelefone());
    }
}