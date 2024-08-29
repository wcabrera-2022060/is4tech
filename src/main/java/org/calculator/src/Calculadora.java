package org.calculator.src;

import java.util.ArrayList;

public class Calculadora extends Operacion {
    // La clase calculadora depende de lo que haga HistorialOperaciones para funcionar
    // Por lo que esto sera lo que simulemos con Mockito
    HistorialOperaciones historialOperaciones;

    public Calculadora(HistorialOperaciones historialOperaciones) {
        this.historialOperaciones = historialOperaciones;
    }

    public void calcular(Double numero1, Double numero2, Character operacion) {
        Double resultado = operacion == '+' ? suma(numero1, numero2) :
                operacion == '-' ? resta(numero1, numero2) :
                        operacion == '*' ? multiplicacion(numero1, numero2) :
                                operacion == '/' ? division(numero1, numero2) : null;

        if (resultado == null)
            throw new UnsupportedOperationException("Operador no soportado");

        historialOperaciones.agregarResultado(resultado);
    }
}
