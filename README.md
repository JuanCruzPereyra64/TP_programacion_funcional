# Trabajo Práctico - Programación Funcional en Java

Este repositorio contiene la resolución del Trabajo Práctico de Programación Funcional, implementado con **Spring Boot**, **Lombok** y **Java Streams**.

## 📋 Descripción
El proyecto resuelve 4 casos prácticos aplicando conceptos de programación funcional:
1.  **Alumnos**: Filtrado, mapeo y agrupación de notas.
2.  **Productos**: Estadísticas de precios y stock.
3.  **Libros**: Búsqueda y conteo por autor.
4.  **Empleados**: Cálculos de salarios y filtros por edad.

## 🛠️ Tecnologías
-   Java 17
-   Spring Boot 3.2.0
-   Gradle
-   Lombok
-   JUnit 5 + Mockito

## 🚀 Cómo Ejecutar

### Requisitos
-   Tener instalado Java 17 (JDK).
-   Tener Gradle instalado (o usar el wrapper si se genera).

### Ejecución desde Consola
Para ejecutar la aplicación y ver los resultados de los 4 casos en la consola:

```bash
gradle bootRun
```

### Ejecución de Pruebas
Para correr los tests unitarios y verificar la lógica:

```bash
gradle test
```

## 📂 Estructura del Proyecto
-   `src/main/java/com/tp/funcional/model`: Clases de dominio (Alumno, Producto, etc.) con Lombok.
-   `src/main/java/com/tp/funcional/service`: Lógica de negocio con Streams.
-   `src/main/java/com/tp/funcional/TpFuncionalApplication.java`: Clase principal que ejecuta los casos.
-   `src/test/java`: Pruebas unitarias con Mockito.

## 👤 Autor
[Tu Nombre]
