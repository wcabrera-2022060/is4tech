public class Ejercicio {

    public void ejercicio2(int[] arreglo1, int[] arreglo2) {
        int acumulador1 = 0;
        int acumulador2 = 0;
        int i = 0;
        while (true) {
            try {
                acumulador1 += arreglo1[i];
                i++;
            } catch (Exception e) {
                break;
            }
        }
        i = 0;
        while (true) {
            try {
                acumulador2 += arreglo2[i];
                i++;
            } catch (Exception e) {
                break;
            }
        }

        if (acumulador1 == acumulador2) {
            System.out.println("Los arreglos son iguales");
        } else {
            System.out.println("Los arreglos son diferentes");
        }
    }
}
