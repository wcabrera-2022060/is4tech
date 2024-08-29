package org.calculator.src;

public class Division extends Operacion{
    @Override
    public Double operacion(Double a, Double b) {
        if (b == 0)
            throw new ArithmeticException("No se puede dividir por 0");

        return a / b;
    }
}
