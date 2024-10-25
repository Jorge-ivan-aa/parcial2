package co.edu.uniquindio.programacion3.parcial2.ejercio2Hilos;

public class Hilo1 extends Thread{
    boolean runHilo1;
    int numeroMenor;

    public Hilo1(){
        this.runHilo1 = true;
    }
    public int getNumeroMenor(){
        return numeroMenor;
    }

    int[][] m = {

            {60 ,22, 41, 5, 2},
            {13, 33, 44, 5, 3},
            {89, 10, 100, 99, 1},

    };
    int tamaño = calcularTamaño(m);

    @Override
    public void run(){
        System.out.println("Hilo 1 iniciado.");
        //S1
        numeroMenor=recorrer(m,0,0);
        int contador =0;
        while (runHilo1){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(contador ==15)
                runHilo1 = false;
            contador++;
        }
        System.out.println("El numero menor es: " + numeroMenor);
        System.out.println("Hilo 1 terminado.");

    }

    public int recorrer(int [][]m, int i, int j){


        int numeroMenor= m[i][j];

        if (i!=m.length-1 || j!=m[i].length-1){


            if(j==m[i].length-1){

                i++;
                j=0;

            }else{
                j++;
            }
            int numeroMenor2= recorrer(m,i,j);

            if (numeroMenor2 < numeroMenor) {
                numeroMenor = numeroMenor2;

            }

        }

        return numeroMenor;

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