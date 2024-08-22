package org.calculator.CalculadoraTest;

import org.junit.jupiter.api.Test;
import org.calculator.src.Calculadora;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CalculadoraTest {

    @InjectMocks
    Calculadora calculadora;

    private final Double RESULTADO_SUMA = 5.0;
    private final Double RESULTADO_RESTA = 5.0;
    private final Double RESULTADO_MULTIPLICACION = 10.0;
    private final Double RESULTADO_DIVISION = 5.0;
    private final String MENSAJE_OPERACION_NO_SOPORTADA = "Operador no soportado";
    private final String MENSAJE_DIVISION_POR_CERO = "No se puede dividir por 0";

    @Test
    public void sumaTest() {
        Double resultado = calculadora.operar(2.0, 3.0, '+');
        assertEquals(RESULTADO_SUMA, resultado);
    }

    @Test
    public void restaTest() {
        Double resultado = calculadora.operar(8.0, 3.0, '-');
        assertEquals(RESULTADO_RESTA, resultado);
    }

    @Test
    public void multiplicacionTest() {
        Double resultado = calculadora.operar(2.0, 5.0, '*');
        assertEquals(RESULTADO_MULTIPLICACION, resultado);
    }

    @Test
    public void divisionTest() {
        Double resultado = calculadora.operar(10.0, 2.0, '/');
        assertEquals(RESULTADO_DIVISION, resultado);
    }

    @Test
    public void divisionPorCeroTest() {
        ArithmeticException arithmeticException = assertThrows(
                ArithmeticException.class,
                () -> calculadora.operar(10.0, 0.0, '/')
        );
        assertEquals(MENSAJE_DIVISION_POR_CERO, arithmeticException.getMessage());
    }

    @Test
    public void operacionInvalidaTest() {
        UnsupportedOperationException exception = assertThrows(
                UnsupportedOperationException.class,
                () -> calculadora.operar(10.0, 2.0, '%')
        );
        assertEquals(MENSAJE_OPERACION_NO_SOPORTADA, exception.getMessage());
    }
}
