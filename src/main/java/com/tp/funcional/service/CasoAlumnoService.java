package com.tp.funcional.service;

import com.tp.funcional.model.Alumno;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CasoAlumnoService {

    // 1. Obtener los nombres de los alumnos aprobados (nota >= 7) en mayúsculas y
    // ordenados.
    public List<String> obtenerNombresAprobados(List<Alumno> alumnos) {
        return alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
    }

    // 2. Calcular el promedio general de notas.
    public Double calcularPromedioGeneral(List<Alumno> alumnos) {
        return alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0.0);
    }

    // 3. Agrupar alumnos por curso usando Collectors.groupingBy().
    public Map<String, List<Alumno>> agruparPorCurso(List<Alumno> alumnos) {
        return alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));
    }

    // 4. Obtener los 3 mejores promedios.
    public List<Double> obtenerMejoresPromedios(List<Alumno> alumnos) {
        return alumnos.stream()
                .map(Alumno::getNota)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
    }
}
