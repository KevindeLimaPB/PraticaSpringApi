package com.sistema.mercadoOnline.Database.Model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Cliente_VIP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//SuperBuilder ele tem o Builder já conectado
public class ClienteVipEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String nome;

    @Column(nullable = true)
    private String telefone;

    @Column(nullable = true)
    private String endereco;


    @Column(nullable = true)
    private BigDecimal saldo = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "tipo_clienteVip_id")
    private TipoClienteEntity tipoCliente;

}
