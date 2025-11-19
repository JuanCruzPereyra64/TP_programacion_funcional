package com.tp.funcional.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
    private String nombre;
    private String categoria;
    private Double precio;
    private Integer stock;
}
