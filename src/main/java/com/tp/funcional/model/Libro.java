package com.tp.funcional.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Libro {
    private String titulo;
    private String autor;
    private Integer paginas;
    private Double precio;
}
