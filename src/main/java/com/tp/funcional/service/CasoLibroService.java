package com.tp.funcional.service;

import com.tp.funcional.model.Libro;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CasoLibroService {

    // 1. Listar los títulos de los libros con más de 300 páginas, ordenados
    // alfabéticamente.
    public List<String> listarTitulosLibrosLargos(List<Libro> libros) {
        return libros.stream()
                .filter(l -> l.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .collect(Collectors.toList());
    }

    // 2. Calcular el promedio de páginas de todos los libros.
    public Double calcularPromedioPaginas(List<Libro> libros) {
        return libros.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0.0);
    }

    // 3. Agrupar los libros por autor y contar cuántos libros tiene cada uno.
    public Map<String, Long> contarLibrosPorAutor(List<Libro> libros) {
        return libros.stream()
                .collect(Collectors.groupingBy(
                        Libro::getAutor,
                        Collectors.counting()));
    }

    // 4. Obtener el libro más caro de la lista.
    public Optional<Libro> obtenerLibroMasCaro(List<Libro> libros) {
        return libros.stream()
                .max(Comparator.comparing(Libro::getPrecio));
    }
}
