package com.sistema.mercadoOnline.Dto;

import jakarta.validation.constraints.NotEmpty;
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
    private Integer id;

    @NotEmpty
    private BigDecimal saldo;
}

