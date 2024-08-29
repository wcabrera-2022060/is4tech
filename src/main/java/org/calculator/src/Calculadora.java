package org.calculator.src;

import java.util.ArrayList;

public class Calculadora {
    // La clase calculadora depende de lo que haga HistorialOperaciones para funcionar
    // Por lo que esto sera lo que simulemos con Mockito
    HistorialOperaciones historialOperaciones;

    public Calculadora(HistorialOperaciones historialOperaciones) {
        this.historialOperaciones = historialOperaciones;
    }

    public void calcular(Double numero1, Double numero2, Character operacion) {
        Operacion objeto = operacion == '+' ? new Suma() :
                operacion == '-' ? new Resta() :
                        operacion == '*' ? new Multiplicacion() :
                                operacion == '/' ? new Division() : null;

        if (objeto == null)
            throw new UnsupportedOperationException("Operador no soportado");

        historialOperaciones.agregarResultado(objeto.operacion(numero1, numero2));
    }
}
