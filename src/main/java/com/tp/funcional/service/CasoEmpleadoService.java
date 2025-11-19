package com.tp.funcional.service;

import com.tp.funcional.model.Empleado;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CasoEmpleadoService {

    // 1. Obtener la lista de empleados cuyo salario sea mayor a 2000, ordenados por
    // salario descendente.
    public List<Empleado> listarEmpleadosSalarioAlto(List<Empleado> empleados) {
        return empleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted(Comparator.comparing(Empleado::getSalario).reversed())
                .collect(Collectors.toList());
    }

    // 2. Calcular el salario promedio general.
    public Double calcularSalarioPromedio(List<Empleado> empleados) {
        return empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0.0);
    }

    // 3. Agrupar los empleados por departamento y calcular la suma de salarios de
    // cada uno.
    public Map<String, Double> sumarSalariosPorDepartamento(List<Empleado> empleados) {
        return empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)));
    }

    // 4. Obtener los nombres de los 2 empleados más jóvenes.
    public List<String> obtenerEmpleadosMasJovenes(List<Empleado> empleados) {
        return empleados.stream()
                .sorted(Comparator.comparing(Empleado::getEdad))
                .limit(2)
                .map(Empleado::getNombre)
                .collect(Collectors.toList());
    }
}
