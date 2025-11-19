package com.tp.funcional.service;

import com.tp.funcional.model.Empleado;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CasoEmpleadoServiceTest {

    @InjectMocks
    private CasoEmpleadoService empleadoService;

    @Test
    void listarEmpleadosSalarioAlto_ShouldReturnOver2000_SortedDesc() {
        List<Empleado> empleados = List.of(
                new Empleado("A", "D", 1000.0, 20),
                new Empleado("B", "D", 3000.0, 20),
                new Empleado("C", "D", 4000.0, 20));

        List<Empleado> result = empleadoService.listarEmpleadosSalarioAlto(empleados);

        assertEquals(2, result.size());
        assertEquals(4000.0, result.get(0).getSalario());
        assertEquals(3000.0, result.get(1).getSalario());
    }

    @Test
    void calcularSalarioPromedio_ShouldReturnAverage() {
        List<Empleado> empleados = List.of(
                new Empleado("A", "D", 1000.0, 20),
                new Empleado("B", "D", 2000.0, 20));

        Double result = empleadoService.calcularSalarioPromedio(empleados);

        assertEquals(1500.0, result);
    }

    @Test
    void sumarSalariosPorDepartamento_ShouldSumCorrectly() {
        List<Empleado> empleados = List.of(
                new Empleado("A", "IT", 1000.0, 20),
                new Empleado("B", "IT", 2000.0, 20),
                new Empleado("C", "HR", 1500.0, 20));

        Map<String, Double> result = empleadoService.sumarSalariosPorDepartamento(empleados);

        assertEquals(3000.0, result.get("IT"));
        assertEquals(1500.0, result.get("HR"));
    }

    @Test
    void obtenerEmpleadosMasJovenes_ShouldReturnTop2Youngest() {
        List<Empleado> empleados = List.of(
                new Empleado("Old", "D", 1000.0, 50),
                new Empleado("Young1", "D", 1000.0, 20),
                new Empleado("Young2", "D", 1000.0, 22),
                new Empleado("Mid", "D", 1000.0, 30));

        List<String> result = empleadoService.obtenerEmpleadosMasJovenes(empleados);

        assertEquals(2, result.size());
        assertEquals("Young1", result.get(0));
        assertEquals("Young2", result.get(1));
    }
}
