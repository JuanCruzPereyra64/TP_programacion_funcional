package com.tp.funcional.service;

import com.tp.funcional.model.Producto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class CasoProductoServiceTest {

    @InjectMocks
    private CasoProductoService productoService;

    @Test
    void listarProductosCaros_ShouldReturnProductsOver100_SortedDesc() {
        List<Producto> productos = List.of(
                new Producto("A", "C", 50.0, 1),
                new Producto("B", "C", 150.0, 1),
                new Producto("C", "C", 200.0, 1));

        List<Producto> result = productoService.listarProductosCaros(productos);

        assertEquals(2, result.size());
        assertEquals(200.0, result.get(0).getPrecio());
        assertEquals(150.0, result.get(1).getPrecio());
    }

    @Test
    void agruparPorCategoriaYStock_ShouldSumStock() {
        List<Producto> productos = List.of(
                new Producto("A", "Tech", 100.0, 10),
                new Producto("B", "Tech", 100.0, 5),
                new Producto("C", "Home", 100.0, 2));

        Map<String, Integer> result = productoService.agruparPorCategoriaYStock(productos);

        assertEquals(15, result.get("Tech"));
        assertEquals(2, result.get("Home"));
    }

    @Test
    void generarReporteProductos_ShouldFormatString() {
        List<Producto> productos = List.of(
                new Producto("Mouse", "Tech", 20.0, 1),
                new Producto("Teclado", "Tech", 50.0, 1));

        String result = productoService.generarReporteProductos(productos);

        assertTrue(result.contains("Mouse ($20.0)"));
        assertTrue(result.contains("Teclado ($50.0)"));
        assertTrue(result.contains("; "));
    }

    @Test
    void calcularPrecioPromedioGeneral_ShouldReturnAverage() {
        List<Producto> productos = List.of(
                new Producto("A", "C", 100.0, 1),
                new Producto("B", "C", 200.0, 1));

        Double result = productoService.calcularPrecioPromedioGeneral(productos);

        assertEquals(150.0, result);
    }
}
