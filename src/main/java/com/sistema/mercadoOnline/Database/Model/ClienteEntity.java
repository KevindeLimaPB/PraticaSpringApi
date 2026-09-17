package com.sistema.mercadoOnline.Database.Model;

import com.sistema.mercadoOnline.Database.Model.Base.UserBase;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Builder
public class ClienteEntity extends UserBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//CREATE FOREIGN KEY TIPO_CLIENTE

    @ManyToOne
    @JoinColumn(name = "tipo_users_id")
    private TipoClienteEntity tipoCliente;

}
