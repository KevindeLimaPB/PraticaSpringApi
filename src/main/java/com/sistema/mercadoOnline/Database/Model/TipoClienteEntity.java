package com.sistema.mercadoOnline.Database.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Tipo_CLiente")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descricao;


    //FOREIGN KEY DE USERS
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuarioEntity;

}
