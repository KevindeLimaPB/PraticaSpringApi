package com.sistema.mercadoOnline.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UsuarioDto {

    @NotBlank
    private String login;

    @NotBlank
    private String senha;


}
