package com.sistema.mercadoOnline.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {

    @NotNull
    private String nome;

    @NotNull
    private String telefone;

    @NotNull
    private String endereco;

    @NotNull
    private Integer tipoId;
}
