package com.tp.funcional.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empleado {
    private String nombre;
    private String departamento;
    private Double salario;
    private Integer edad;
}
