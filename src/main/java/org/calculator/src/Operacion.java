package org.calculator.src;

public class Operacion {
    public Double suma(Double numero1, Double numero2) {
        return numero1 + numero2;
    }

    public Double resta(Double numero1, Double numero2) {
        return numero1 - numero2;
    }

    public Double multiplicacion(Double numero1, Double numero2) {
        return numero1 * numero2;
    }

    public Double division(Double numero1, Double numero2) {
        if (numero2 == 0) {
            throw new ArithmeticException("No se puede dividir por 0");
        }
        return numero1 / numero2;
    }
}
