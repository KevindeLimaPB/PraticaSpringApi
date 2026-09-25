package com.sistema.mercadoOnline.Dto;

import com.sistema.mercadoOnline.Database.Model.UsuarioEntity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Tipo_cliente_DTO {

    @NotNull
    private  String descricao;

    @NotNull
    private UsuarioEntity usuarioEntity;
}
