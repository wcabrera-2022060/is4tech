package org.calculator.src;

public class Multiplicacion implements Operacion {
    @Override
    public Double operacion(Double num1, Double num2) {
        return num1 * num2;
    }
}
