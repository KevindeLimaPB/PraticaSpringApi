package com.sistema.mercadoOnline.Exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {

    private String response;

    private Integer status;
}
