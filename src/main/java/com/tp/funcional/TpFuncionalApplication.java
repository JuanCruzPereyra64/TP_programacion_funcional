package com.tp.funcional;

import com.tp.funcional.model.Alumno;
import com.tp.funcional.model.Empleado;
import com.tp.funcional.model.Libro;
import com.tp.funcional.model.Producto;
import com.tp.funcional.service.CasoAlumnoService;
import com.tp.funcional.service.CasoEmpleadoService;
import com.tp.funcional.service.CasoLibroService;
import com.tp.funcional.service.CasoProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class TpFuncionalApplication implements CommandLineRunner {

    private final CasoAlumnoService alumnoService;
    private final CasoProductoService productoService;
    private final CasoLibroService libroService;
    private final CasoEmpleadoService empleadoService;

    public static void main(String[] args) {
        SpringApplication.run(TpFuncionalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== INICIO TRABAJO PRÁCTICO FUNCIONAL ===");

        ejecutarCaso1();
        ejecutarCaso2();
        ejecutarCaso3();
        ejecutarCaso4();

        System.out.println("\n=== FIN TRABAJO PRÁCTICO FUNCIONAL ===");
    }

    private void ejecutarCaso1() {
        System.out.println("\n--- CASO 1: ALUMNOS ---");
        List<Alumno> alumnos = List.of(
                new Alumno("Juan", 8.5, "Matemáticas"),
                new Alumno("Pedro", 4.0, "Historia"),
                new Alumno("Maria", 9.0, "Matemáticas"),
                new Alumno("Ana", 7.0, "Historia"),
                new Alumno("Luis", 6.5, "Física"));

        System.out.println("1. Aprobados (Mayúsculas): " + alumnoService.obtenerNombresAprobados(alumnos));
        System.out.println("2. Promedio General: " + alumnoService.calcularPromedioGeneral(alumnos));
        System.out.println("3. Agrupados por Curso: " + alumnoService.agruparPorCurso(alumnos));
        System.out.println("4. Mejores 3 Promedios: " + alumnoService.obtenerMejoresPromedios(alumnos));
    }

    private void ejecutarCaso2() {
        System.out.println("\n--- CASO 2: PRODUCTOS ---");
        List<Producto> productos = List.of(
                new Producto("Laptop", "Tecnología", 1200.0, 10),
                new Producto("Mouse", "Tecnología", 25.0, 50),
                new Producto("Teclado", "Tecnología", 45.0, 30),
                new Producto("Silla", "Muebles", 150.0, 5),
                new Producto("Escritorio", "Muebles", 200.0, 3));

        System.out.println("1. Productos > 100: " + productoService.listarProductosCaros(productos));
        System.out.println("2. Stock por Categoría: " + productoService.agruparPorCategoriaYStock(productos));
        System.out.println("3. Reporte: " + productoService.generarReporteProductos(productos));
        System.out.println("4. Promedio General: " + productoService.calcularPrecioPromedioGeneral(productos));
        System.out.println(
                "4b. Promedio por Categoría: " + productoService.calcularPrecioPromedioPorCategoria(productos));
    }

    private void ejecutarCaso3() {
        System.out.println("\n--- CASO 3: LIBROS ---");
        List<Libro> libros = List.of(
                new Libro("El Señor de los Anillos", "Tolkien", 1200, 50.0),
                new Libro("Harry Potter", "Rowling", 350, 40.0),
                new Libro("El Principito", "Saint-Exupéry", 90, 15.0),
                new Libro("Cien Años de Soledad", "García Márquez", 400, 35.0),
                new Libro("1984", "Orwell", 320, 20.0));

        System.out.println("1. Libros Largos (>300 pag): " + libroService.listarTitulosLibrosLargos(libros));
        System.out.println("2. Promedio Páginas: " + libroService.calcularPromedioPaginas(libros));
        System.out.println("3. Conteo por Autor: " + libroService.contarLibrosPorAutor(libros));
        System.out.println("4. Libro Más Caro: " + libroService.obtenerLibroMasCaro(libros).orElse(null));
    }

    private void ejecutarCaso4() {
        System.out.println("\n--- CASO 4: EMPLEADOS ---");
        List<Empleado> empleados = List.of(
                new Empleado("Carlos", "IT", 3000.0, 30),
                new Empleado("Ana", "HR", 2500.0, 28),
                new Empleado("Luis", "IT", 1800.0, 25),
                new Empleado("Marta", "Ventas", 2200.0, 35),
                new Empleado("Pedro", "Ventas", 1900.0, 22));

        System.out.println("1. Salario > 2000: " + empleadoService.listarEmpleadosSalarioAlto(empleados));
        System.out.println("2. Salario Promedio: " + empleadoService.calcularSalarioPromedio(empleados));
        System.out.println("3. Suma Salarios por Depto: " + empleadoService.sumarSalariosPorDepartamento(empleados));
        System.out.println("4. 2 Más Jóvenes: " + empleadoService.obtenerEmpleadosMasJovenes(empleados));
    }
}
