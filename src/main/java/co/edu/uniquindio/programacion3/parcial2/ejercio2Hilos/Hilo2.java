package co.edu.uniquindio.programacion3.parcial2.ejercio2Hilos;

public class Hilo2 extends Thread {
    boolean runHilo2;
    Double promedioMatriz;

    public Double getPromedioMatriz(){
        return promedioMatriz;
    }
    public Hilo2(){
        this.runHilo2 = true;
    }

    int[][] m = {

            {60 ,22, 41, 5, 2},
            {13, 33, 44, 5, 3},
            {89, 10, 100, 99, 1},

    };
    int veces=calcularTamaño(m);
    @Override
    public void run(){
        System.out.println("Hilo 2 iniciado.");
        //S2
        promedioMatriz = Double.valueOf(recorrerMatriz(m)/veces);

        int contador =0;
        while (runHilo2){

            try {

                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(contador ==veces)
                runHilo2 = false;
            contador++;
        }
        System.out.println("Promedio de la matriz: " + promedioMatriz);
        System.out.println("Hilo 2 terminado.");

    }

    public int recorrerMatriz(int [][]m){

        int suma =0;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                suma+=m[i][j];

            }

        }

        return suma;

    }

    public int calcularTamaño(int[][] m) {
        if (m == null || m.length == 0) {
            return 0;
        }

        int filas = m.length;
        int columnas = m[0].length;

        return filas * columnas;
    }

}