package org.calculator.src;

import java.util.ArrayList;

// Esta clase simulara nuestra dependencia
// En el flujo normal del proyecto esto seria nuestra lógica que queremos se conecte a DB
// Pero al probar nuestros cambios no queremos modificar la base de datos
// Entonces esta clase no la usaremos, solo es para ejemplificar

public class HistorialOperaciones {
    private ArrayList<Double> operaciones = new ArrayList<>();

    public void agregarResultado(Double resultado) {
        System.out.println("NO llega a este punto en el test");
        operaciones.add(resultado);
    }

    public Double consultarResultado(Integer indice) {
        System.out.println("NO llega a este punto en el test");
        return operaciones.get(indice);
    }

    public ArrayList<Double> consultarResultados() {
        System.out.println("NO llega a este punto en el test");
        return operaciones;
    }
}
