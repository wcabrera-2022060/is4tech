package org.calculator.src;

public class Calculadora {

    public Calculadora() {
    }

    public Double operar(Double num1, Double num2, Character op) {
        Operacion operacion = op == '+' ? new Suma() :
                op == '-' ? new Resta() :
                        op == '*' ? new Multiplicacion() :
                                op == '/' ? new Division() : null;

        if (operacion == null) {
            throw new UnsupportedOperationException("Operador no soportado");
        }
        Double resultado = operacion.operacion(num1, num2);
        return resultado;
    }
}
