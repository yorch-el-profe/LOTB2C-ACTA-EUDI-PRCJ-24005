package org.bedu.netflix.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Las pruebas ayudan a demostrar que el código funciona.
 * 
 * NOTA: Por más pruebas que tenga el código siempre es propenso a errores.
 * 
 * Reglas del testing:
 * 
 * 1. Copiar la estructura de paquetes/carpetas/archivos original.
 * 
 * 2. Todos los métodos son de tipo void (los nombres de los métodos no importan).
 * 
 * 3. Las pruebas se tratan de los posibles casos (test cases) que puedan surgir
 * en mi código.
 * 
 * 4. Para escribir una prueba, vamos a seguir la técnica AAA:
 *  La prueba se divide en:
 *      a) Arrange - Precondiciones
 *      b) Act - La ejecución del código que queremos probar
 *      c) Assert - Verificación de los resultados
 *          Si la prueba cumple el resultado => PASS
 *          Si la prueba no cumple el resultado => FAIL
 * 
 * 5. Un error en producción (o de código) es una prueba NO ejecutada
 */

/**
 * Este tipo de prueba se le llamada Unit Testing.
 * 
 * 1. Smoke Testing: Verifica que un sistema o código "arranque".
 * 
 * 2. Unit Testing: Probar piezas aisladas de código. No se realizan
 * conexiones, ni consultas reales, todo se "falsifica" (mockea).
 * 
 * 3. Integration Testing: Probar piezas juntas (2 o más) y se realizan
 * conexiones o consultas sobre ambientes de prueba.
 * 
 * 4. E2E (End-to-end) Testing: Probar flujos completos en un ambiente
 * lo más real posible. Se deben de considerar los flujos más importantes del proyecto.
 */
public class CalculatorTest {
    
    @Test
    @DisplayName("La suma de 0 + 0 es 0")
    public void zeroSum() {
        // Arrange
        int a = 0;
        int b = 0;

        // Act
        int result = Calculator.sum(a, b);

        // Assert
        // Esperariamos que el resulto fuera 0
        assertEquals(0, result);
    }

    @Test
    @DisplayName("La suma de N + 0 es N y la suyma de 0 + N es N")
    public void sumZero() {
        int n = 100;

        int result1 = Calculator.sum(n, 0);
        int result2 = Calculator.sum(0, n);

        // En una sola prueba puedo tener varios asserts
        assertEquals(n, result1);
        assertEquals(n, result2);
    }


    @Test
    @DisplayName("La division de N/1 es N")
    public void divOne() {
        int n = 500;

        int result = Calculator.div(n, 1);

        assertEquals(n, result);
    }

    @Test
    @DisplayName("La division entre 0 debe lanzar una excepcion")
    public void divError() {
        // AssertThrows verifica que se lance la excepción especificada
       assertThrows(ArithmeticException.class, () -> {
            Calculator.div(100, 0);
       });
    }
}