package com.tp.funcional.service;

import com.tp.funcional.model.Producto;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CasoProductoService {

    // 1. Listar los productos con precio mayor a 100, ordenados por precio
    // descendente.
    public List<Producto> listarProductosCaros(List<Producto> productos) {
        return productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparing(Producto::getPrecio).reversed())
                .collect(Collectors.toList());
    }

    // 2. Agrupar productos por categoría y calcular el stock total.
    public Map<String, Integer> agruparPorCategoriaYStock(List<Producto> productos) {
        return productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)));
    }

    // 3. Generar un String separando con “;” cada producto que contenga nombre y
    // precio.
    public String generarReporteProductos(List<Producto> productos) {
        return productos.stream()
                .map(p -> p.getNombre() + " ($" + p.getPrecio() + ")")
                .collect(Collectors.joining("; "));
    }

    // 4. Calcular el precio promedio general.
    public Double calcularPrecioPromedioGeneral(List<Producto> productos) {
        return productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);
    }

    // 4b. Calcular el precio promedio por categoría.
    public Map<String, Double> calcularPrecioPromedioPorCategoria(List<Producto> productos) {
        return productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)));
    }
}
