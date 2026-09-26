package com.sistema.mercadoOnline.Dto;

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
    private Integer usuarioId;

    /*
    * Não Use NotEmpty
    * Não Use NotBlank
    * Em um Int ou Integer
    * */
}
