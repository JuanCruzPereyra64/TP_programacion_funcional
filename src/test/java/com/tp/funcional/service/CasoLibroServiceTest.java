package com.tp.funcional.service;

import com.tp.funcional.model.Libro;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class CasoLibroServiceTest {

    @InjectMocks
    private CasoLibroService libroService;

    @Test
    void listarTitulosLibrosLargos_ShouldReturnTitlesOver300Pages_Sorted() {
        List<Libro> libros = List.of(
                new Libro("B", "A", 400, 10.0),
                new Libro("A", "A", 500, 10.0),
                new Libro("C", "A", 100, 10.0));

        List<String> result = libroService.listarTitulosLibrosLargos(libros);

        assertEquals(2, result.size());
        assertEquals("A", result.get(0));
        assertEquals("B", result.get(1));
    }

    @Test
    void calcularPromedioPaginas_ShouldReturnAverage() {
        List<Libro> libros = List.of(
                new Libro("A", "A", 100, 10.0),
                new Libro("B", "A", 200, 10.0));

        Double result = libroService.calcularPromedioPaginas(libros);

        assertEquals(150.0, result);
    }

    @Test
    void contarLibrosPorAutor_ShouldCountCorrectly() {
        List<Libro> libros = List.of(
                new Libro("A", "Author1", 100, 10.0),
                new Libro("B", "Author1", 100, 10.0),
                new Libro("C", "Author2", 100, 10.0));

        Map<String, Long> result = libroService.contarLibrosPorAutor(libros);

        assertEquals(2L, result.get("Author1"));
        assertEquals(1L, result.get("Author2"));
    }

    @Test
    void obtenerLibroMasCaro_ShouldReturnMostExpensive() {
        List<Libro> libros = List.of(
                new Libro("A", "A", 100, 10.0),
                new Libro("B", "A", 100, 50.0),
                new Libro("C", "A", 100, 20.0));

        Optional<Libro> result = libroService.obtenerLibroMasCaro(libros);

        assertTrue(result.isPresent());
        assertEquals(50.0, result.get().getPrecio());
    }
}
