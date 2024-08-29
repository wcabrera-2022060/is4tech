package org.calculator.main;

import org.calculator.src.Calculadora;
import org.calculator.src.HistorialOperaciones;
import org.calculator.src.Operacion;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HistorialOperaciones historial = new HistorialOperaciones();
        Calculadora calculadora = new Calculadora(historial);
        calculadora.calcular(10.0, 5.0, '+');
        calculadora.calcular(20.0, 25.0, '-');
        calculadora.calcular(11.0, 8.0, '*');
        calculadora.calcular(10.0, 16.0, '/');

        ArrayList<Double> resultados = historial.consultarResultados();
        System.out.println("Resultados generales " + resultados);
    }
}