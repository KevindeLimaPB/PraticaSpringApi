package com.sistema.mercadoOnline.Database.Model;

import com.sistema.mercadoOnline.Database.Model.Base.UserBase;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;


@Entity
@Table(name = "Cliente_VIP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
//SuperBuilder ele tem o Builder já conectado
public class ClienteVipEntity  extends UserBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private BigDecimal saldo = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "tipo_clienteVip_id")
    private TipoClienteEntity tipoCliente;

}
