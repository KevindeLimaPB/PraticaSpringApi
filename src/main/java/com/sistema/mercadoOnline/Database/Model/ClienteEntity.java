package com.sistema.mercadoOnline.Database.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String nome;

    @Column(nullable = true)
    private String telefone;

    @Column(nullable = true)
    private String endereco;

//CREATE FOREIGN KEY TIPO_CLIENTE

    @ManyToOne
    @JoinColumn(name = "tipo_users_id")
    private TipoClienteEntity tipoCliente;

}
