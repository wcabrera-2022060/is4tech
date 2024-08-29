package org.calculator.CalculadoraTest;

import org.calculator.src.HistorialOperaciones;
import org.junit.jupiter.api.Test;
import org.calculator.src.Calculadora;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


// Complementando la información de la clase 'HistorialOperaciones'
// Como es la dependencia de Calculadora, puesto que suponemos que el arraylist en realidad es lógica
// Con estas pruebas solo queremos saber si lo que estamos mandando al método que se conectará, con algo externo
// es correcto

// En la clase main esta como funcionaría normalmente
@ExtendWith(MockitoExtension.class)
public class CalculadoraTest {

    // Dependencia a simular
    @Mock
    HistorialOperaciones historialOperaciones;

    @InjectMocks
    Calculadora calculadora;

    private final Double RESULTADO_SUMA = 15.0;
    private final Double RESULTADO_RESTA = -5.0;
    private final Double RESULTADO_MULTIPLICACION = 88.0;
    private final Double RESULTADO_DIVISION = 0.625;
    private final String MENSAJE_OPERACION_NO_SOPORTADA = "Operador no soportado";
    private final String MENSAJE_DIVISION_POR_CERO = "No se puede dividir por 0";
    private final ArrayList<Double> RESULTADOS = new ArrayList<>(List.of(
            RESULTADO_SUMA,
            RESULTADO_RESTA,
            RESULTADO_MULTIPLICACION,
            RESULTADO_DIVISION
    ));


    @Test
    public void sumaTest() {
        calculadora.calcular(10.0, 5.0, '+');

        ArgumentCaptor<Double> resultadoArgumento = ArgumentCaptor.forClass(Double.class);
        verify(historialOperaciones).agregarResultado(resultadoArgumento.capture());
        assertEquals(RESULTADO_SUMA, resultadoArgumento.getValue());
    }

    @Test
    public void restaTest() {
        calculadora.calcular(20.0, 25.0, '-');

        ArgumentCaptor<Double> resultadoArgumento = ArgumentCaptor.forClass(Double.class);
        verify(historialOperaciones).agregarResultado(resultadoArgumento.capture());
        assertEquals(RESULTADO_RESTA, resultadoArgumento.getValue());
    }

    @Test
    public void multiplicacionTest() {
        calculadora.calcular(11.0, 8.0, '*');

        ArgumentCaptor<Double> resultadoArgumento = ArgumentCaptor.forClass(Double.class);
        verify(historialOperaciones).agregarResultado(resultadoArgumento.capture());
        assertEquals(RESULTADO_MULTIPLICACION, resultadoArgumento.getValue());
    }

    @Test
    public void divisionTest() {
        calculadora.calcular(10.0, 16.0, '/');

        ArgumentCaptor<Double> resultadoArgumento = ArgumentCaptor.forClass(Double.class);
        verify(historialOperaciones).agregarResultado(resultadoArgumento.capture());
        assertEquals(RESULTADO_DIVISION, resultadoArgumento.getValue());
    }

    @Test
    public void divisionPorCeroTest() {
        try {
            calculadora.calcular(10.0, 0.0, '/');

            ArgumentCaptor<Double> resultadoArgumento = ArgumentCaptor.forClass(Double.class);
            verify(historialOperaciones).agregarResultado(resultadoArgumento.capture());
            assertEquals(RESULTADO_DIVISION, resultadoArgumento.getValue());
        } catch (ArithmeticException e) {
            assertEquals(MENSAJE_DIVISION_POR_CERO, e.getMessage());
        }
    }

    @Test
    public void operacionInvalidaTest() {
        try {
            calculadora.calcular(10.0, 16.0, '^');

            ArgumentCaptor<Double> resultadoArgumento = ArgumentCaptor.forClass(Double.class);
            verify(historialOperaciones).agregarResultado(resultadoArgumento.capture());
            assertEquals(RESULTADO_DIVISION, resultadoArgumento.getValue());
        } catch (UnsupportedOperationException e) {
            assertEquals(MENSAJE_OPERACION_NO_SOPORTADA, e.getMessage());
        }
    }
}
