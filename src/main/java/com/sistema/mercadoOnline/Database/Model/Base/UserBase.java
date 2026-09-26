package com.sistema.mercadoOnline.Database.Model.Base;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class UserBase {

    private String nome;

    private String telefone;

    private String endereco;
}
