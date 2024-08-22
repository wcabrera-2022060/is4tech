package org.calculator.src;

public class Division implements Operacion{
    @Override
    public Double operacion(Double num1, Double num2) {
        if(num2 == 0){
            throw new ArithmeticException("No se puede dividir por 0");
        }
        return num1 / num2;
    }
}
