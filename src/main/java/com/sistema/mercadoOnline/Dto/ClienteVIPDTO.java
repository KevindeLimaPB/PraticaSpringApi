package com.sistema.mercadoOnline.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteVIPDTO {

    @NotNull
    private String nome;

    @NotNull
    private String telefone;

    @NotNull
    private String endereco;

    @NotNull
    private BigDecimal saldo;

    @NotNull
    private Integer tipoId;
}

