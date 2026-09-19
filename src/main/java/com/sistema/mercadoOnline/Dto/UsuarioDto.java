package com.sistema.mercadoOnline.Dto;

import com.sistema.mercadoOnline.Database.Model.Enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private UserRole role;


}
