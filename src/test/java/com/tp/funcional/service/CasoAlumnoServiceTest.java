package com.tp.funcional.service;

import com.tp.funcional.model.Alumno;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class CasoAlumnoServiceTest {

    @InjectMocks
    private CasoAlumnoService alumnoService;

    @Test
    void obtenerNombresAprobados_ShouldReturnUppercaseNames_WhenGradeIsGreaterOrEqualSeven() {
        List<Alumno> alumnos = List.of(
                new Alumno("Juan", 8.0, "A"),
                new Alumno("Pedro", 4.0, "B"),
                new Alumno("ana", 7.0, "A"));

        List<String> result = alumnoService.obtenerNombresAprobados(alumnos);

        assertEquals(2, result.size());
        assertEquals("ANA", result.get(0)); // Sorted alphabetically
        assertEquals("JUAN", result.get(1));
    }

    @Test
    void calcularPromedioGeneral_ShouldReturnCorrectAverage() {
        List<Alumno> alumnos = List.of(
                new Alumno("Juan", 10.0, "A"),
                new Alumno("Pedro", 5.0, "B"));

        Double promedio = alumnoService.calcularPromedioGeneral(alumnos);

        assertEquals(7.5, promedio);
    }

    @Test
    void agruparPorCurso_ShouldGroupCorrectly() {
        List<Alumno> alumnos = List.of(
                new Alumno("Juan", 8.0, "Matemáticas"),
                new Alumno("Pedro", 4.0, "Historia"),
                new Alumno("Ana", 7.0, "Matemáticas"));

        Map<String, List<Alumno>> result = alumnoService.agruparPorCurso(alumnos);

        assertEquals(2, result.get("Matemáticas").size());
        assertEquals(1, result.get("Historia").size());
    }

    @Test
    void obtenerMejoresPromedios_ShouldReturnTop3() {
        List<Alumno> alumnos = List.of(
                new Alumno("A", 10.0, "C"),
                new Alumno("B", 9.0, "C"),
                new Alumno("C", 8.0, "C"),
                new Alumno("D", 7.0, "C"));

        List<Double> result = alumnoService.obtenerMejoresPromedios(alumnos);

        assertEquals(3, result.size());
        assertEquals(10.0, result.get(0));
        assertEquals(9.0, result.get(1));
        assertEquals(8.0, result.get(2));
    }
}
